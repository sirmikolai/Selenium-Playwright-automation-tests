package models.testngpages.resetpassword;

import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(ResetPasswordFormPage.class);

    public static final String ROOT_CSS = "form[action*='/reset-password']";
    private static final String CURRENT_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='current_password']";
    private static final String NEW_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='new_password']";
    private static final String NEW_PASSWORD_CONFIRMATION_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String CONFIRM_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public ResetPasswordFormPage(WebDriver driver) {
        super(driver);
    }

    public ResetPasswordFormPage inputCurrentPassword(String currentPassword) {
        logger.info("Input current password");
        fillField(By.cssSelector(CURRENT_PASSWORD_INPUT_CSS), currentPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPassword(String newPassword) {
        logger.info("Input new password");
        fillField(By.cssSelector(NEW_PASSWORD_INPUT_CSS), newPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPasswordConfirmation(String newPasswordConfirmation) {
        logger.info("Input new password confirmation");
        fillField(By.cssSelector(NEW_PASSWORD_CONFIRMATION_CSS), newPasswordConfirmation);
        return this;
    }

    public MainPage clickConfirm() {
        logger.info("Click 'Confirm' button");
        clickElement(By.cssSelector(CONFIRM_BUTTON_CSS));
        return new MainPage(driver);
    }
}
