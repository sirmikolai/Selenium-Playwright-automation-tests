package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static core.mailosaur.MailosaurServerManager.SERVER_ID;

public class AdminPanelPage extends MainPage {

    public static final String ROOT_XPATH = "//h1[text()='USERS']";
    private static final String USER_ROW_XPATH = "//tr[td[1][contains(text(),'%s')]]";
    private static final String USERS_EMAILS_XPATH = USER_ROW_XPATH + "/td[1]";
    private static final String PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'promote-role')]";
    private static final String DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'demote-role')]";
    private static final String DELETE_USER_BY_EMAIL_XPATH = USER_ROW_XPATH + "//a[contains(@href,'delete-user')]";
    private static final String DISABLED_CLASS_XPATH = "[contains(@class,'disabled')]";

    public AdminPanelPage(WebDriver driver) {
        super(driver);
    }

    public AdminPanelPage promoteUserByEmail(String emailAddress) {
        scrollIntoView(driver.findElement(By.xpath(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH, emailAddress))));
        clickElementBy(By.xpath(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH, emailAddress)));
        return this;
    }

    public AdminPanelPage demoteUserByEmail(String emailAddress) {
        scrollIntoView(driver.findElement(By.xpath(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH, emailAddress))));
        clickElementBy(By.xpath(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH, emailAddress)));
        return this;
    }

    public AdminPanelPage deleteUserByEmail(String emailAddress) {
        scrollIntoView(driver.findElement(By.xpath(String.format(DELETE_USER_BY_EMAIL_XPATH, emailAddress))));
        clickElementBy(By.xpath(String.format(DELETE_USER_BY_EMAIL_XPATH, emailAddress)));
        return this;
    }

    public boolean isPromoteButtonAvailableForUserWithEmail(String emailAddress) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format(PROMOTE_TO_ADMIN_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress))), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDemoteButtonAvailableForUserWithEmail(String emailAddress) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format(DEMOTE_TO_USER_ROLE_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress))), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDeleteButtonAvailableForUserWithEmail(String emailAddress) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.xpath(String.format(DELETE_USER_BY_EMAIL_XPATH + DISABLED_CLASS_XPATH, emailAddress))), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isRowForUserWithEmailExist(String emailAddress) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(USER_ROW_XPATH, emailAddress))), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<String> getUsersEmailsToDelete() {
        return driver.findElements(By.xpath(String.format(USERS_EMAILS_XPATH, SERVER_ID + ".mailosaur.net"))).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
