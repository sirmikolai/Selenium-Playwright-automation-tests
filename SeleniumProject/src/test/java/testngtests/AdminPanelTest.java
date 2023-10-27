package testngtests;

import com.mailosaur.MailosaurException;
import models.User;
import models.testngpages.AdminPanelPage;
import org.testng.Assert;
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
        Assert.assertTrue(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertFalse(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertTrue(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail()));
        adminPanelPage.promoteUserByEmail(newUser.getEmail());
        Assert.assertEquals(adminPanelPage.getTextFromSuccessAlert(), String.format(SUCCESS_ALERT_PROMOTING_USER_TEXT, newUser.getEmail()));
        Assert.assertFalse(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertTrue(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertTrue(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail()));
        signOut();

        signIn(newUser);
        Assert.assertTrue(mainPage.isAdminPanelButtonVisible());
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.demoteUserByEmail(newUser.getEmail());
        Assert.assertEquals(adminPanelPage.getTextFromSuccessAlert(), String.format(SUCCESS_ALERT_DEMOTING_USER_TEXT, newUser.getEmail()));
        Assert.assertTrue(adminPanelPage.isPromoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertFalse(adminPanelPage.isDemoteButtonAvailableForUserWithEmail(newUser.getEmail()));
        Assert.assertTrue(adminPanelPage.isDeleteButtonAvailableForUserWithEmail(newUser.getEmail()));
        signOut();

        signIn(newUser);
        Assert.assertFalse(mainPage.isAdminPanelButtonVisible());
        signOut();

        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        adminPanelPage.deleteUserByEmail(newUser.getEmail());
        Assert.assertEquals(adminPanelPage.getTextFromSuccessAlert(), SUCCESS_ALERT_USER_REMOVED_TEXT);
        Assert.assertFalse(adminPanelPage.isRowForUserWithEmailExist(newUser.getEmail()));
        signOut();

        signIn(newUser, true);
    }

}
