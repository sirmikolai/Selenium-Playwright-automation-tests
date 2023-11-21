package models.testngpages.signin;

import com.microsoft.playwright.Page;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SignInFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(SignInFormPage.class);

    public static final String ROOT_CSS = "form[action='/sign-in']";
    private static final String EMAIL_INPUT_CSS = ROOT_CSS + " input[name='email']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='password']";
    private static final String SIGN_IN_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public SignInFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public SignInFormPage inputEmail(String emailAddress) {
        logger.info("Input email");
        fillField(EMAIL_INPUT_CSS, emailAddress);
        return this;
    }

    public SignInFormPage inputPassword(String password) {
        logger.info("Input password");
        fillField(PASSWORD_INPUT_CSS, password);
        return this;
    }

    public MainPage clickSignIn() {
        logger.info("Click 'Sign in' button");
        clickElement(SIGN_IN_BUTTON_CSS);
        return new MainPage(playwrightPage);
    }
}
