package models.testngpages.carbrand.carmodel;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.enums.CarModelClass;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CarBrandModelsBrowsePage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarBrandModelsBrowsePage.class);

    public static final String ROOT_XPATH = "//div[@class='container']";
    private static final String ADD_CAR_MODEL_BUTTON_XPATH = ROOT_XPATH + "//a[contains(@href,'car-models/add-form')]";
    private static final String ROW_BY_NAME_XPATH = ROOT_XPATH + "//tr[td[1][contains(text(),'%s')]]";
    private static final String CAR_BRAND_LOGO_URL_XPATH = "//div[@class='card']//img";
    private static final String CAR_BRAND_NAME_XPATH = "//div[@class='card']//h5";
    private static final String CAR_MODEL_NAME_XPATH = ROW_BY_NAME_XPATH + "/td[1]";
    private static final String CAR_MODEL_CLASS_XPATH = ROW_BY_NAME_XPATH + "/td[2]";
    private static final String CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH = ROW_BY_NAME_XPATH + "/td[3]";
    private static final String CAR_MODEL_EDIT_BUTTON_XPATH = ROW_BY_NAME_XPATH + "/td/a[contains(@href,'car-models/edit-form')]";
    private static final String CAR_MODEL_DELETE_BUTTON_XPATH = ROW_BY_NAME_XPATH + "/td/a[contains(@href,'car-models/delete')]";

    public CarBrandModelsBrowsePage(Page playwrightPage) {
        super(playwrightPage);
    }

    public CarModelFormPage addCarModel() {
        logger.info("Click 'Add car model' button");
        clickElement(ADD_CAR_MODEL_BUTTON_XPATH);
        playwrightWait.waitUntil(CarModelFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarModelFormPage(playwrightPage);
    }

    public boolean isRowWithCarModelNameVisible(String name) {
        logger.info(String.format("Check if row with car model name '%s' is visible", name));
        return isElementDisplayedOnThePage(String.format(ROW_BY_NAME_XPATH, name), 1);
    }

    public String getCarBrandLogoUrl() {
        logger.info("Get car brand logo URL");
        return getAttributeValueFromElement(CAR_BRAND_LOGO_URL_XPATH, "src");
    }

    public String getCarBrandName() {
        logger.info("Get car brand name");
        return getTextFromElement(CAR_BRAND_NAME_XPATH);
    }

    public String getCarModelNameForName(String name) {
        logger.info("Get car model name");
        return getTextFromElement(String.format(CAR_MODEL_NAME_XPATH, name));
    }

    public CarModelClass getCarModelClassForName(String name) {
        logger.info(String.format("Get car model class for name %s", name));
        String className = getTextFromElement(String.format(CAR_MODEL_CLASS_XPATH, name));
        for (CarModelClass carModelClass : CarModelClass.values()) {
            if (className.contains(carModelClass.getDisplayedText())) {
                return carModelClass;
            }
        }
        return null;
    }

    public int getCarModelNumberOfGenerationsForName(String name) {
        logger.info(String.format("Get car model number of generations for name %s", name));
        return Integer.parseInt(getTextFromElement(String.format(CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH, name)));
    }

    public CarModelFormPage editCarModelForName(String name) {
        logger.info(String.format("Click 'Edit car model' button for name %s", name));
        clickElement(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name));
        playwrightWait.waitUntil(CarModelFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarModelFormPage(playwrightPage);
    }

    public CarBrandModelsBrowsePage deleteCarModelForName(String name) {
        logger.info(String.format("Click 'Delete car model' button for name %s", name));
        clickElement(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name));
        return this;
    }

}
