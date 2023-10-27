package core.webdriver;

import core.PomParams;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        WebDriverManager.safaridriver().setup();
        SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }
}
