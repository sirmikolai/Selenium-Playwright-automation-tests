package testngtests;

import listeners.TestListener;
import models.CarBrand;
import models.testngpages.carbrand.CarBrandFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import static models.enums.SystemAlerts.*;

@Listeners(TestListener.class)
public class CarBrandTest extends AbstractTest {

    private CarBrand newCarBrand = new CarBrand.CarBrandBuilder().build();
    private CarBrandFormPage carBrandFormPage;

    @Test
    public void addingCarBrandTest() {
        signIn(existedSimpleUser);
        carBrandFormPage = mainPage.clickAddCarBrand();
        carBrandFormPage.inputName(newCarBrand.getName())
                .inputLogoUrl(newCarBrand.getLogoUrl())
                .inputFoundedYear(newCarBrand.getFoundedYear())
                .inputOfficialSite(newCarBrand.getOfficialSite())
                .inputHeadquarterCity(newCarBrand.getHeadquarterCity())
                .inputHeadquarterCountry(newCarBrand.getHeadquarterCountry())
                .submit();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT.getAlertText());
        assertThatCarBrandExistAndHasExpectedData(newCarBrand);
    }

    @Test(dependsOnMethods = "addingCarBrandTest")
    public void editCarBrandTest() {
        carBrandFormPage = carBrandsBrowsePage.editCarBrandForName(newCarBrand.getName());
        newCarBrand = new CarBrand.CarBrandBuilder().build();
        carBrandFormPage.inputName(newCarBrand.getName())
                .inputLogoUrl(newCarBrand.getLogoUrl())
                .inputFoundedYear(newCarBrand.getFoundedYear())
                .inputOfficialSite(newCarBrand.getOfficialSite())
                .inputHeadquarterCity(newCarBrand.getHeadquarterCity())
                .inputHeadquarterCountry(newCarBrand.getHeadquarterCountry())
                .submit();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT.getAlertText());
        assertThatCarBrandExistAndHasExpectedData(newCarBrand);
    }

    @Test(dependsOnMethods = {"addingCarBrandTest", "editCarBrandTest"})
    public void deleteCarBrandTest() {
        carBrandsBrowsePage.deleteCarBrandForName(newCarBrand.getName());
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT.getAlertText());
        assertThatCarBrandIsExistOrNot(newCarBrand, false);
    }

    private void assertThatCarBrandExistAndHasExpectedData(CarBrand carBrand) {
        assertThatCarBrandIsExistOrNot(carBrand, true);
        assertThatCarBrandNameIsExpected(carBrand);
        assertThatCarBrandFoundedYearIsExpected(carBrand);
        assertThatCarBrandLogoUrlIsExpected(carBrand);
        assertThatCarBrandHeadquarterIsExpected(carBrand);
        assertThatCarBrandOfficialSiteIsExpected(carBrand);
    }

    private void assertThatCarBrandNameIsExpected(CarBrand carBrand) {
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandNameForName(carBrand.getName()))
                .as(String.format("Assert that car brand has name: %s", carBrand.getName()))
                .isEqualToIgnoringCase(carBrand.getName());
    }

    private void assertThatCarBrandFoundedYearIsExpected(CarBrand carBrand) {
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandFoundedYearForName(carBrand.getName()))
                .as(String.format("Assert that car brand has founded year: %d", carBrand.getFoundedYear()))
                .isEqualTo(carBrand.getFoundedYear());
    }

    private void assertThatCarBrandLogoUrlIsExpected(CarBrand carBrand) {
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandLogoUrlName(carBrand.getName()))
                .as(String.format("Assert that car brand has logo URL: %s", carBrand.getLogoUrl()))
                .isEqualTo(carBrand.getLogoUrl());
    }

    private void assertThatCarBrandHeadquarterIsExpected(CarBrand carBrand) {
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandHeadquarterForName(carBrand.getName()))
                .as(String.format("Assert that car brand has headquarter: %s", carBrand.getHeadquarter()))
                .isEqualTo(carBrand.getHeadquarter());
    }

    private void assertThatCarBrandOfficialSiteIsExpected(CarBrand carBrand) {
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandOfficialSiteForName(carBrand.getName()))
                .as(String.format("Assert that car brand has official site: %s", carBrand.getOfficialSite()))
                .isEqualTo(carBrand.getOfficialSite());
    }

    private void assertThatCarBrandIsExistOrNot(CarBrand carBrand, boolean shouldExist) {
        Assertions.assertThat(carBrandsBrowsePage.isCardWithCarBrandNameVisible(carBrand.getName()))
                .as(String.format("Assert that car brand with name %s is exist: %s", carBrand.getName(), shouldExist))
                .isEqualTo(shouldExist);
    }

}
