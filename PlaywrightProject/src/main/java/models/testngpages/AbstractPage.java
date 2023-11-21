package models.testngpages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.PomParams;
import core.waits.PlaywrightWait;

public abstract class AbstractPage implements PomParams {

    protected Page playwrightPage;
    protected PlaywrightWait playwrightWait;

    protected AbstractPage(Page playwrightPage) {
        this.playwrightPage = playwrightPage;
        this.playwrightWait = new PlaywrightWait(playwrightPage);
    }

    protected void clickElement(final String elementPath) {
        playwrightWait.waitForPageLoad();
        playwrightPage.click(elementPath);
        playwrightWait.waitForPageLoad();
    }

    protected void fillField(final String elementPath, String text) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(elementPath, "");
        playwrightPage.fill(elementPath, text);
        playwrightWait.waitForPageLoad();
    }

    protected boolean isElementDisplayedOnThePage(final String elementPath, int seconds) {
        playwrightWait.waitForPageLoad();
        try {
            playwrightWait.waitUntil(elementPath, WaitForSelectorState.VISIBLE, seconds);
            return true;
        } catch (TimeoutError e) {
            return false;
        }
    }

    protected String getTextFromElement(final String elementPath) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(elementPath).textContent();
    }

    protected String getAttributeValueFromElement(final String elementPath, String attributeName) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(elementPath).getAttribute(attributeName);
    }

}
