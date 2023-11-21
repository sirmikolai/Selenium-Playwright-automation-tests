package models.testngpages.carbrand.carmodel;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.enums.CarModelClass;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CarModelFormPage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarModelFormPage.class);

    public static final String ROOT_CSS = "form[action*='/car-models']";
    private static final String NAME_INPUT_CSS = ROOT_CSS + " input[name='name']";
    private static final String CLASS_SELECT_CSS = ROOT_CSS + " select[name='class']";
    private static final String NUMBER_OF_GENERATIONS_INPUT = ROOT_CSS + " input[name='number_of_generations']";
    private static final String SUBMIT_BUTTON = ROOT_CSS + " button[type='submit']";

    public CarModelFormPage(Page playwrightPage) {
        super(playwrightPage);
    }

    public CarModelFormPage inputName(String name) {
        logger.info(String.format("Input car model name: %s", name));
        fillField(NAME_INPUT_CSS, name);
        return this;
    }

    public CarModelFormPage selectClass(CarModelClass carModelClass) {
        logger.info(String.format("Input car model class: %s", carModelClass.getDisplayedText()));
        playwrightWait.waitForPageLoad();
        playwrightPage.selectOption(CLASS_SELECT_CSS, new SelectOption().setValue(carModelClass.getDisplayedText()));
        return this;
    }

    public CarModelFormPage inputNumberOfGenerations(int numberOfGenerations) {
        logger.info(String.format("Input car model number of generations: %d", numberOfGenerations));
        fillField(NUMBER_OF_GENERATIONS_INPUT, String.valueOf(numberOfGenerations));
        return this;
    }

    public MainPage submit() {
        logger.info("Submit car model form");
        clickElement(SUBMIT_BUTTON);
        playwrightWait.waitUntil(ROOT_CSS, WaitForSelectorState.HIDDEN);
        return new MainPage(playwrightPage);
    }
}
