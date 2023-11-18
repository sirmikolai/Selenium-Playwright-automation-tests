package models.testngpages;

import core.PomParams;
import core.waits.SeleniumWait;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbstractPage implements PomParams {

    protected WebDriver driver;
    private JavascriptExecutor jsExecutor;
    protected SeleniumWait seleniumWait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = ((JavascriptExecutor) driver);
        this.seleniumWait = new SeleniumWait(driver);
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected void confirmAlertIfItPresent() {
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
    }

    protected void scrollIntoView(final WebElement element) {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOf(element));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void clickElement(final By elementPath) {
        try {
            WebElement element = driver.findElement(elementPath);
            seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(element), 2);
            element.click();
        } catch (TimeoutException e) {
            WebElement element = driver.findElement(elementPath);
            scrollIntoView(element);
            seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(element), 2);
            element.click();
            jsExecutor.executeScript("arguments[0].click()", element);
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(elementPath), 2);
            WebElement element = driver.findElement(elementPath);
            jsExecutor.executeScript("arguments[0].click()", element);
        }
    }

    protected void fillField(final By elementPath, String text) {
        WebElement element = driver.findElement(elementPath);
        scrollIntoView(element);
        seleniumWait.waitUntil(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        seleniumWait.waitUntil(ExpectedConditions.attributeToBe(element, "value", text));
    }

    protected boolean isElementDisplayedOnThePage(final By elementPath, int seconds) {
        try {
            seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(elementPath), seconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected String getTextFromElement(final By elementPath) {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(elementPath));
        return driver.findElement(elementPath).getText();
    }

    protected String getAttributeValueFromElement(final By elementPath, String attributeName) {
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(elementPath));
        return driver.findElement(elementPath).getAttribute(attributeName);
    }
}
