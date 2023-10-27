package models.testngpages;

import com.microsoft.playwright.Page;

public class ResetPasswordFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action*='/reset-password']";
    private static final String CURRENT_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='current_password']";
    private static final String NEW_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='new_password']";
    private static final String NEW_PASSWORD_CONFIRMATION_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String CONFIRM_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public ResetPasswordFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public ResetPasswordFormPage inputCurrentPassword(String currentPassword) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(CURRENT_PASSWORD_INPUT_CSS, "");
        playwrightPage.fill(CURRENT_PASSWORD_INPUT_CSS, currentPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPassword(String newPassword) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(NEW_PASSWORD_INPUT_CSS, "");
        playwrightPage.fill(NEW_PASSWORD_INPUT_CSS, newPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPasswordConfirmation(String newPasswordConfirmation) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(NEW_PASSWORD_CONFIRMATION_CSS, "");
        playwrightPage.fill(NEW_PASSWORD_CONFIRMATION_CSS, newPasswordConfirmation);
        return this;
    }

    public MainPage clickConfirm() {
        playwrightWait.waitForPageLoad();
        playwrightPage.click(CONFIRM_BUTTON_CSS);
        return new MainPage(playwrightPage);
    }
}
