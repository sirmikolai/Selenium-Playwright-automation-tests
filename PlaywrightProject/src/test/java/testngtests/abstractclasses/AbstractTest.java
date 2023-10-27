package testngtests.abstractclasses;

import com.mailosaur.MailosaurException;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import core.PomParams;
import core.browser.PlaywrightBrowser;
import core.browser.BrowserType;
import core.browserfactory.*;
import models.User;
import models.UserGroup;
import models.testngpages.*;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static core.mailosaur.MailosaurMessageManager.getLinkFromMessage;
import static core.mailosaur.MailosaurServerManager.getEmailByRecipientName;


public abstract class AbstractTest implements PomParams {

    private Playwright playwright;
    private Browser browser;
    private Page playwrightPage;
    private static final String BASE_URL = "http://localhost:3000";
    protected MainPage mainPage;
    protected CarBrandsBrowsePage carBrandsBrowsePage;
    protected User existedAdminUser = new User.UserBuilder(UserGroup.ADMIN).build();
    protected User existedSimpleUser = new User.UserBuilder(UserGroup.USER).build();
    protected static final String SUCCESS_ALERT_REGISTRATION_TEXT = "Success! Confirmation email has been sent. Check your spam folder as well just in case.";
    protected static final String SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT = "Success! Your account has been activated! Now, you can sign in.";
    protected static final String SUCCESS_ALERT_LOGIN_TEXT = "Success! You have been signed in correctly.";
    protected static final String DANGER_ALERT_INVALID_EMAIL_TEXT = "Error! Invalid email address.";
    protected static final String SUCCESS_ALERT_SIGN_OUT_TEXT = "Success! You have been signed out correctly.";
    protected static final String SUCCESS_ALERT_USER_REMOVED_TEXT = "Success! User has been removed.";
    protected static final String SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT = "Success! Car brand has been added.";
    protected static final String SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT = "Success! Car brand has been removed.";
    private String attemptNumber;
    private String testClassName;
    private double startTime;
    private double endTime;

    public void setUp(ITestContext iTestContext) {
        this.testClassName = iTestContext.getAllTestMethods()[0].getTestClass().getName().substring(StringUtils.lastIndexOf(iTestContext.getAllTestMethods()[0].getTestClass().getName(), ".") + 1);
        this.attemptNumber = iTestContext.getName();
        this.playwright = Playwright.create();
        this.browser = getBrowser(playwright);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        this.playwrightPage = context.newPage();
        mainPage = openPageWithUrl(BASE_URL, MainPage.class);
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

    protected  <T extends AbstractPage> T openPageWithUrl(String url, Class<T> clazz) {
        playwrightPage.navigate(url);
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
        Assertions.assertThat(mainPage.isFormWasValidatedWithSuccess()).isTrue();
        Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_REGISTRATION_TEXT);
        String confirmationUrl = getLinkFromMessage(getEmailByRecipientName(user.getEmail()));
        mainPage = openPageWithUrl(confirmationUrl, MainPage.class);
        Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT);
    }

    protected void signIn(User user, boolean... withError) {
        SignInFormPage signInFormPage = mainPage.goToSignInForm();
        signInFormPage.inputEmail(user.getEmail());
        signInFormPage.inputPassword(user.getPassword());
        signInFormPage.clickSignIn();
        Assert.assertTrue(mainPage.isFormWasValidatedWithSuccess());
        if (withError.length == 0) {
            Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_LOGIN_TEXT);
        } else {
            Assertions.assertThat(mainPage.getTextFromDangerAlert()).contains(DANGER_ALERT_INVALID_EMAIL_TEXT);
        }
    }

    protected void signOut() {
        mainPage.clickSignOut();
        Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_SIGN_OUT_TEXT);
    }

    @BeforeClass
    public void initialize(ITestContext iTestContext) {
        startTime = System.currentTimeMillis();
        setUp(iTestContext);
    }

    @AfterClass(alwaysRun = true)
    public void closePage() {
        playwrightPage.close();
        browser.close();
        playwright.close();

        endTime = System.currentTimeMillis();
        double testExecutionTimeInSeconds = (endTime - startTime)/1000.0;
        System.out.println("Czas wykonania testu " + testClassName + " (" + getBrowserType() + ") " +
                "- numer próby (" + attemptNumber + "): " + testExecutionTimeInSeconds + " [s]" );
    }
}
