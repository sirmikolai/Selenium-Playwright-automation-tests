package models.testngpages.resetpassword;

import com.microsoft.playwright.Page;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ResetPasswordFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(ResetPasswordFormPage.class);

    public static final String ROOT_CSS = "form[action*='/reset-password']";
    private static final String CURRENT_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='current_password']";
    private static final String NEW_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='new_password']";
    private static final String NEW_PASSWORD_CONFIRMATION_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String CONFIRM_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public ResetPasswordFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public ResetPasswordFormPage inputCurrentPassword(String currentPassword) {
        logger.info("Input current password");
        fillField(CURRENT_PASSWORD_INPUT_CSS, currentPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPassword(String newPassword) {
        logger.info("Input new password");
        fillField(NEW_PASSWORD_INPUT_CSS, newPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPasswordConfirmation(String newPasswordConfirmation) {
        logger.info("Input new password confirmation");
        fillField(NEW_PASSWORD_CONFIRMATION_CSS, newPasswordConfirmation);
        return this;
    }

    public MainPage clickConfirm() {
        logger.info("Click 'Confirm' button");
        clickElement(CONFIRM_BUTTON_CSS);
        return new MainPage(playwrightPage);
    }
}
