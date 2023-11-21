package testngtests;

import listeners.TestListener;
import models.User;
import models.testngpages.signin.SignInFormPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import static models.enums.SystemAlerts.*;

@Listeners(TestListener.class)
public class LoginTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object [][] {
                { existedSimpleUser.getEmail(), existedSimpleUser.getPassword(), true, null },
                { newUser.getEmail(), newUser.getPassword(), true, DANGER_ALERT_INVALID_CREDENTIALS_TEXT.getAlertText()},
                { existedSimpleUser.getEmail(), newUser.getPassword(), true, DANGER_ALERT_INVALID_CREDENTIALS_TEXT.getAlertText() },
                { null, null, false, null },
        };
    }

    @Test(dataProvider = "userData")
    public void loginTest(String email, String password, boolean isCorrectValidation, String dangerAlertText) {
        SignInFormPage signInFormPage = mainPage.goToSignInForm();
        if (email != null) {
            signInFormPage.inputEmail(email);
        }
        if (password != null) {
            signInFormPage.inputPassword(password);
        }
        signInFormPage.clickSignIn();
        assertThatFormWasValidatedWithSuccess(isCorrectValidation);
        if (isCorrectValidation && dangerAlertText == null) {
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_LOGIN_TEXT.getAlertText());
            mainPage.clickSignOut();
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_SIGN_OUT_TEXT.getAlertText());
        }
        if (dangerAlertText != null) {
            assertThatDangerAlertHasExpectedText(dangerAlertText);
        }
    }

}
