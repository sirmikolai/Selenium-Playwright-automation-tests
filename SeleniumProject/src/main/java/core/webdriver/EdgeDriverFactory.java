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
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless=new");
        }
        return new EdgeDriver(options);
    }
}
