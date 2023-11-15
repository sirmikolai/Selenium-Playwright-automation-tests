package testngtests;

import com.mailosaur.MailosaurException;
import models.User;
import models.testngpages.adminpanel.AdminPanelPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.io.IOException;

import static models.enums.SystemAlerts.*;

public class AdminPanelTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();

    private AdminPanelPage adminPanelPage;

    @Test
    public void adminPanelTest() throws IOException, MailosaurException {
        signUp(newUser);

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        assertThatPromoteButtonIsAvailableOrNot(true);
        assertThatDemoteButtonIsAvailableOrNot(false);
        assertThatDeleteButtonIsAvailableOrNot(true);
        adminPanelPage.promoteUserByEmail(newUser.getEmail());
        assertThatSuccessAlertHasExpectedText(String.format(SUCCESS_ALERT_PROMOTING_USER_TEXT.getAlertText(), newUser.getEmail()));
        assertThatPromoteButtonIsAvailableOrNot(false);
        assertThatDemoteButtonIsAvailableOrNot(true);
        assertThatDeleteButtonIsAvailableOrNot(true);
        signOut();

        signIn(newUser);
        assertThatAdminPanelButtonIsAvailableOrNot(true);
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.demoteUserByEmail(newUser.getEmail());
        assertThatSuccessAlertHasExpectedText(String.format(SUCCESS_ALERT_DEMOTING_USER_TEXT.getAlertText(), newUser.getEmail()));
        assertThatPromoteButtonIsAvailableOrNot(true);
        assertThatDemoteButtonIsAvailableOrNot(false);
        assertThatDeleteButtonIsAvailableOrNot(true);
        signOut();

        signIn(newUser);
        assertThatAdminPanelButtonIsAvailableOrNot(false);
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.deleteUserByEmail(newUser.getEmail());
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_USER_REMOVED_TEXT.getAlertText());
        assertThatRowWithUserIsNotExist(newUser);
        signOut();

        signIn(newUser, true);
    }

    private void assertThatPromoteButtonIsAvailableOrNot(boolean shouldBeAvailable) {
        Assertions.assertThat(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail()))
                .as("Assert that Promote button is available: " + shouldBeAvailable)
                .isEqualTo(shouldBeAvailable);
    }

    private void assertThatDemoteButtonIsAvailableOrNot(boolean shouldBeAvailable) {
        Assertions.assertThat(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail()))
                .as("Assert that Demote button is available: " + shouldBeAvailable)
                .isEqualTo(shouldBeAvailable);
    }

    private void assertThatDeleteButtonIsAvailableOrNot(boolean shouldBeAvailable) {
        Assertions.assertThat(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail()))
                .as("Assert that Delete button is available: " + shouldBeAvailable)
                .isEqualTo(shouldBeAvailable);
    }

    private void assertThatAdminPanelButtonIsAvailableOrNot(boolean shouldBeAvailable) {
        Assertions.assertThat(adminPanelPage.isAdminPanelButtonVisible())
                .as("Assert that Admin panel button is available: " + shouldBeAvailable)
                .isEqualTo(shouldBeAvailable);
    }

    private void assertThatRowWithUserIsNotExist(User user) {
        Assertions.assertThat(adminPanelPage.isRowForUserWithEmailExist(user.getEmail()))
                .as("Assert that row for expected user is not exist")
                .isFalse();
    }

}
