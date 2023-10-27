package models.testngpages;

import core.PomParams;
import core.waits.SeleniumWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbstractPage implements PomParams {

    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;
    protected SeleniumWait seleniumWait;
    protected Actions actions;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = ((JavascriptExecutor) driver);
        this.seleniumWait = new SeleniumWait(driver);
        this.actions = new Actions(driver);
    }

    boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    void scrollIntoView(WebElement element) {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOf(element));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    void clickElementBy(By bySelector) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(bySelector));
            WebElement element = driver.findElement(bySelector);
            element.click();
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(bySelector));
            WebElement element = driver.findElement(bySelector);
            jsExecutor.executeScript("arguments[0].click()", element);
        }
    }
}
