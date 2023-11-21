package models.testngpages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.testngpages.adminpanel.AdminPanelPage;
import models.testngpages.carbrand.CarBrandFormPage;
import models.testngpages.resetpassword.ResetPasswordFormPage;
import models.testngpages.signin.SignInFormPage;
import models.testngpages.signup.SignUpFormPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

    public MainPage(Page playwrightPage) {
        super(playwrightPage);
    }

    private MainPage expandNavBarIfNotExpanded() {
        logger.info("Expand Nav Bar if not expanded");
        if (isElementDisplayedOnThePage(NAV_BAR_EXPANDER_BUTTON_CSS, 1) &&
                !isElementDisplayedOnThePage(NAV_BAR_EXPANDED_CSS, 1)) {
            clickElement(NAV_BAR_EXPANDER_BUTTON_CSS);
            playwrightWait.waitUntil(NAV_BAR_EXPANDED_CSS, WaitForSelectorState.VISIBLE);
        }
        return this;
    }

    public SignInFormPage goToSignInForm() {
        logger.info("Go to Sign In form");
        expandNavBarIfNotExpanded();
        clickElement(SIGN_IN_BUTTON_CSS);
        playwrightWait.waitUntil(SignInFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new SignInFormPage(playwrightPage);
    }

    public SignUpFormPage goToSignUpForm() {
        logger.info("Go to Sign Up form");
        expandNavBarIfNotExpanded();
        clickElement(SIGN_UP_BUTTON_CSS);
        playwrightWait.waitUntil(SignUpFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new SignUpFormPage(playwrightPage);
    }

    public MainPage clickSignOut() {
        logger.info("Click 'Sign out' button");
        expandNavBarIfNotExpanded();
        clickElement(SIGN_OUT_BUTTON_CSS);
        return new MainPage(playwrightPage);
    }

    public ResetPasswordFormPage goToResetPasswordForm() {
        logger.info("Go to Reset password form");
        expandNavBarIfNotExpanded();
        clickElement(RESET_PASSWORD_BUTTON_CSS);
        playwrightWait.waitUntil(ResetPasswordFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new ResetPasswordFormPage(playwrightPage);
    }

    public AdminPanelPage goToAdminPanel() {
        logger.info("Go to Admin panel");
        expandNavBarIfNotExpanded();
        clickElement(ADMIN_PANEL_BUTTON_CSS);
        playwrightWait.waitUntil(AdminPanelPage.ROOT_XPATH, WaitForSelectorState.VISIBLE);
        return new AdminPanelPage(playwrightPage);
    }

    public CarBrandFormPage clickAddCarBrand() {
        logger.info("Click 'Add car brand' button");
        clickElement(ADD_CAR_BRAND_CSS);
        playwrightWait.waitUntil(CarBrandFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarBrandFormPage(playwrightPage);
    }

    public boolean isAdminPanelButtonVisible() {
        logger.info("Check if Admin panel button is visible");
        expandNavBarIfNotExpanded();
        return isElementDisplayedOnThePage(ADMIN_PANEL_BUTTON_CSS, 1);
    }

    public boolean isSuccessAlertVisibleWithExpectedText(final String expectedText) {
        logger.info("Check if success alert has expected text");
        return isElementDisplayedOnThePage(String.format(SUCCESS_ALERT_WITH_TEXT_XPATH, expectedText), 5);
    }

    public boolean isDangerAlertVisibleWithExpectedText(final String expectedText) {
        logger.info("Check if danger alert has expected text");
        return isElementDisplayedOnThePage(String.format(DANGER_ALERT_WITH_TEXT_XPATH, expectedText), 5);
    }

    public boolean isFormWasValidatedWithSuccess() {
        logger.info("Check if Form was validated with success");
        return !isElementDisplayedOnThePage(FORM_WAS_VALIDATED_CSS, 1);
    }

    public boolean isMainPageVisible() {
        logger.info("Check if Main Page is visible");
        return isElementDisplayedOnThePage(ROOT_CSS, 100);
    }
}
