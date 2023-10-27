package testngtests;

import models.testngpages.AdminPanelPage;
import org.assertj.core.api.Assertions;
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
            Assertions.assertThat(adminPanelPage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_USER_REMOVED_TEXT);
            Assertions.assertThat(adminPanelPage.isRowForUserWithEmailExist(email)).isFalse();
        }
    }

}
