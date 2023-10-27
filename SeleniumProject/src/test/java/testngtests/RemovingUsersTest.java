package testngtests;

import models.testngpages.AdminPanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;
import java.util.List;

public class RemovingUsersTest extends AbstractTest {

    private AdminPanelPage adminPanelPage;

    @Test
    public void removingUsersTest() {
        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        List<String> usersToDelete = adminPanelPage.getUsersEmailsToDelete();
        for (String email: usersToDelete) {
            adminPanelPage.deleteUserByEmail(email);
            Assert.assertEquals(adminPanelPage.getTextFromSuccessAlert(), SUCCESS_ALERT_USER_REMOVED_TEXT);
            Assert.assertFalse(adminPanelPage.isRowForUserWithEmailExist(email));
        }
    }

}
