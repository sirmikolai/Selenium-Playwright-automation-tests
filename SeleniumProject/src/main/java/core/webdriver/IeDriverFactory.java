package core.webdriver;

import core.PomParams;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        return new InternetExplorerDriver(options);
    }
}
