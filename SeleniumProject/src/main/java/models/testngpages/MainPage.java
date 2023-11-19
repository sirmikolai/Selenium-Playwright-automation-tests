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
    private static final String NAV_BAR_EXPANDER_BUTTON_CSS = "button[class*='navbar-toggler']";
    private static final String NAV_BAR_EXPANDED_CSS = NAV_BAR_EXPANDER_BUTTON_CSS + "[aria-expanded='true']";
    private static final String SIGN_IN_BUTTON_CSS = "a[href='/sign-in-form']";
    private static final String SIGN_UP_BUTTON_CSS = "a[href='/sign-up-form']";
    private static final String SIGN_OUT_BUTTON_CSS = "a[href='/sign-out']";
    private static final String RESET_PASSWORD_BUTTON_CSS = "a[href='/reset-password-form']";
    private static final String ADMIN_PANEL_BUTTON_CSS = "a[href='/admin-panel']";
    private static final String SUCCESS_ALERT_WITH_TEXT_XPATH = "//div[@class='alert alert-success']//span[contains(text(),\"%s\")]";
    private static final String DANGER_ALERT_WITH_TEXT_XPATH = "//div[@class='alert alert-danger']//span[contains(text(),\"%s\")]";
    private static final String FORM_WAS_VALIDATED_CSS = "form[class*='was-validated']";
    private static final String ADD_CAR_BRAND_CSS = "a[href='/car-brand/add-form']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private MainPage expandNavBarIfNotExpanded() {
        logger.info("Expand Nav Bar if not expanded");
        if (isElementDisplayedOnThePage(By.cssSelector(NAV_BAR_EXPANDER_BUTTON_CSS), 1) &&
                !isElementDisplayedOnThePage(By.cssSelector(NAV_BAR_EXPANDED_CSS), 1)) {
            clickElement(By.cssSelector(NAV_BAR_EXPANDER_BUTTON_CSS));
            seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(NAV_BAR_EXPANDED_CSS)));
        }
        return this;
    }

    public SignInFormPage goToSignInForm() {
        logger.info("Go to Sign In form");
        expandNavBarIfNotExpanded();
        clickElement(By.cssSelector(SIGN_IN_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInFormPage.ROOT_CSS)));
        return new SignInFormPage(driver);
    }

    public SignUpFormPage goToSignUpForm() {
        logger.info("Go to Sign Up form");
        expandNavBarIfNotExpanded();
        clickElement(By.cssSelector(SIGN_UP_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignUpFormPage.ROOT_CSS)));
        return new SignUpFormPage(driver);
    }

    public MainPage clickSignOut() {
        logger.info("Click 'Sign out' button");
        expandNavBarIfNotExpanded();
        clickElement(By.cssSelector(SIGN_OUT_BUTTON_CSS));
        return this;
    }

    public ResetPasswordFormPage goToResetPasswordForm() {
        logger.info("Go to Reset password form");
        expandNavBarIfNotExpanded();
        clickElement(By.cssSelector(RESET_PASSWORD_BUTTON_CSS));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ResetPasswordFormPage.ROOT_CSS)));
        return new ResetPasswordFormPage(driver);
    }

    public AdminPanelPage goToAdminPanel() {
        logger.info("Go to Admin panel");
        expandNavBarIfNotExpanded();
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
        expandNavBarIfNotExpanded();
        return isElementDisplayedOnThePage(By.cssSelector(ADMIN_PANEL_BUTTON_CSS), 1);
    }

    public boolean isSuccessAlertVisibleWithExpectedText(final String expectedText) {
        logger.info("Check if success alert has expected text");
        seleniumWait.waitForPageInitialization();
        return isElementDisplayedOnThePage(By.xpath(String.format(SUCCESS_ALERT_WITH_TEXT_XPATH, expectedText)), 5);
    }

    public boolean isDangerAlertVisibleWithExpectedText(final String expectedText) {
        logger.info("Check if danger alert has expected text");
        seleniumWait.waitForPageInitialization();
        return isElementDisplayedOnThePage(By.xpath(String.format(DANGER_ALERT_WITH_TEXT_XPATH, expectedText)), 5);
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
