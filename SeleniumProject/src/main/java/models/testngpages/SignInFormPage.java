package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action='/sign-in']";
    private static final String EMAIL_INPUT_CSS = ROOT_CSS + " input[name='email']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='password']";
    private static final String SIGN_IN_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public SignInFormPage(WebDriver driver) {
        super(driver);
    }

    public SignInFormPage inputEmail(String emailAddress) {
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(EMAIL_INPUT_CSS)).sendKeys(emailAddress);
        return this;
    }

    public SignInFormPage inputPassword(String password) {
        driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(PASSWORD_INPUT_CSS)).sendKeys(password);
        return this;
    }

    public MainPage clickSignIn() {
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)).click();
        return new MainPage(driver);
    }
}
