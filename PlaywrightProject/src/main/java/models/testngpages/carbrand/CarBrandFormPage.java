package models.testngpages.carbrand;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CarBrandFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarBrandFormPage.class);

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
        logger.info(String.format("Input car brand name: %s", name));
        fillField(NAME_INPUT_CSS, name);
        return this;
    }

    public CarBrandFormPage inputLogoUrl(String logoUrl) {
        logger.info(String.format("Input car brand Logo URL: %s", logoUrl));
        fillField(LOGO_URL_INPUT_CSS, logoUrl);
        return this;
    }

    public CarBrandFormPage inputFoundedYear(int foundedYear) {
        logger.info(String.format("Input car brand founded year: %d", foundedYear));
        fillField(FOUNDED_YEAR_INPUT_CSS, String.valueOf(foundedYear));
        return this;
    }

    public CarBrandFormPage inputOfficialSite(String officialSite) {
        logger.info(String.format("Input car brand official site: %s", officialSite));
        fillField(OFFICIAL_SITE_INPUT_CSS, officialSite);
        return this;
    }

    public CarBrandFormPage inputHeadquarterCity(String headquarterCity) {
        logger.info(String.format("Input car brand headquarter city: %s", headquarterCity));
        fillField(HEADQUARTER_CITY_INPUT_CSS, headquarterCity);
        return this;
    }

    public CarBrandFormPage inputHeadquarterCountry(String headquarterCountry) {
        logger.info(String.format("Input car brand headquarter country: %s", headquarterCountry));
        fillField(HEADQUARTER_COUNTRY_INPUT_CSS, headquarterCountry);
        return this;
    }

    public MainPage submit() {
        logger.info("Submit car brand form");
        clickElement(SUBMIT_BUTTON);
        playwrightWait.waitUntil(ROOT_CSS, WaitForSelectorState.HIDDEN);
        return new MainPage(playwrightPage);
    }
}
