package core.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWait {

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;
    private static final int TIMEOUT = 25;

    public SeleniumWait(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = ((JavascriptExecutor) driver);
    }

    public void waitUntil(ExpectedCondition<?> expectedCondition, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(expectedCondition);
    }

    public void waitUntil(ExpectedCondition<?> expectedCondition) {
        waitUntil(expectedCondition, TIMEOUT);
    }

    public void waitInMillis(int milliseconds) {
        sleepInMillis(milliseconds);
    }

    public void waitInSeconds(int seconds) {
        sleepInMillis(seconds * 1000);
    }

    private void sleepInMillis(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void waitForPageInitialization() {
        final String jsScript = "return document.readyState";
        ExpectedCondition<Boolean> pageInitializationCondition = driver1 -> jsExecutor.executeScript(jsScript).equals("complete");
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(pageInitializationCondition);
    }

    public void waitForExpectedOptionToBeSelected(final Select selectElement, String displayedText, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(driver1 ->
                selectElement.getFirstSelectedOption().getText().equalsIgnoreCase(displayedText));
    }
}
