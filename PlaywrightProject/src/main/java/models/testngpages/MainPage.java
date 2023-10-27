package models.testngpages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MainPage extends AbstractPage {

    private static final String SIGN_IN_BUTTON_CSS = "a[href='/sign-in-form']";
    private static final String SIGN_UP_BUTTON_CSS = "a[href='/sign-up-form']";
    private static final String SIGN_OUT_BUTTON_CSS = "a[href='/sign-out']";
    private static final String RESET_PASSWORD_BUTTON_CSS = "a[href='/reset-password-form']";
    private static final String ADMIN_PANEL_BUTTON_CSS = "a[href='/admin-panel']";
    private static final String SUCCESS_ALERT_CSS = "div[class='alert alert-success']";
    private static final String DANGER_ALERT_CSS = "div[class='alert alert-danger']";
    private static final String FORM_WAS_VALIDATED_CSS = "form[class*='was-validated']";
    private static final String ADD_CAR_BRAND_CSS = "a[href='/car-brand/add-form']";

    public MainPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public SignInFormPage goToSignInForm() {
        playwrightPage.click(SIGN_IN_BUTTON_CSS);
        playwrightWait.waitUntil(SignInFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new SignInFormPage(playwrightPage);
    }

    public SignUpFormPage goToSignUpForm() {
        playwrightPage.click(SIGN_UP_BUTTON_CSS);
        playwrightWait.waitUntil(SignUpFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new SignUpFormPage(playwrightPage);
    }

    public MainPage clickSignOut() {
        playwrightPage.click(SIGN_OUT_BUTTON_CSS);
        playwrightWait.waitUntil(SIGN_OUT_BUTTON_CSS, WaitForSelectorState.HIDDEN);
        return new MainPage(playwrightPage);
    }

    public ResetPasswordFormPage goToResetPasswordForm() {
        playwrightPage.click(RESET_PASSWORD_BUTTON_CSS);
        playwrightWait.waitUntil(ResetPasswordFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new ResetPasswordFormPage(playwrightPage);
    }

    public AdminPanelPage goToAdminPanel() {
        playwrightPage.click(ADMIN_PANEL_BUTTON_CSS);
        playwrightWait.waitUntil(AdminPanelPage.ROOT_XPATH, WaitForSelectorState.VISIBLE);
        return new AdminPanelPage(playwrightPage);
    }

    public CarBrandFormPage goToAddingCarBrandForm() {
        playwrightPage.click(ADD_CAR_BRAND_CSS);
        playwrightWait.waitUntil(CarBrandFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarBrandFormPage(playwrightPage);
    }

    public boolean isAdminPanelButtonVisible() {
        return playwrightPage.isVisible(ADMIN_PANEL_BUTTON_CSS);
    }

    public String getTextFromSuccessAlert() {
        playwrightWait.waitUntil(SUCCESS_ALERT_CSS, WaitForSelectorState.VISIBLE);
        return playwrightPage.locator(SUCCESS_ALERT_CSS).textContent();
    }

    public String getTextFromDangerAlert() {
        playwrightWait.waitUntil(DANGER_ALERT_CSS, WaitForSelectorState.VISIBLE);
        return playwrightPage.locator(DANGER_ALERT_CSS).textContent();
    }

    public boolean isFormWasValidatedWithSuccess() {
        return !playwrightPage.isVisible(FORM_WAS_VALIDATED_CSS);
    }
}
