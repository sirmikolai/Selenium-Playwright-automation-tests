package testngtests.abstractclasses;

import com.mailosaur.MailosaurException;
import core.PomParams;
import core.browser.Browser;
import core.browser.BrowserType;
import core.waits.SeleniumWait;
import core.webdriver.*;
import models.User;
import models.UserGroup;
import models.testngpages.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static core.mailosaur.MailosaurMessageManager.getLinkFromMessage;
import static core.mailosaur.MailosaurServerManager.getEmailByRecipientName;


public abstract class AbstractTest implements PomParams {

    private WebDriver driver;
    private SeleniumWait seleniumWait;
    private static final String BASE_URL = "https://car-info-app.onrender.com/";
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
        this.driver = getBrowser();
        this.seleniumWait = new SeleniumWait(driver);
        mainPage = openPageWithUrl(BASE_URL, MainPage.class);
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

    protected  <T extends AbstractPage> T openPageWithUrl(String url, Class<T> clazz) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
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
        Assert.assertTrue(mainPage.isFormWasValidatedWithSuccess());
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_REGISTRATION_TEXT);
        String confirmationUrl = getLinkFromMessage(getEmailByRecipientName(user.getEmail()));
        mainPage = openPageWithUrl(confirmationUrl, MainPage.class);
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT);
    }

    protected void signIn(User user, boolean... withError) {
        SignInFormPage signInFormPage = mainPage.goToSignInForm();
        signInFormPage.inputEmail(user.getEmail());
        signInFormPage.inputPassword(user.getPassword());
        signInFormPage.clickSignIn();
        Assert.assertTrue(mainPage.isFormWasValidatedWithSuccess());
        if (withError.length == 0) {
            Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_LOGIN_TEXT);
        } else {
            Assert.assertEquals(mainPage.getTextFromDangerAlert(), DANGER_ALERT_INVALID_EMAIL_TEXT);
        }
    }

    protected void signOut() {
        mainPage.clickSignOut();
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_SIGN_OUT_TEXT);
    }

    @BeforeClass
    public void initialize(ITestContext iTestContext) {
        startTime = System.currentTimeMillis();
        setUp(iTestContext);
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        endTime = System.currentTimeMillis();
        double testExecutionTimeInSeconds = (endTime - startTime)/1000.0;
        System.out.println("Czas wykonania testu " + testClassName + " (" + getBrowserType() + ") " +
                "- numer próby (" + attemptNumber + "): " + testExecutionTimeInSeconds + " [s]" );
    }
}
