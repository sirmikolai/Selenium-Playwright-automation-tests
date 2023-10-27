package testngtests;

import com.mailosaur.MailosaurException;
import models.User;
import models.testngpages.ResetPasswordFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.*;
import testngtests.abstractclasses.AbstractTest;

import java.io.IOException;

import static models.generators.PasswordGenerator.generatePassword;

public class ChangingPasswordTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();
    private static final String SUCCESS_ALERT_PASSWORD_CHANGED_TEXT = "Success! Your password has been changed.";
    private static final String DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT = "Error! Incorrect current password!";
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
                { newPassword, newUser.getPassword(), newUser.getPassword(), true, DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT },
                { newUser.getPassword(), newUser.getPassword(), newPassword, false, null },
                { newUser.getPassword(), newPassword, newPassword, true, null }
        };
    }

    @Test(dataProvider = "userData")
    public void changingPasswordTest(String currentPassword, String newPassword, String passwordConfirmation, boolean correctValidation, String dangerAlertText) {
        resetPasswordFormPage = mainPage.goToResetPasswordForm()
                .inputCurrentPassword(currentPassword)
                .inputNewPassword(newPassword)
                .inputNewPasswordConfirmation(passwordConfirmation);
        resetPasswordFormPage.clickConfirm();
        Assertions.assertThat(mainPage.isFormWasValidatedWithSuccess()).isEqualTo(correctValidation);
        if (correctValidation && dangerAlertText == null) {
            Assertions.assertThat(mainPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_PASSWORD_CHANGED_TEXT);
        }
        if (dangerAlertText != null) {
            Assertions.assertThat(mainPage.getTextFromDangerAlert()).contains(DANGER_ALERT_INCORRECT_CURRENT_PASSWORD_TEXT);
        }
    }

}
