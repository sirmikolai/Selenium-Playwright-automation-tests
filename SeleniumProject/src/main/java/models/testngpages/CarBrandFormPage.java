package models.testngpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarBrandFormPage extends MainPage {

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
        driver.findElement(By.cssSelector(NAME_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(NAME_INPUT_CSS)).sendKeys(name);
        return this;
    }

    public CarBrandFormPage inputLogoUrl(String logoUrl) {
        driver.findElement(By.cssSelector(LOGO_URL_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(LOGO_URL_INPUT_CSS)).sendKeys(logoUrl);
        return this;
    }

    public CarBrandFormPage inputFoundedYear(int foundedYear) {
        driver.findElement(By.cssSelector(FOUNDED_YEAR_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(FOUNDED_YEAR_INPUT_CSS)).sendKeys(String.valueOf(foundedYear));
        return this;
    }

    public CarBrandFormPage inputOfficialSite(String officialSite) {
        driver.findElement(By.cssSelector(OFFICIAL_SITE_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(OFFICIAL_SITE_INPUT_CSS)).sendKeys(officialSite);
        return this;
    }

    public CarBrandFormPage inputHeadQuarterCity(String headquarterCity) {
        driver.findElement(By.cssSelector(HEADQUARTER_CITY_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(HEADQUARTER_CITY_INPUT_CSS)).sendKeys(headquarterCity);
        return this;
    }

    public CarBrandFormPage inputHeadquarterCountry(String headquarterCountry) {
        driver.findElement(By.cssSelector(HEADQUARTER_COUNTRY_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(HEADQUARTER_COUNTRY_INPUT_CSS)).sendKeys(headquarterCountry);
        return this;
    }

    public MainPage submit() {
        driver.findElement(By.cssSelector(SUBMIT_BUTTON)).click();
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
        return new MainPage(driver);
    }
}
