package models.testngpages.signup;

import com.microsoft.playwright.Page;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SignUpFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(SignUpFormPage.class);

    public static final String ROOT_CSS = "form[action='/sign-up']";
    private static final String EMAIL_INPUT_CSS = ROOT_CSS + " input[name='email']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='password']";
    private static final String PASSWORD_CONFIRMATION_INPUT_CSS = ROOT_CSS + " input[name='password_confirmation']";
    private static final String TERMS_AND_CONDITIONS_CHECKBOX_CSS = ROOT_CSS + " input[type='checkbox']";
    private static final String SIGN_UP_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public SignUpFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public SignUpFormPage inputEmail(String emailAddress) {
        logger.info("Input email");
        fillField(EMAIL_INPUT_CSS, emailAddress);
        return this;
    }

    public SignUpFormPage inputPassword(String password) {
        logger.info("Input password");
        fillField(PASSWORD_INPUT_CSS, password);
        return this;
    }

    public SignUpFormPage inputPasswordConfirmation(String password) {
        logger.info("Input password confirmation");
        fillField(PASSWORD_CONFIRMATION_INPUT_CSS, password);
        return this;
    }

    public SignUpFormPage selectTermsAndConditionsCheckbox() {
        logger.info("Select 'Agree to terms and conditions' checkbox");
        clickElement(TERMS_AND_CONDITIONS_CHECKBOX_CSS);
        return this;
    }

    public MainPage clickSignUp() {
        logger.info("Click 'Sign up' button");
        clickElement(SIGN_UP_BUTTON_CSS);
        return new MainPage(playwrightPage);
    }


}
