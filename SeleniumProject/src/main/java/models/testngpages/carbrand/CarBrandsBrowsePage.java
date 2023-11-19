package models.testngpages.carbrand;

import models.testngpages.MainPage;
import models.testngpages.carbrand.carmodel.CarBrandModelsBrowsePage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CarBrandsBrowsePage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarBrandsBrowsePage.class);

    private static final String ROOT_XPATH = "//div[@class='album py-5 bg-light']";
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
        logger.info(String.format("Check if card with card brand name '%s' is visible", name));
        return isElementDisplayedOnThePage(By.xpath(String.format(CARD_BY_NAME_XPATH, name)), 1);
    }

    public String getCarBrandLogoUrlName(String name) {
        logger.info(String.format("Get car brand logo url for name: %s", name));
        return getAttributeValueFromElement(By.xpath(String.format(CAR_BRAND_LOGO_URL_XPATH, name)), "src");
    }

    public String getCarBrandNameForName(String name) {
        logger.info("Get car brand name");
        return getTextFromElement(By.xpath(String.format(CAR_BRAND_NAME_XPATH, name))).replace("Name: ", "");
    }

    public int getCarBrandFoundedYearForName(String name) {
        logger.info(String.format("Get car brand founded year for name: %s", name));
        return Integer.parseInt(getTextFromElement(By.xpath(String.format(CAR_BRAND_FOUNDED_YEAR_XPATH, name))).replace("Founded year: ", ""));
    }

    public String getCarBrandHeadquarterForName(String name) {
        logger.info(String.format("Get car brand headquarter for name: %s", name));
        return getTextFromElement(By.xpath(String.format(CAR_BRAND_HEADQUARTER_XPATH, name))).replace("Headquarter: ", "");
    }

    public String getCarBrandOfficialSiteForName(String name) {
        logger.info(String.format("Get car brand official site for name: %s", name));
        return getAttributeValueFromElement(By.xpath(String.format(CAR_BRAND_OFFICIAL_SITE_XPATH, name)), "href").replace("https://", "").replace("/", "");
    }

    public CarBrandModelsBrowsePage viewCarBrandModelsForName(String name) {
        logger.info(String.format("Click 'View car brand models' button for car brand name: %s", name));
        clickElement(By.xpath(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(CarBrandModelsBrowsePage.ROOT_XPATH)));
        return new CarBrandModelsBrowsePage(driver);
    }

    public CarBrandFormPage editCarBrandForName(String name) {
        logger.info(String.format("Click 'Edit car brand' button for car brand name: %s", name));
        clickElement(By.xpath(String.format(EDIT_CAR_BRAND_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarBrandFormPage.ROOT_CSS)));
        return new CarBrandFormPage(driver);
    }

    public CarBrandsBrowsePage deleteCarBrandForName(String name) {
        logger.info(String.format("Click 'Delete car brand' button for car brand name: %s", name));
        clickElement(By.xpath(String.format(DELETE_CAR_BRAND_XPATH, name)));
        confirmAlertIfItPresent();
        seleniumWait.waitForPageInitialization();
        return this;
    }

    public List<String> getCarBrandsToDelete() {
        logger.info("Get all car brands to delete");
        return driver.findElements(By.xpath(String.format(CAR_BRAND_NAME_XPATH, "Test"))).stream().map(e -> e.getText().replace("Name: ", "")).collect(Collectors.toList());
    }

}
