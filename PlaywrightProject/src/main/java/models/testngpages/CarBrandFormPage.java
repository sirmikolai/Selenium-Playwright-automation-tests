package models.testngpages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;

public class CarBrandFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action*='/car-brand']";
    private static final String NAME_INPUT_CSS = ROOT_CSS + " input[name='name']";
    private static final String LOGO_URL_INPUT_CSS = ROOT_CSS + " input[name='logo_url']";
    private static final String FOUNDED_YEAR_INPUT_CSS = ROOT_CSS + " input[name='founded_year']";
    private static final String OFFICIAL_SITE_INPUT_CSS = ROOT_CSS + " input[name='official_site']";
    private static final String HEADQUARTER_CITY_INPUT_CSS = ROOT_CSS + " input[name='headquarter_city']";
    private static final String HEADQUARTER_COUNTRY_INPUT_CSS = ROOT_CSS + " input[name='headquarter_country']";
    private static final String SUBMIT_BUTTON = ROOT_CSS + " button[type='submit']";

    public CarBrandFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public CarBrandFormPage inputName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(NAME_INPUT_CSS, "");
        playwrightPage.fill(NAME_INPUT_CSS, name);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public CarBrandFormPage inputLogoUrl(String logoUrl) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(LOGO_URL_INPUT_CSS, "");
        playwrightPage.fill(LOGO_URL_INPUT_CSS, logoUrl);
        playwrightWait.waitForPageLoad();
        return this;
    }

    public CarBrandFormPage inputFoundedYear(int foundedYear) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(FOUNDED_YEAR_INPUT_CSS, "");
        playwrightPage.fill(FOUNDED_YEAR_INPUT_CSS, String.valueOf(foundedYear));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public CarBrandFormPage inputOfficialSite(String officialSite) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(OFFICIAL_SITE_INPUT_CSS, "");
        playwrightPage.fill(OFFICIAL_SITE_INPUT_CSS, String.valueOf(officialSite));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public CarBrandFormPage inputHeadQuarterCity(String headquarterCity) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(HEADQUARTER_CITY_INPUT_CSS, "");
        playwrightPage.fill(HEADQUARTER_CITY_INPUT_CSS, String.valueOf(headquarterCity));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public CarBrandFormPage inputHeadquarterCountry(String headquarterCountry) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(HEADQUARTER_COUNTRY_INPUT_CSS, "");
        playwrightPage.fill(HEADQUARTER_COUNTRY_INPUT_CSS, String.valueOf(headquarterCountry));
        playwrightWait.waitForPageLoad();
        return this;
    }

    public MainPage submit() {
        playwrightWait.waitForPageLoad();
        playwrightPage.click(SUBMIT_BUTTON);
        playwrightPage.onDialog(Dialog::accept);
        playwrightWait.waitForPageLoad();
        return new MainPage(playwrightPage);
    }
}
