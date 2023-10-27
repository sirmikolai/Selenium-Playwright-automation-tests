package testngtests;

import com.mailosaur.MailosaurException;
import models.User;
import models.testngpages.MainPage;
import models.testngpages.SignUpFormPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.io.IOException;

import static core.mailosaur.MailosaurMessageManager.getLinkFromMessage;
import static core.mailosaur.MailosaurServerManager.getEmailByRecipientName;
import static models.generators.PasswordGenerator.generatePassword;

public class RegistrationTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();
    private User newUser2 = new User.UserBuilder().build();
    private static final String DANGER_ALERT_EMAIL_USED = "Error! There is already registered user with that email!";

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object [][] {
                { newUser.getEmail(), newUser.getPassword(), newUser.getPassword(), true, true, null },
                { newUser.getEmail(), newUser.getPassword(), newUser.getPassword(), true, true, DANGER_ALERT_EMAIL_USED },
                { newUser2.getEmail(), newUser2.getPassword(), generatePassword(10), true, false, null },
                { newUser2.getEmail(), newUser2.getPassword(), newUser2.getPassword(), false, false, null },
        };
    }

    @Test(dataProvider = "userData")
    public void registrationTest(String email, String password, String confirmationPassword, boolean selectTermsAndConditions, boolean isCorrectValidation, String dangerAlertText) throws IOException, MailosaurException {
        SignUpFormPage signUpFormPage = mainPage.goToSignUpForm();
        signUpFormPage.inputEmail(email);
        signUpFormPage.inputPassword(password);
        signUpFormPage.inputPasswordConfirmation(confirmationPassword);
        if (selectTermsAndConditions) {
            signUpFormPage.selectTermsAndConditionsCheckbox();
        }
        signUpFormPage.clickSignUp();
        Assert.assertEquals(mainPage.isFormWasValidatedWithSuccess(), isCorrectValidation);
        if (isCorrectValidation && dangerAlertText == null) {
            Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_REGISTRATION_TEXT);
            String confirmationUrl = getLinkFromMessage(getEmailByRecipientName(newUser.getEmail()));
            mainPage = openPageWithUrl(confirmationUrl, MainPage.class);
            Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_CONFIRMATION_EMAIL_ADDRESS_TEXT);
        }
        if (dangerAlertText != null) {
            Assert.assertEquals(mainPage.getTextFromDangerAlert(), dangerAlertText);
        }
    }


}
