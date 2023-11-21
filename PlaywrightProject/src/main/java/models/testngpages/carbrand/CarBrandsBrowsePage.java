package models.testngpages.carbrand;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import models.testngpages.MainPage;
import models.testngpages.carbrand.carmodel.CarBrandModelsBrowsePage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CarBrandsBrowsePage extends MainPage {

    private static final Log logger = LogFactory.getLog(CarBrandsBrowsePage.class);

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

    public CarBrandsBrowsePage(Page playwrightPage) {
        super(playwrightPage);
    }

    public boolean isCardWithCarBrandNameVisible(String name) {
        logger.info(String.format("Check if card with card brand name '%s' is visible", name));
        return isElementDisplayedOnThePage(String.format(CARD_BY_NAME_XPATH, name), 1);
    }

    public String getCarBrandLogoUrlName(String name) {
        logger.info(String.format("Get car brand logo url for name: %s", name));
        return getAttributeValueFromElement(String.format(CAR_BRAND_LOGO_URL_XPATH, name), "src");
    }

    public String getCarBrandNameForName(String name) {
        logger.info("Get car brand name");
        return getTextFromElement(String.format(CAR_BRAND_NAME_XPATH, name)).replace("Name: ", "");
    }

    public int getCarBrandFoundedYearForName(String name) {
        logger.info(String.format("Get car brand founded year for name: %s", name));
        return Integer.parseInt(getTextFromElement(String.format(CAR_BRAND_FOUNDED_YEAR_XPATH, name)).replace("Founded year: ", ""));
    }

    public String getCarBrandHeadquarterForName(String name) {
        logger.info(String.format("Get car brand headquarter for name: %s", name));
        return getTextFromElement(String.format(CAR_BRAND_HEADQUARTER_XPATH, name)).replace("Headquarter: ", "");
    }

    public String getCarBrandOfficialSiteForName(String name) {
        logger.info(String.format("Get car brand official site for name: %s", name));
        return getAttributeValueFromElement(String.format(CAR_BRAND_OFFICIAL_SITE_XPATH, name), "href").replace("https://", "").replace("/", "");
    }

    public CarBrandModelsBrowsePage viewCarBrandModelsForName(String name) {
        logger.info(String.format("Click 'View car brand models' button for car brand name: %s", name));
        clickElement(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name));
        playwrightWait.waitUntil(CarBrandModelsBrowsePage.ROOT_XPATH, WaitForSelectorState.VISIBLE);
        return new CarBrandModelsBrowsePage(playwrightPage);
    }

    public CarBrandFormPage editCarBrandForName(String name) {
        logger.info(String.format("Click 'Edit car brand' button for car brand name: %s", name));
        clickElement(String.format(EDIT_CAR_BRAND_XPATH, name));
        playwrightWait.waitUntil(CarBrandFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarBrandFormPage(playwrightPage);
    }

    public CarBrandsBrowsePage deleteCarBrandForName(String name) {
        logger.info(String.format("Click 'Delete car brand' button for car brand name: %s", name));
        clickElement(String.format(DELETE_CAR_BRAND_XPATH, name));
        return this;
    }

    public List<String> getCarBrandsToDelete() {
        logger.info("Get all car brands to delete");
        List<String> carBrandsNames = (List<String>) playwrightPage.evalOnSelectorAll(String.format(CAR_BRAND_NAME_XPATH, "Test"), "(elements) => elements.map(element => element.textContent)");
        return carBrandsNames.stream().map(name -> name.replace("Name: ", "")).collect(Collectors.toList());
    }

}
