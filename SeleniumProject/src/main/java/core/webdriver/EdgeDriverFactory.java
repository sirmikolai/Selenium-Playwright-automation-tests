package core.webdriver;

import core.PomParams;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        return new EdgeDriver(options);
    }
}
