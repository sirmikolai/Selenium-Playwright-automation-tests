package core.browserfactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public interface BrowserFactory {

    Browser launchBrowser(Playwright playwright);
}
