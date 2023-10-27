package core.webdriver;

import core.PomParams;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        return new InternetExplorerDriver(options);
    }
}
