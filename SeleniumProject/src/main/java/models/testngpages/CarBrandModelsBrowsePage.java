package models.testngpages;

import models.CarModelClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarBrandModelsBrowsePage extends MainPage {

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
        driver.findElement(By.xpath(ADD_CAR_MODEL_BUTTON_XPATH)).click();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarModelFormPage.ROOT_CSS)));
        return new CarModelFormPage(driver);
    }

    public boolean isRowWithCarModelNameVisible(String name) {
        return !driver.findElements(By.xpath(String.format(ROW_BY_NAME_XPATH, name))).isEmpty();
    }

    public String getCarBrandLogoUrl() {
        seleniumWait.waitForPageInitialization();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath(CAR_BRAND_LOGO_URL_XPATH)));
        return driver.findElement(By.xpath(CAR_BRAND_LOGO_URL_XPATH)).getAttribute("src");
    }

    public String getCarBrandName() {
        return driver.findElement(By.xpath(CAR_BRAND_NAME_XPATH)).getText();
    }

    public String getCarModelNameForName(String name) {
        return driver.findElement(By.xpath(String.format(CAR_MODEL_NAME_XPATH, name))).getText();
    }

    public CarModelClass getCarModelClassForName(String name) {
        String className = driver.findElement(By.xpath(String.format(CAR_MODEL_CLASS_XPATH, name))).getText();
        for (CarModelClass carModelClass : CarModelClass.values()) {
            if (className.equalsIgnoreCase(carModelClass.getDisplayedText())) {
                return carModelClass;
            }
        }
        return null;
    }

    public int getCarModelNumberOfGenerationsForName(String name) {
        return Integer.parseInt(driver.findElement(By.xpath(String.format(CAR_MODEL_NUMBER_OF_GENERATIONS_XPATH, name))).getText());
    }

    public CarModelFormPage editCarModelForName(String name) {
        scrollIntoView(driver.findElement(By.xpath(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name))));
        seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(By.xpath(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name))));
        clickElementBy(By.xpath(String.format(CAR_MODEL_EDIT_BUTTON_XPATH, name)));
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CarModelFormPage.ROOT_CSS)));
        return new CarModelFormPage(driver);
    }

    public CarBrandModelsBrowsePage deleteCarModelForName(String name) {
        scrollIntoView(driver.findElement(By.xpath(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name))));
        seleniumWait.waitUntil(ExpectedConditions.elementToBeClickable(By.xpath(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name))));
        clickElementBy(By.xpath(String.format(CAR_MODEL_DELETE_BUTTON_XPATH, name)));
        driver.switchTo().alert().accept();
        return this;
    }

}
