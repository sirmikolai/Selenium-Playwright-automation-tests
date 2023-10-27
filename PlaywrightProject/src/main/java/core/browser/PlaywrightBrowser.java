package core.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import core.browserfactory.BrowserFactory;

public class PlaywrightBrowser {

    private final BrowserFactory browserFactory;

    public PlaywrightBrowser(BrowserFactory browserFactory) {
        this.browserFactory = browserFactory;
    }

    public Browser getBrowser(Playwright playwright) {
        return this.browserFactory.launchBrowser(playwright);
    }
}
