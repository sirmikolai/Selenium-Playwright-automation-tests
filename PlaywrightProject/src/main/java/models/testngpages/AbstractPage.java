package models.testngpages;

import com.microsoft.playwright.Page;
import core.PomParams;
import core.waits.PlaywrightWait;

public abstract class AbstractPage implements PomParams {

    protected Page playwrightPage;
    protected PlaywrightWait playwrightWait;

    protected AbstractPage(Page playwrightPage) {
        this.playwrightPage = playwrightPage;
        this.playwrightWait = new PlaywrightWait(playwrightPage);
    }

}
