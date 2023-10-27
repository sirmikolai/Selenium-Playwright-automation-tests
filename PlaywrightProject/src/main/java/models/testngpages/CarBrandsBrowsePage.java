package models.testngpages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.List;
import java.util.stream.Collectors;

public class CarBrandsBrowsePage extends MainPage {

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
        playwrightWait.waitForPageLoad();
        return playwrightPage.isVisible(String.format(CARD_BY_NAME_XPATH, name));
    }

    public String getCarBrandLogoUrlName(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(String.format(CAR_BRAND_LOGO_URL_XPATH, name)).getAttribute("src");
    }

    public String getCarBrandNameForName(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(String.format(CAR_BRAND_NAME_XPATH, name)).textContent().replace("Name: ", "");
    }

    public int getCarBrandFoundedYearForName(String name) {
        playwrightWait.waitForPageLoad();
        return Integer.parseInt(playwrightPage.locator(String.format(CAR_BRAND_FOUNDED_YEAR_XPATH, name)).textContent().replace("Founded year: ", ""));
    }

    public String getCarBrandHeadquarterForName(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(String.format(CAR_BRAND_HEADQUARTER_XPATH, name)).textContent().replace("Headquarter: ", "");
    }

    public String getCarBrandOfficialSiteForName(String name) {
        playwrightWait.waitForPageLoad();
        return playwrightPage.locator(String.format(CAR_BRAND_OFFICIAL_SITE_XPATH, name)).getAttribute("href").replace("https://", "").replace("/", "");
    }

    public CarBrandModelsBrowsePage viewCarBrandModelsForName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(VIEW_CAR_BRAND_MODELS_XPATH, name));
        playwrightWait.waitUntil(CarBrandModelsBrowsePage.ROOT_XPATH, WaitForSelectorState.VISIBLE);
        return new CarBrandModelsBrowsePage(playwrightPage);
    }

    public CarBrandFormPage editCarBrandForName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(EDIT_CAR_BRAND_XPATH, name)).scrollIntoViewIfNeeded();
        playwrightPage.click(String.format(EDIT_CAR_BRAND_XPATH, name));
        playwrightWait.waitUntil(CarBrandFormPage.ROOT_CSS, WaitForSelectorState.VISIBLE);
        return new CarBrandFormPage(playwrightPage);
    }

    public CarBrandsBrowsePage deleteCarBrandForName(String name) {
        playwrightWait.waitForPageLoad();
        playwrightPage.locator(String.format(DELETE_CAR_BRAND_XPATH, name)).scrollIntoViewIfNeeded();
        playwrightPage.locator(String.format(DELETE_CAR_BRAND_XPATH, name)).click();
        playwrightWait.waitUntil(ROOT_XPATH, WaitForSelectorState.VISIBLE);
        return this;
    }

    public List<String> getCarBrandsToDelete() {
        playwrightWait.waitForPageLoad();
        List<String> carBrandsNames = (List<String>) playwrightPage.evalOnSelectorAll(String.format(CAR_BRAND_NAME_XPATH, "Test"), "(elements) => elements.map(element => element.textContent)");
        return carBrandsNames.stream().map(name -> name.replace("Name: ", "")).collect(Collectors.toList());
    }

}
