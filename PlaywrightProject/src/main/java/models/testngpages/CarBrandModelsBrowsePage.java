package models.testngpages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.CarModelClass;

public class CarBrandModelsBrowsePage extends MainPage {

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
        playwrightWait.waitForPageLoad();
        playwrightPage.click(ADD_CAR_MODEL_BUTTON_XPATH);
        playwrightWait.waitUntil(CarModelFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarModelFormPage(playwrightPage);
    }

    public boolean isRowWithCarModelNameVisible(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.isVisible(String.format(ROW_BY_NAME_XPATH, name));
    }

    public String getCarBrandLogoUrl() {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(CAR_BRAND_LOGO_URL_XPATH).getAttribute("src");
    }

    public String getCarBrandName() {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(CAR_BRAND_NAME_XPATH).textContent();
    }

    public String getCarModelNameForName(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(String.format(CAR_MODEL_NAME_XPATH, name)).textContent();
    }

    public CarModelClass getCarModelClassForName(String name) {
        playwrightWait.waitForPageLoad();
        String className = playwrightPage.locator(String.format(CAR_MODEL_CLASS_XPATH, name)).textContent();
        for (CarModelClass carModelClass : CarModelClass.values()) {
            if (className.contains(carModelClass.getDisplayedText())) {
                return carModelClass;
            }
        }
        return null;
    }

    public int getCarModelNumberOfGenerationsForName(String name) {
        playwrightWait.waitForPageLoad();
        return Integer.parseInt(playwrightPage.locator(String.format(CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH, name)).textContent());
    }

    public CarModelFormPage editCarModelForName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name));
        playwrightWait.waitUntil(CarModelFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarModelFormPage(playwrightPage);
    }

    public CarBrandModelsBrowsePage deleteCarModelForName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name)).scrollIntoViewIfNeeded();
        playwrightPage.locator(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name)).click();
        playwrightPage.onDialog(Dialog::accept);
        playwrightWait.waitForPageLoad();
        return this;
    }

}
