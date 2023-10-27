package models.testngpages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import models.CarModelClass;

public class CarModelFormPage extends MainPage {

    public static final String ROOT_CSS = "form[action*='/car-models']";
    private static final String NAME_INPUT_CSS = ROOT_CSS + " input[name='name']";
    private static final String CLASS_SELECT_CSS = ROOT_CSS + " select[name='class']";
    private static final String NUMBER_OF_GENERATIONS_INPUT = ROOT_CSS + " input[name='number_of_generations']";
    private static final String SUBMIT_BUTTON = ROOT_CSS + " button[type='submit']";

    public CarModelFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public CarModelFormPage inputName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(NAME_INPUT_CSS, "");
        playwrightPage.fill(NAME_INPUT_CSS, name);
        return this;
    }

    public CarModelFormPage selectClass(CarModelClass carModelClass) {
        playwrightWait.waitForPageLoad();
        playwrightPage.selectOption(CLASS_SELECT_CSS, new SelectOption().setValue(carModelClass.getDisplayedText()));
        return this;
    }

    public CarModelFormPage inputNumberOfGenerations(int numberOfGenerations) {
        playwrightWait.waitForPageLoad();
        playwrightPage.fill(NUMBER_OF_GENERATIONS_INPUT, "");
        playwrightPage.fill(NUMBER_OF_GENERATIONS_INPUT, String.valueOf(numberOfGenerations));
        return this;
    }

    public MainPage submit() {
        playwrightWait.waitForPageLoad();
        playwrightPage.click(SUBMIT_BUTTON);
        return new MainPage(playwrightPage);
    }
}
