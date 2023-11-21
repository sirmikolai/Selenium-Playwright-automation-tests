package models.testngpages.adminpanel;

import com.microsoft.playwright.Page;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

import static core.mailosaur.MailosaurServerManager.SERVER_ID;

public class AdminPanelPage extends MainPage {

    private static final Log logger = LogFactory.getLog(AdminPanelPage.class);

    public static final String ROOT_XPATH = "//h1[text()='USERS']";
    private static final String USER_ROW_XPATH = "//tr[td[1][contains(text(),'%s')]]";
    private static final String USERS_EMAILS_XPATH = USER_ROW_XPATH + "/td[1]";
    private static final String PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'promote-role')]";
    private static final String DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'demote-role')]";
    private static final String DELETE_USER_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'delete-user')]";
    private static final String DISABLED_CLASS_XPATH = "[contains(@class,'disabled')]";

    public AdminPanelPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public AdminPanelPage promoteUserByEmail(String emailAddress) {
        logger.info("Click 'Promote to Admin role' button");
        clickElement(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH, emailAddress));
        return this;
    }

    public AdminPanelPage demoteUserByEmail(String emailAddress) {
        logger.info("Click 'Demote to User role' button");
        clickElement(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH, emailAddress));
        return this;
    }

    public AdminPanelPage deleteUserByEmail(String emailAddress) {
        logger.info("Click 'Delete user' button");
        clickElement(String.format(DELETE_USER_BY_EMAIL_XPATH, emailAddress));
        return this;
    }

    public boolean isPromoteButtonAvailableForUserWithEmail(String emailAddress) {
        logger.info("Check is promote button is available for expected user");
        return !isElementDisplayedOnThePage(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress), 1);
    }

    public boolean isDemoteButtonAvailableForUserWithEmail(String emailAddress) {
        logger.info("Check is demote button is available for expected user");
        return !isElementDisplayedOnThePage(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress), 1);
    }

    public boolean isDeleteButtonAvailableForUserWithEmail(String emailAddress) {
        logger.info("Check is delete button is available for expected user");
        return !isElementDisplayedOnThePage(String.format(DELETE_USER_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress), 1);
    }

    public boolean isRowForUserWithEmailExist(String emailAddress) {
        logger.info("Check is row for expected user exist");
        return isElementDisplayedOnThePage(String.format(USER_ROW_XPATH, emailAddress), 1);
    }

    public List<String> getUsersEmailsToDelete() {
        playwrightWait.waitForPageLoad();
        return (List<String>) playwrightPage.evalOnSelectorAll(String.format(USERS_EMAILS_XPATH, SERVER_ID + ".mailosaur.net"), "(elements) => elements.map(element => element.textContent)");
    }
}
