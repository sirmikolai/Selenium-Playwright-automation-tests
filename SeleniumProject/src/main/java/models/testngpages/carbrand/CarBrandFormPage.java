package models.testngpages.carbrand;

import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public CarBrandFormPage(WebDriver driver) {
        super(driver);
    }

    public CarBrandFormPage inputName(String name) {
        logger.info(String.format("Input car brand name: %s", name));
        fillField(By.cssSelector(NAME_INPUT_CSS), name);
        return this;
    }

    public CarBrandFormPage inputLogoUrl(String logoUrl) {
        logger.info(String.format("Input car brand Logo URL: %s", logoUrl));
        fillField(By.cssSelector(LOGO_URL_INPUT_CSS), logoUrl);
        return this;
    }

    public CarBrandFormPage inputFoundedYear(int foundedYear) {
        logger.info(String.format("Input car brand founded year: %d", foundedYear));
        fillField(By.cssSelector(FOUNDED_YEAR_INPUT_CSS), String.valueOf(foundedYear));
        return this;
    }

    public CarBrandFormPage inputOfficialSite(String officialSite) {
        logger.info(String.format("Input car brand official site: %s", officialSite));
        fillField(By.cssSelector(OFFICIAL_SITE_INPUT_CSS), officialSite);
        return this;
    }

    public CarBrandFormPage inputHeadquarterCity(String headquarterCity) {
        logger.info(String.format("Input car brand headquarter city: %s", headquarterCity));
        fillField(By.cssSelector(HEADQUARTER_CITY_INPUT_CSS), headquarterCity);
        return this;
    }

    public CarBrandFormPage inputHeadquarterCountry(String headquarterCountry) {
        logger.info(String.format("Input car brand headquarter country: %s", headquarterCountry));
        fillField(By.cssSelector(HEADQUARTER_COUNTRY_INPUT_CSS), headquarterCountry);
        return this;
    }

    public MainPage submit() {
        logger.info("Submit car brand form");
        clickElement(By.cssSelector(SUBMIT_BUTTON));
        confirmAlertIfItPresent();
        seleniumWait.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ROOT_CSS)));
        return new MainPage(driver);
    }
}
