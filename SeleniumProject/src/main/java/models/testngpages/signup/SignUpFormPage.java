package models.testngpages.signup;

import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(SignUpFormPage.class);

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
        logger.info("Input email");
        fillField(By.cssSelector(EMAIL_INPUT_CSS), emailAddress);
        return this;
    }

    public SignUpFormPage inputPassword(String password) {
        logger.info("Input password");
        fillField(By.cssSelector(PASSWORD_INPUT_CSS), password);
        return this;
    }

    public SignUpFormPage inputPasswordConfirmation(String password) {
        logger.info("Input password confirmation");
        fillField(By.cssSelector(PASSWORD_CONFIRMATION_INPUT_CSS), password);
        return this;
    }

    public SignUpFormPage selectTermsAndConditionsCheckbox() {
        logger.info("Select 'Agree to terms and conditions' checkbox");
        clickElement(By.cssSelector(TERMS_AND_CONDITIONS_CHECKBOX_CSS));
        return this;
    }

    public MainPage clickSignUp() {
        logger.info("Click 'Sign up' button");
        clickElement(By.cssSelector(SIGN_UP_BUTTON_CSS));
        return new MainPage(driver);
    }

}
