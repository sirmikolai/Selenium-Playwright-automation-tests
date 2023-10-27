package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbstractPage {

    private static final String SIGN_IN_BUTTON_CSS = "a[href='/sign-in-form']";
    private static final String SIGN_UP_BUTTON_CSS = "a[href='/sign-up-form']";
    private static final String SIGN_OUT_BUTTON_CSS = "a[href='/sign-out']";
    private static final String RESET_PASSWORD_BUTTON_CSS = "a[href='/reset-password-form']";
    private static final String ADMIN_PANEL_BUTTON_CSS = "a[href='/admin-panel']";
    private static final String SUCCESS_ALERT_CSS = "div[class='alert alert-success']";
    private static final String DANGER_ALERT_CSS = "div[class='alert alert-danger']";
    private static final String FORM_WAS_VALIDATED_CSS = "form[class*='was-validated']";
    private static final String ADD_CAR_BRAND_CSS = "a[href='/car-brand/add-form']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SignInFormPage goToSignInForm() {
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInFormPage.ROOT_CSS)));
        return new SignInFormPage(driver);
    }

    public SignUpFormPage goToSignUpForm() {
        driver.findElement(By.cssSelector(SIGN_UP_BUTTON_CSS)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignUpFormPage.ROOT_CSS)));
        return new SignUpFormPage(driver);
    }

    public MainPage clickSignOut() {
        driver.findElement(By.cssSelector(SIGN_OUT_BUTTON_CSS)).click();
        return new MainPage(driver);
    }

    public ResetPasswordFormPage goToResetPasswordForm() {
        driver.findElement(By.cssSelector(RESET_PASSWORD_BUTTON_CSS)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ResetPasswordFormPage.ROOT_CSS)));
        return new ResetPasswordFormPage(driver);
    }

    public AdminPanelPage goToAdminPanel() {
        driver.findElement(By.cssSelector(ADMIN_PANEL_BUTTON_CSS)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdminPanelPage.ROOT_XPATH)));
        return new AdminPanelPage(driver);
    }

    public CarBrandFormPage goToAddingCarBrandForm() {
        driver.findElement(By.cssSelector(ADD_CAR_BRAND_CSS)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarBrandFormPage.ROOT_CSS)));
        return new CarBrandFormPage(driver);
    }

    public boolean isAdminPanelButtonVisible() {
        try {
            seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ADMIN_PANEL_BUTTON_CSS)), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getTextFromSuccessAlert() {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SUCCESS_ALERT_CSS)));
        return driver.findElement(By.cssSelector(SUCCESS_ALERT_CSS)).getText();
    }

    public String getTextFromDangerAlert() {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DANGER_ALERT_CSS)));
        return driver.findElement(By.cssSelector(DANGER_ALERT_CSS)).getText();
    }

    public boolean isFormWasValidatedWithSuccess() {
        try {
            seleniumWait.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(FORM_WAS_VALIDATED_CSS)), 1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
