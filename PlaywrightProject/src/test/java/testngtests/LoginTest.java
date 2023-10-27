package testngtests;

import models.User;
import models.testngpages.SignInFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

public class LoginTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();
    private static final String DANGER_ALERT_INVALID_PASSWORD_TEXT = "Error! Invalid password.";

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object [][] {
                { existedSimpleUser.getEmail(), existedSimpleUser.getPassword(), true, null },
                { newUser.getEmail(), newUser.getPassword(), true, DANGER_ALERT_INVALID_EMAIL_TEXT },
                { existedSimpleUser.getEmail(), newUser.getPassword(), true, DANGER_ALERT_INVALID_PASSWORD_TEXT },
                { null, null, false, null },
        };
    }

    @Test(dataProvider = "userData")
    public void loginTest(String email, String password, boolean correctValidation, String dangerAlertText) {
        SignInFormPage signInFormPage = mainPage.goToSignInForm();
        if (email != null) {
            signInFormPage.inputEmail(email);
        }
        if (password != null) {
            signInFormPage.inputPassword(password);
        }
        signInFormPage.clickSignIn();
        Assertions.assertThat(mainPage.isFormWasValidatedWithSuccess()).isEqualTo(correctValidation);
        if (correctValidation && dangerAlertText == null) {
            Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_LOGIN_TEXT);
            mainPage.clickSignOut();
            Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_SIGN_OUT_TEXT);
        }
        if (dangerAlertText != null) {
            Assertions.assertThat(mainPage.getTextFromDangerAlert()).contains(dangerAlertText);
        }
    }

}
