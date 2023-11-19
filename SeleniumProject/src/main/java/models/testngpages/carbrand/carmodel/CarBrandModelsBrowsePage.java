package models.testngpages.carbrand.carmodel;

import com.google.common.base.Verify;
import models.enums.CarModelClass;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarBrandModelsBrowsePage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarBrandModelsBrowsePage.class);

    public static final String ROOT_XPATH = "//div[@class='container']";
    private static final String ADD_CAR_MODEL_BUTTON_XPATH = ROOT_XPATH + "//a[contains(@href,'car-models/add-form')]";
    private static final String ROW_BY_NAME_XPATH = ROOT_XPATH + "//tr[td[1][contains(text(),'%s')]]";
    private static final String CAR_BRAND_LOGO_URL_XPATH = "//div[@class='card']/img";
    private static final String CAR_BRAND_NAME_XPATH = "//div[@class='card']//h5";
    private static final String CAR_MODEL_NAME_XPATH = ROW_BY_NAME_XPATH + "/td[1]";
    private static final String CAR_MODEL_CLASS_XPATH = ROW_BY_NAME_XPATH + "/td[2]";
    private static final String CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH = ROW_BY_NAME_XPATH + "/td[3]";
    private static final String CAR_MODEL_EDIT_BUTTON_XPATH = ROW_BY_NAME_XPATH + "/td/a[contains(@href,'car-models/edit-form')]";
    private static final String CAR_MODEL_DELETE_BUTTON_XPATH = ROW_BY_NAME_XPATH + "/td/a[contains(@href,'car-models/delete')]";

    public CarBrandModelsBrowsePage(WebDriver driver) {
        super(driver);
    }

    public CarModelFormPage addCarModel() {
        logger.info("Click 'Add car model' button");
        clickElement(By.xpath(ADD_CAR_MODEL_BUTTON_XPATH));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarModelFormPage.ROOT_CSS)));
        return new CarModelFormPage(driver);
    }

    public boolean isRowWithCarModelNameVisible(String name) {
        logger.info(String.format("Check if row with car model name '%s' is visible", name));
        return isElementDisplayedOnThePage(By.xpath(String.format(ROW_BY_NAME_XPATH, name)), 1);
    }

    public String getCarBrandLogoUrl() {
        logger.info("Get car brand logo URL");
        seleniumWait.waitForPageInitialization();
        return getAttributeValueFromElement(By.xpath(CAR_BRAND_LOGO_URL_XPATH), "src");
    }

    public String getCarBrandName() {
        logger.info("Get car brand name");
        return getTextFromElement(By.xpath(CAR_BRAND_NAME_XPATH));
    }

    public String getCarModelNameForName(String name) {
        logger.info("Get car model name");
        return getTextFromElement(By.xpath(String.format(CAR_MODEL_NAME_XPATH, name)));
    }

    public CarModelClass getCarModelClassForName(String name) {
        logger.info(String.format("Get car model class for name %s", name));
        String className = getTextFromElement(By.xpath(String.format(CAR_MODEL_CLASS_XPATH, name)));
        for (CarModelClass carModelClass : CarModelClass.values()) {
            if (className.equalsIgnoreCase(carModelClass.getDisplayedText())) {
                return carModelClass;
            }
        }
        return null;
    }

    public int getCarModelNumberOfGenerationsForName(String name) {
        logger.info(String.format("Get car model number of generations for name %s", name));
        return Integer.parseInt(getTextFromElement(By.xpath(String.format(CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH, name))));
    }

    public CarModelFormPage editCarModelForName(String name) {
        logger.info(String.format("Click 'Edit car model' button for name %s", name));
        clickElement(By.xpath(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarModelFormPage.ROOT_CSS)));
        return new CarModelFormPage(driver);
    }

    public CarBrandModelsBrowsePage deleteCarModelForName(String name) {
        logger.info(String.format("Click 'Delete car model' button for name %s", name));
        clickElement(By.xpath(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name)));
        confirmAlertIfItPresent();
        Verify.verify(isRowWithCarModelNameVisible(name));
        return this;
    }

}
