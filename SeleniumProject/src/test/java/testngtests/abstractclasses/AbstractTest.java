package testngtests.abstractclasses;

import com.mailosaur.MailosaurException;
import core.PomParams;
import core.browser.Browser;
import core.browser.BrowserType;
import core.waits.SeleniumWait;
import core.webdriver.*;
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static core.mailosaur.MailosaurMessageManager.getLinkFromMessage;
import static core.mailosaur.MailosaurServerManager.getEmailByRecipientName;
import static models.enums.SystemAlerts.*;
import static utils.LogBinder.bindLogName;
import static utils.LogBinder.unbind;


public abstract class AbstractTest implements PomParams {

    private static final Log logger = LogFactory.getLog(AbstractTest.class);

    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private SeleniumWait seleniumWait;
    private static final String BASE_URL = "https://car-info-app.onrender.com/";
    protected MainPage mainPage;
    protected CarBrandsBrowsePage carBrandsBrowsePage;
    protected User existedAdminUser = new User.UserBuilder(UserGroup.ADMIN).build();
    protected User existedSimpleUser = new User.UserBuilder(UserGroup.USER).build();
    private String testClassName;

    public void setUp(ITestContext iTestContext) {
        logger.info("Driver starting");
        this.testClassName = iTestContext.getAllTestMethods()[0].getTestClass().getName().substring(StringUtils.lastIndexOf(iTestContext.getAllTestMethods()[0].getTestClass().getName(), ".") + 1);
        bindLogName(testClassName);
        this.driver = getBrowser();
        threadLocalDriver.set(driver);
        this.seleniumWait = new SeleniumWait(driver);
        maximizeWindow();
        mainPage = openPageWithUrl(BASE_URL, MainPage.class);
        assertThatMainPageIsVisible();
        carBrandsBrowsePage = new CarBrandsBrowsePage(driver);
    }

    private WebDriver getBrowser() {
        BrowserType browserType = getBrowserType();
        switch (browserType) {
            case FIREFOX:
                return new Browser(new FirefoxDriverFactory()).getDriver();
            case EDGE:
                return new Browser(new EdgeDriverFactory()).getDriver();
            case IE:
                return new Browser(new IeDriverFactory()).getDriver();
            case SAFARI:
                return new Browser(new SafariDriverFactory()).getDriver();
            default:
                return new Browser(new ChromeDriverFactory()).getDriver();
        }
    }

    public static WebDriver getDriverFromThreadLocal() {
        return threadLocalDriver.get();
    }

    private void maximizeWindow() {
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().maximize();
    }

    protected  <T extends AbstractPage> T openPageWithUrl(String url, Class<T> clazz) {
        logger.info(String.format("Opening page with url: %s", url));
        driver.manage().deleteAllCookies();
        driver.get(url);
        T page = null;
        try {
            page = clazz.getDeclaredConstructor(WebDriver.class).newInstance(driver);
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
    public void quitDriver() {
        logger.info("Driver quitting");
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
            unbind();
        }
    }
}
