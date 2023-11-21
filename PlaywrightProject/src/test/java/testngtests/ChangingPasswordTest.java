package testngtests;

import com.mailosaur.MailosaurException;
import listeners.TestListener;
import models.User;
import models.testngpages.resetpassword.ResetPasswordFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.io.IOException;

import static models.enums.SystemAlerts.DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT;
import static models.enums.SystemAlerts.SUCCESS_ALERT_PASSWORD_CHANGED_TEXT;
import static models.generators.PasswordGenerator.generatePassword;

@Listeners(TestListener.class)
public class ChangingPasswordTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();
    private static final String newPassword = generatePassword(10);
    private ResetPasswordFormPage resetPasswordFormPage;

    @BeforeMethod(firstTimeOnly = true)
    public void prepareUserForTest() throws IOException, MailosaurException {
        signUp(newUser);
        signIn(newUser);
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object [][] {
                { newPassword, newUser.getPassword(), newUser.getPassword(), true, DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT.getAlertText() },
                { newUser.getPassword(), newUser.getPassword(), newPassword, false, null },
                { newUser.getPassword(), newPassword, newPassword, true, null }
        };
    }

    @Test(dataProvider = "userData")
    public void changingPasswordTest(String currentPassword, String newPassword, String passwordConfirmation, boolean isCorrectValidation, String dangerAlertText) {
        resetPasswordFormPage = mainPage.goToResetPasswordForm()
                .inputCurrentPassword(currentPassword)
                .inputNewPassword(newPassword)
                .inputNewPasswordConfirmation(passwordConfirmation);
        resetPasswordFormPage.clickConfirm();
        assertThatFormWasValidatedWithSuccess(isCorrectValidation);
        if (isCorrectValidation && dangerAlertText == null) {
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_PASSWORD_CHANGED_TEXT.getAlertText());
        }
        if (dangerAlertText != null) {
            assertThatDangerAlertHasExpectedText(dangerAlertText);
        }

    }

}
