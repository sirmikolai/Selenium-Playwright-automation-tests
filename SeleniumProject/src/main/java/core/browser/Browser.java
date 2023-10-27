package core.browser;

import core.webdriver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Browser {

    private final DriverFactory driverFactory;

    public Browser(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    public WebDriver getDriver() {
        return this.driverFactory.createWebDriver();
    }
}
