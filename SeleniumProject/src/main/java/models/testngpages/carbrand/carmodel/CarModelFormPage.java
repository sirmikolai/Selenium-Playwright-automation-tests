package models.testngpages.carbrand.carmodel;

import models.enums.CarModelClass;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarModelFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarModelFormPage.class);

    static final String ROOT_CSS = "form[action*='/car-models']";
    private static final String NAME_INPUT_CSS = ROOT_CSS + " input[name='name']";
    private static final String CLASS_SELECT_CSS = ROOT_CSS + " select[name='class']";
    private static final String NUMBER_OF_GENERATIONS_INPUT = ROOT_CSS + " input[name='number_of_generations']";
    private static final String SUBMIT_BUTTON = ROOT_CSS + " button[type='submit']";

    CarModelFormPage(WebDriver driver) {
        super(driver);
    }

    public CarModelFormPage inputName(String name) {
        logger.info(String.format("Input car model name: %s", name));
        fillField(By.cssSelector(NAME_INPUT_CSS), name);
        return this;
    }

    public CarModelFormPage selectClass(CarModelClass carModelClass) {
        logger.info(String.format("Input car model class: %s", carModelClass.getDisplayedText()));
        Select classSelect = new Select(driver.findElement(By.cssSelector(CLASS_SELECT_CSS)));
        classSelect.selectByVisibleText(carModelClass.getDisplayedText());
        seleniumWait.waitForExpectedOptionToBeSelected(classSelect, carModelClass.getDisplayedText(), 1);
        return this;
    }

    public CarModelFormPage inputNumberOfGenerations(int numberOfGenerations) {
        logger.info(String.format("Input car model number of generations: %d", numberOfGenerations));
        fillField(By.cssSelector(NUMBER_OF_GENERATIONS_INPUT), String.valueOf(numberOfGenerations));
        return this;
    }

    public MainPage submit() {
        logger.info("Submit car model form");
        clickElement(By.cssSelector(SUBMIT_BUTTON));
        confirmAlertIfItPresent();
        return new MainPage(driver);
    }
}
