package core.browserfactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import core.PomParams;

public class FirefoxBrowserFactory implements BrowserFactory, PomParams {

    public Browser launchBrowser(Playwright playwright) {
        return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
}
