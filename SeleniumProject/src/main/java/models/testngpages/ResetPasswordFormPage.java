package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action*='/reset-password']";
    private static final String CURRENT_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='current_password']";
    private static final String NEW_PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='new_password']";
    private static final String NEW_PASSWORD_CONFIRMATION_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String CONFIRM_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public ResetPasswordFormPage(WebDriver driver) {
        super(driver);
    }

    public ResetPasswordFormPage inputCurrentPassword(String currentPassword) {
        driver.findElement(By.cssSelector(CURRENT_PASSWORD_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(CURRENT_PASSWORD_INPUT_CSS)).sendKeys(currentPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPassword(String newPassword) {
        driver.findElement(By.cssSelector(NEW_PASSWORD_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(NEW_PASSWORD_INPUT_CSS)).sendKeys(newPassword);
        return this;
    }

    public ResetPasswordFormPage inputNewPasswordConfirmation(String newPasswordConfirmation) {
        driver.findElement(By.cssSelector(NEW_PASSWORD_CONFIRMATION_CSS)).clear();
        driver.findElement(By.cssSelector(NEW_PASSWORD_CONFIRMATION_CSS)).sendKeys(newPasswordConfirmation);
        return this;
    }

    public MainPage clickConfirm() {
        driver.findElement(By.cssSelector(CONFIRM_BUTTON_CSS)).click();
        return new MainPage(driver);
    }
}
