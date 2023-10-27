package core.waits;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PlaywrightWait {

    private Page playwrightPage;
    private static final int TIMEOUT = 25;

    public PlaywrightWait(Page playwrightPage) {
        this.playwrightPage = playwrightPage;
    }

    public void waitForPageLoad(int seconds) {
        playwrightPage.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions()
                .setTimeout(seconds * 1000d)
        );
    }

    public void waitForPageLoad() {
        waitForPageLoad(TIMEOUT);
    }

    public void waitUntil(String cssSelector, WaitForSelectorState waitForSelectorState, int seconds) {
        playwrightPage.waitForSelector(cssSelector, new Page.WaitForSelectorOptions()
                .setState(waitForSelectorState)
                .setTimeout(seconds * 1000d)
        );
    }

    public void waitUntil(String cssSelector, WaitForSelectorState waitForSelectorState) {
        waitUntil(cssSelector, waitForSelectorState, TIMEOUT);
    }

    public void waitInMillis(int milliseconds) {
        sleepInMillis(milliseconds);
    }

    public void waitInSeconds(int seconds) {
        sleepInMillis(seconds * 1000);
    }

    private void sleepInMillis(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}
