package models.testngpages;

import com.microsoft.playwright.Page;

import java.util.List;

import static core.mailosaur.MailosaurServerManager.SERVER_ID;

public class AdminPanelPage extends MainPage {

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
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH, emailAddress)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH, emailAddress));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public AdminPanelPage demoteUserByEmail(String emailAddress) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH, emailAddress)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH, emailAddress));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public AdminPanelPage deleteUserByEmail(String emailAddress) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(DELETE_USER_BY_EMAIL_XPATH, emailAddress)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(DELETE_USER_BY_EMAIL_XPATH, emailAddress));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public boolean isPromoteButtonAvailableForUserWithEmail(String emailAddress) {
        playwrightWait.waitForPageLoad();
        return !playwrightPage.isVisible(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress));
    }

    public boolean isDemoteButtonAvailableForUserWithEmail(String emailAddress) {
        playwrightWait.waitForPageLoad();
        return !playwrightPage.isVisible(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress));
    }

    public boolean isDeleteButtonAvailableForUserWithEmail(String emailAddress) {
        playwrightWait.waitForPageLoad();
        return !playwrightPage.isVisible(String.format(DELETE_USER_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress));
    }

    public boolean isRowForUserWithEmailExist(String emailAddress) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.isVisible(String.format(USER_ROW_XPATH, emailAddress));
    }

    public List<String> getUsersEmailsToDelete() {
        playwrightWait.waitForPageLoad();
        return (List<String>) playwrightPage.evalOnSelectorAll(String.format(USERS_EMAILS_XPATH, SERVER_ID + ".mailosaur.net"), "(elements) => elements.map(element => element.textContent)");
    }
}
