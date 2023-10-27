package models.testngpages;

import com.microsoft.playwright.Page;

public class SignInFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action='/sign-in']";
    private static final String EMAIL_INPUT_CSS = ROOT_CSS + " input[name='email']";
    private static final String PASSWORD_INPUT_CSS = ROOT_CSS + " input[name='password']";
    private static final String SIGN_IN_BUTTON_CSS = ROOT_CSS + " button[type='submit']";

    public SignInFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public SignInFormPage inputEmail(String emailAddress) {
        playwrightPage.fill(EMAIL_INPUT_CSS, "");
        playwrightPage.fill(EMAIL_INPUT_CSS, emailAddress);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public SignInFormPage inputPassword(String password) {
        playwrightPage.fill(PASSWORD_INPUT_CSS, "");
        playwrightPage.fill(PASSWORD_INPUT_CSS, password);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public MainPage clickSignIn() {
        playwrightPage.click(SIGN_IN_BUTTON_CSS);
        playwrightWait.waitForPageLoad();
        return new MainPage(playwrightPage);
    }
}
