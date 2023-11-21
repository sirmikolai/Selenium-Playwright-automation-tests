package core.browserfactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import core.PomParams;

public class ChromeBrowserFactory implements BrowserFactory, PomParams {

    public Browser launchBrowser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadlessModeEnabled()).setChannel("chrome"));
    }
}
