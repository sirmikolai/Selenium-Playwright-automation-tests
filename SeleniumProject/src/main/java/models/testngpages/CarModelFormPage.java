package models.testngpages;

import models.CarModelClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarModelFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action*='/car-models']";
    private static final String NAME_INPUT_CSS = ROOT_CSS + " input[name='name']";
    private static final String CLASS_SELECT_CSS = ROOT_CSS + " select[name='class']";
    private static final String NUMBER_OF_GENERATIONS_INPUT = ROOT_CSS + " input[name='number_of_generations']";
    private static final String SUBMIT_BUTTON = ROOT_CSS + " button[type='submit']";

    public CarModelFormPage(WebDriver driver) {
        super(driver);
    }

    public CarModelFormPage inputName(String name) {
        driver.findElement(By.cssSelector(NAME_INPUT_CSS)).clear();
        driver.findElement(By.cssSelector(NAME_INPUT_CSS)).sendKeys(name);
        return this;
    }

    public CarModelFormPage selectClass(CarModelClass carModelClass) {
        Select classSelect = new Select(driver.findElement(By.cssSelector(CLASS_SELECT_CSS)));
        classSelect.selectByVisibleText(carModelClass.getDisplayedText());
        return this;
    }

    public CarModelFormPage inputNumberOfGenerations(int numberOfGenerations) {
        driver.findElement(By.cssSelector(NUMBER_OF_GENERATIONS_INPUT)).clear();
        driver.findElement(By.cssSelector(NUMBER_OF_GENERATIONS_INPUT)).sendKeys(String.valueOf(numberOfGenerations));
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
