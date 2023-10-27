package models.testngpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CarBrandsBrowsePage extends MainPage {

    public static final String ROOT_XPATH = "//div[@class='album py-5 bg-light']";
    private static final String CARD_BY_NAME_XPATH = ROOT_XPATH + "//div[@class='col'][div//*[contains(text(),'%s')]]";
    private static final String CAR_BRAND_LOGO_URL_XPATH = CARD_BY_NAME_XPATH + "//img";
    private static final String CAR_BRAND_NAME_XPATH = CARD_BY_NAME_XPATH + "//*[contains(text(),'Name')]//parent::p";
    private static final String CAR_BRAND_FOUNDED_YEAR_XPATH = CARD_BY_NAME_XPATH + "//*[contains(text(),'Founded year')]//parent::p";
    private static final String CAR_BRAND_HEADQUARTER_XPATH = CARD_BY_NAME_XPATH + "//*[contains(text(),'Headquarter')]//parent::p";
    private static final String CAR_BRAND_OFFICIAL_SITE_XPATH = CARD_BY_NAME_XPATH + "//*[contains(text(),'Official site')]/following-sibling::a";
    private static final String VIEW_CAR_BRAND_MODELS_XPATH = CARD_BY_NAME_XPATH + "//a[contains(text(),'View car models')]";
    private static final String EDIT_CAR_BRAND_XPATH = CARD_BY_NAME_XPATH + "//a[contains(text(),'Edit car brand')]";
    private static final String DELETE_CAR_BRAND_XPATH = CARD_BY_NAME_XPATH + "//a[contains(text(),'Delete car brand')]";

    public CarBrandsBrowsePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCardWithCarBrandNameVisible(String name) {
        return !driver.findElements(By.xpath(String.format(CARD_BY_NAME_XPATH, name))).isEmpty();
    }

    public String getCarBrandLogoUrlName(String name) {
        return driver.findElement(By.xpath(String.format(CAR_BRAND_LOGO_URL_XPATH, name))).getAttribute("src");
    }

    public String getCarBrandNameForName(String name) {
        return driver.findElement(By.xpath(String.format(CAR_BRAND_NAME_XPATH, name))).getText().replace("Name: ", "");
    }

    public int getCarBrandFoundedYearForName(String name) {
        return Integer.parseInt(driver.findElement(By.xpath(String.format(CAR_BRAND_FOUNDED_YEAR_XPATH, name))).getText().replace("Founded year: ", ""));
    }

    public String getCarBrandHeadquarterForName(String name) {
        return driver.findElement(By.xpath(String.format(CAR_BRAND_HEADQUARTER_XPATH, name))).getText().replace("Headquarter: ", "");
    }

    public String getCarBrandOfficialSiteForName(String name) {
        return driver.findElement(By.xpath(String.format(CAR_BRAND_OFFICIAL_SITE_XPATH, name))).getAttribute("href").replace("https://", "").replace("/", "");
    }

    public CarBrandModelsBrowsePage viewCarBrandModelsForName(String name) {
        scrollIntoView(driver.findElement(By.xpath(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name))));
        seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(By.xpath(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name))));
        clickElementBy(By.xpath(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(CarBrandModelsBrowsePage.ROOT_XPATH)));
        seleniumWait.waitForPageInitialization();
        return new CarBrandModelsBrowsePage(driver);
    }

    public CarBrandFormPage editCarBrandForName(String name) {
        scrollIntoView(driver.findElement(By.xpath(String.format(EDIT_CAR_BRAND_XPATH, name))));
        seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(By.xpath(String.format(EDIT_CAR_BRAND_XPATH, name))));
        clickElementBy(By.xpath(String.format(EDIT_CAR_BRAND_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarBrandFormPage.ROOT_CSS)));
        return new CarBrandFormPage(driver);
    }

    public CarBrandsBrowsePage deleteCarBrandForName(String name) {
        scrollIntoView(driver.findElement(By.xpath(String.format(DELETE_CAR_BRAND_XPATH, name))));
        seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(By.xpath(String.format(DELETE_CAR_BRAND_XPATH, name))));
        clickElementBy(By.xpath(String.format(DELETE_CAR_BRAND_XPATH, name)));
        driver.switchTo().alert().accept();
        seleniumWait.waitForPageInitialization();
        return this;
    }

    public List<String> getCarBrandsToDelete() {
        return driver.findElements(By.xpath(String.format(CAR_BRAND_NAME_XPATH, "Test"))).stream().map(e -> e.getText().replace("Name: ", "")).collect(Collectors.toList());
    }

}
