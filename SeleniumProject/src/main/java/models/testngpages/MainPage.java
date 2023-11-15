package models.testngpages;

import models.testngpages.adminpanel.AdminPanelPage;
import models.testngpages.carbrand.CarBrandFormPage;
import models.testngpages.resetpassword.ResetPasswordFormPage;
import models.testngpages.signin.SignInFormPage;
import models.testngpages.signup.SignUpFormPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    private static final Log logger = LogFactory.getLog(MainPage.class);

    public static final String ROOT_CSS = "div[class='album py-5 bg-light']";
    private static final String SIGN_IN_BUTTON_CSS = "a[href='/sign-in-form']";
    private static final String SIGN_UP_BUTTON_CSS = "a[href='/sign-up-form']";
    private static final String SIGN_OUT_BUTTON_CSS = "a[href='/sign-out']";
    private static final String RESET_PASSWORD_BUTTON_CSS = "a[href='/reset-password-form']";
    private static final String ADMIN_PANEL_BUTTON_CSS = "a[href='/admin-panel']";
    private static final String SUCCESS_ALERT_CSS = "div[class='alert alert-success']";
    private static final String DANGER_ALERT_CSS = "div[class='alert alert-danger']";
    private static final String FORM_WAS_VALIDATED_CSS = "form[class*='was-validated']";
    private static final String ADD_CAR_BRAND_CSS = "a[href='/car-brand/add-form']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SignInFormPage goToSignInForm() {
        logger.info("Go to Sign In form");
        clickElement(By.cssSelector(SIGN_IN_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInFormPage.ROOT_CSS)));
        return new SignInFormPage(driver);
    }

    public SignUpFormPage goToSignUpForm() {
        logger.info("Go to Sign Up form");
        clickElement(By.cssSelector(SIGN_UP_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignUpFormPage.ROOT_CSS)));
        return new SignUpFormPage(driver);
    }

    public MainPage clickSignOut() {
        logger.info("Click 'Sign out' button");
        clickElement(By.cssSelector(SIGN_OUT_BUTTON_CSS));
        return this;
    }

    public ResetPasswordFormPage goToResetPasswordForm() {
        logger.info("Go to Reset password form");
        clickElement(By.cssSelector(RESET_PASSWORD_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ResetPasswordFormPage.ROOT_CSS)));
        return new ResetPasswordFormPage(driver);
    }

    public AdminPanelPage goToAdminPanel() {
        logger.info("Go to Admin panel");
        clickElement(By.cssSelector(ADMIN_PANEL_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdminPanelPage.ROOT_XPATH)));
        return new AdminPanelPage(driver);
    }

    public CarBrandFormPage clickAddCarBrand() {
        logger.info("Click 'Add car brand' button");
        clickElement(By.cssSelector(ADD_CAR_BRAND_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarBrandFormPage.ROOT_CSS)));
        return new CarBrandFormPage(driver);
    }

    public boolean isAdminPanelButtonVisible() {
        logger.info("Check if Admin panel button is visible");
        return isElementDisplayedOnThePage(By.cssSelector(ADMIN_PANEL_BUTTON_CSS), 1);
    }

    public String getTextFromSuccessAlert() {
        logger.info("Get text from success alert");
        seleniumWait.waitForPageInitialization();
        return getTextFromElement(By.cssSelector(SUCCESS_ALERT_CSS));
    }

    public String getTextFromDangerAlert() {
        logger.info("Get text from danger alert");
        seleniumWait.waitForPageInitialization();
        return getTextFromElement(By.cssSelector(DANGER_ALERT_CSS));
    }

    public boolean isFormWasValidatedWithSuccess() {
        logger.info("Check if Form was validated with success");
        return !isElementDisplayedOnThePage(By.cssSelector(FORM_WAS_VALIDATED_CSS), 1);
    }

    public boolean isMainPageVisible() {
        logger.info("Check if Main Page is visible");
        return isElementDisplayedOnThePage(By.cssSelector(ROOT_CSS), 100);
    }
}
