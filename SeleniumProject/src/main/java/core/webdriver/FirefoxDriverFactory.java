package core.webdriver;

import core.PomParams;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("window-size=1920,1080");
        options.addPreference("intl.accept_languages", "en-US");
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }
}
