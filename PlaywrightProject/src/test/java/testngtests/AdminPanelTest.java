package testngtests;

import com.mailosaur.MailosaurException;
import models.User;
import models.testngpages.AdminPanelPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.io.IOException;

public class AdminPanelTest extends AbstractTest {

    private User newUser = new User.UserBuilder().build();
    private static final String SUCCESS_ALERT_PROMOTING_USER_TEXT = "Success! User with email '%s' has been promoted to ADMIN role.";
    private static final String SUCCESS_ALERT_DEMOTING_USER_TEXT = "Success! User with email '%s' has been demoted to USER role.";
    private AdminPanelPage adminPanelPage;

    @Test
    public void adminPanelTest() throws IOException, MailosaurException {
        signUp(newUser);

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        Assertions.assertThat(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        Assertions.assertThat(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail())).isFalse();
        Assertions.assertThat(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        adminPanelPage.promoteUserByEmail(newUser.getEmail());
        Assertions.assertThat(adminPanelPage.getTextFromSuccessAlert()).contains(String.format(SUCCESS_ALERT_PROMOTING_USER_TEXT, newUser.getEmail()));
        Assertions.assertThat(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail())).isFalse();
        Assertions.assertThat(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        Assertions.assertThat(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        signOut();

        signIn(newUser);
        Assertions.assertThat(adminPanelPage.isAdminPanelButtonVisible()).isTrue();
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.demoteUserByEmail(newUser.getEmail());
        Assertions.assertThat(adminPanelPage.getTextFromSuccessAlert()).contains(String.format(SUCCESS_ALERT_DEMOTING_USER_TEXT, newUser.getEmail()));
        Assertions.assertThat(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        Assertions.assertThat(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail())).isFalse();
        Assertions.assertThat(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail())).isTrue();
        signOut();

        signIn(newUser);
        Assertions.assertThat(adminPanelPage.isAdminPanelButtonVisible()).isFalse();
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.deleteUserByEmail(newUser.getEmail());
        Assertions.assertThat(adminPanelPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_USER_REMOVED_TEXT);
        Assertions.assertThat(adminPanelPage.isRowForUserWithEmailExist(newUser.getEmail())).isFalse();
        signOut();

        signIn(newUser, true);
    }

}
