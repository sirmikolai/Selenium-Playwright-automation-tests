package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action='/sign-up']";
    private static final String EMAIL_INPUT_CSS = ROOT_CSS + " input[name='email']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='password']";
    private static final String PASSWORD_CONFIRMATION_INPUT_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String TERMS_AND_CONDITIONS_CHECKBOX_CSS = ROOT_CSS + " input[type='checkbox']";
    private static final String SIGN_UP_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public SignUpFormPage(WebDriver driver) {
        super(driver);
    }

    public SignUpFormPage inputEmail(String emailAddress) {
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(emailAddress);
        return this;
    }

    public SignUpFormPage inputPassword(String password) {
        driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).sendKeys(password);
        return this;
    }

    public SignUpFormPage inputPasswordConfirmation(String password) {
        driver.findElement(By.cssSelector(PASSWORD_CONFIRMATION_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(PASSWORD_CONFIRMATION_INPUT_CSS)).sendKeys(password);
        return this;
    }

    public SignUpFormPage selectTermsAndConditionsCheckbox() {
        driver.findElement(By.cssSelector(TERMS_AND_CONDITIONS_CHECKBOX_CSS)).click();
        return this;
    }

    public MainPage clickSignUp() {
        driver.findElement(By.cssSelector(SIGN_UP_BUTTON_CSS)).click();
        return new MainPage(driver);
    }

}
