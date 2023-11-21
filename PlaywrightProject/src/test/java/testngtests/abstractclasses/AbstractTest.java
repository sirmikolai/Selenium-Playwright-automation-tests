package testngtests.abstractclasses;

import com.mailosaur.MailosaurException;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ViewportSize;
import core.PomParams;
import core.browser.BrowserType;
import core.browser.PlaywrightBrowser;
import core.browserfactory.ChromeBrowserFactory;
import core.browserfactory.EdgeBrowserFactory;
import core.browserfactory.FirefoxBrowserFactory;
import core.browserfactory.WebkitBrowserFactory;
import models.User;
import models.enums.UserGroup;
import models.testngpages.AbstractPage;
import models.testngpages.MainPage;
import models.testngpages.carbrand.CarBrandsBrowsePage;
import models.testngpages.signin.SignInFormPage;
import models.testngpages.signup.SignUpFormPage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.Assertions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static core.mailosaur.MailosaurMessageManager.getLinkFromMessage;
import static core.mailosaur.MailosaurServerManager.getEmailByRecipientName;
import static models.enums.SystemAlerts.*;
import static utils.LogBinder.bindLogName;
import static utils.LogBinder.unbind;

public abstract class AbstractTest implements PomParams {

    private static final Log logger = LogFactory.getLog(AbstractTest.class);

    private Playwright playwright;
    private Browser browser;
    public Page playwrightPage;
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
    private final String baseUrl = getBaseUrl();
    protected MainPage mainPage;
    protected CarBrandsBrowsePage carBrandsBrowsePage;
    protected User existedAdminUser = new User.UserBuilder(UserGroup.ADMIN).build();
    protected User existedSimpleUser = new User.UserBuilder(UserGroup.USER).build();
    private String testClassName;

    public void setUp(ITestContext iTestContext) {
        logger.info("Playwright starting");
        this.testClassName = iTestContext.getAllTestMethods()[0].getTestClass().getName().substring(StringUtils.lastIndexOf(iTestContext.getAllTestMethods()[0].getTestClass().getName(), ".") + 1);
        bindLogName(testClassName);
        this.playwright = Playwright.create();
        this.browser = getBrowser(playwright);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(getViewportSize()));
        this.playwrightPage = context.newPage();
        threadLocalPage.set(playwrightPage);
        playwrightPage.onDialog(Dialog::accept);
        mainPage = openPageWithUrl(baseUrl, MainPage.class);
        assertThatMainPageIsVisible();
        carBrandsBrowsePage = new CarBrandsBrowsePage(playwrightPage);
    }

    private Browser getBrowser(Playwright playwright) {
        BrowserType browserType = getBrowserType();
        switch (browserType) {
            case FIREFOX:
                return new PlaywrightBrowser(new FirefoxBrowserFactory()).getBrowser(playwright);
            case EDGE:
                return new PlaywrightBrowser(new EdgeBrowserFactory()).getBrowser(playwright);
            case WEBKIT:
                return new PlaywrightBrowser(new WebkitBrowserFactory()).getBrowser(playwright);
            default:
                return new PlaywrightBrowser(new ChromeBrowserFactory()).getBrowser(playwright);
        }
    }

    public static Page getPageFromThreadLocal() {
        return threadLocalPage.get();
    }

    private ViewportSize getViewportSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        return new ViewportSize(width, height);
    }

    protected  <T extends AbstractPage> T openPageWithUrl(String url, Class<T> clazz) {
        logger.info(String.format("Opening page with url: %s", url));
        playwrightPage.navigate(url, new Page.NavigateOptions().setTimeout(100000));
        T page = null;
        try {
            page = clazz.getDeclaredConstructor(Page.class).newInstance(this.playwrightPage);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return page;
    }

    protected void signUp(User user) throws IOException, MailosaurException {
        SignUpFormPage signUpFormPage = mainPage.goToSignUpForm();
        signUpFormPage.inputEmail(user.getEmail());
        signUpFormPage.inputPassword(user.getPassword());
        signUpFormPage.inputPasswordConfirmation(user.getPassword());
        signUpFormPage.selectTermsAndConditionsCheckbox();
        signUpFormPage.clickSignUp();
        assertThatFormWasValidatedWithSuccess(true);
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_REGISTRATION_TEXT.getAlertText());
        String confirmationUrl = getLinkFromMessage(getEmailByRecipientName(user.getEmail()));
        mainPage = openPageWithUrl(confirmationUrl, MainPage.class);
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT.getAlertText());
    }

    protected void signIn(User user, boolean... withError) {
        SignInFormPage signInFormPage = mainPage.goToSignInForm();
        signInFormPage.inputEmail(user.getEmail());
        signInFormPage.inputPassword(user.getPassword());
        signInFormPage.clickSignIn();
        assertThatFormWasValidatedWithSuccess(true);
        if (withError.length == 0) {
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_LOGIN_TEXT.getAlertText());
        } else {
            assertThatDangerAlertHasExpectedText(DANGER_ALERT_INVALID_CREDENTIALS_TEXT.getAlertText());
        }
    }

    protected void signOut() {
        mainPage.clickSignOut();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_SIGN_OUT_TEXT.getAlertText());
    }

    protected void assertThatSuccessAlertHasExpectedText(String text) {
        Assertions.assertThat(mainPage.isSuccessAlertVisibleWithExpectedText(text))
                .as("Assert that success alert has text: " + text)
                .isTrue();
    }

    protected void assertThatDangerAlertHasExpectedText(String text) {
        Assertions.assertThat(mainPage.isDangerAlertVisibleWithExpectedText(text))
                .as("Assert that danger alert has text: " + text)
                .isTrue();
    }

    protected void assertThatFormWasValidatedWithSuccess(boolean withSuccess) {
        Assertions.assertThat(mainPage.isFormWasValidatedWithSuccess())
                .as("Assert that form was validated with success: " + withSuccess)
                .isEqualTo(withSuccess);
    }

    protected void assertThatMainPageIsVisible() {
        Assertions.assertThat(mainPage.isMainPageVisible())
                .as("Assert that main page is visible")
                .isTrue();
    }


    @BeforeClass
    public void initialize(ITestContext iTestContext) {
        setUp(iTestContext);
    }

    @AfterClass(alwaysRun = true)
    public void closePage() {
        logger.info("Playwright quitting");
        playwrightPage.close();
        browser.close();
        playwright.close();
        threadLocalPage.remove();
        unbind();
    }
}
