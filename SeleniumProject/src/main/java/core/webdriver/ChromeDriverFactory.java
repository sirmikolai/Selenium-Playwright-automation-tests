package core.webdriver;

import core.PomParams;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }
}
