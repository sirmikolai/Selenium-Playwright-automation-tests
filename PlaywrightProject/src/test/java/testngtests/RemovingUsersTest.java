package testngtests;

import listeners.TestListener;
import models.testngpages.adminpanel.AdminPanelPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.util.List;

import static models.enums.SystemAlerts.SUCCESS_ALERT_USER_REMOVED_TEXT;

@Listeners(TestListener.class)
public class RemovingUsersTest extends AbstractTest {

    private AdminPanelPage adminPanelPage;

    @Test
    public void removingUsersTest() {
        signIn(existedAdminUser);
        adminPanelPage = mainPage.goToAdminPanel();
        List<String> usersToDelete = adminPanelPage.getUsersEmailsToDelete();
        usersToDelete.forEach(email -> {
            adminPanelPage.deleteUserByEmail(email);
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_USER_REMOVED_TEXT.getAlertText());
            assertThatRowWithUserIsExistOrNot(email, false);
        });
    }

    private void assertThatRowWithUserIsExistOrNot(String userEmail, boolean shouldExist) {
        Assertions.assertThat(adminPanelPage.isRowForUserWithEmailExist(userEmail))
                .as(String.format("Assert that row for expected user is exist: %s", shouldExist))
                .isEqualTo(shouldExist);
    }

}
