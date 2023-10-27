package models.testngpages;

import com.microsoft.playwright.Page;

public class SignUpFormPage extends MainPage {

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
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(EMAIL_INPUT_CSS, "");
        playwrightPage.fill(EMAIL_INPUT_CSS, emailAddress);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public SignUpFormPage inputPassword(String password) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(PASSWORD_INPUT_CSS, "");
        playwrightPage.fill(PASSWORD_INPUT_CSS, password);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public SignUpFormPage inputPasswordConfirmation(String password) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(PASSWORD_CONFIRMATION_INPUT_CSS, "");
        playwrightPage.fill(PASSWORD_CONFIRMATION_INPUT_CSS, password);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public SignUpFormPage selectTermsAndConditionsCheckbox() {
        playwrightWait.waitForPageLoad();
        playwrightPage.check(TERMS_AND_CONDITIONS_CHECKBOX_CSS);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public MainPage clickSignUp() {
        playwrightWait.waitForPageLoad();
        playwrightPage.click(SIGN_UP_BUTTON_CSS);
        playwrightWait.waitForPageLoad();
        return new MainPage(playwrightPage);
    }


}
