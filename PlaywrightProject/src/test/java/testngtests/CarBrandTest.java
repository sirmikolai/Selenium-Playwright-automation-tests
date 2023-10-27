package testngtests;

import models.CarBrand;
import models.testngpages.CarBrandFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

public class CarBrandTest extends AbstractTest {

    private CarBrand newCarBrand = new CarBrand.CarBrandBuilder().build();
    private static final String SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT = "Success! Car brand has been updated.";
    private CarBrandFormPage carBrandFormPage;

    @Test
    public void addingCarBrandTest() {
        signIn(existedSimpleUser);
        carBrandFormPage = mainPage.goToAddingCarBrandForm();
        carBrandFormPage.inputName(newCarBrand.getName())
                .inputLogoUrl(newCarBrand.getLogoUrl())
                .inputFoundedYear(newCarBrand.getFoundedYear())
                .inputOfficialSite(newCarBrand.getOfficialSite())
                .inputHeadQuarterCity(newCarBrand.getHeadquarterCity())
                .inputHeadquarterCountry(newCarBrand.getHeadquarterCountry());
        carBrandFormPage.submit();
        Assertions.assertThat(carBrandsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT);
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandNameForName(newCarBrand.getName())).contains(newCarBrand.getName());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandFoundedYearForName(newCarBrand.getName())).isEqualTo(newCarBrand.getFoundedYear());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandLogoUrlName(newCarBrand.getName())).contains(newCarBrand.getLogoUrl());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandHeadquarterForName(newCarBrand.getName())).contains(newCarBrand.getHeadquarter());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandOfficialSiteForName(newCarBrand.getName())).contains(newCarBrand.getOfficialSite());
    }

    @Test(dependsOnMethods = "addingCarBrandTest")
    public void editCarBrandTest() {
        carBrandFormPage = carBrandsBrowsePage.editCarBrandForName(newCarBrand.getName());
        newCarBrand = new CarBrand.CarBrandBuilder().build();
        carBrandFormPage.inputName(newCarBrand.getName())
                .inputLogoUrl(newCarBrand.getLogoUrl())
                .inputFoundedYear(newCarBrand.getFoundedYear())
                .inputOfficialSite(newCarBrand.getOfficialSite())
                .inputHeadQuarterCity(newCarBrand.getHeadquarterCity())
                .inputHeadquarterCountry(newCarBrand.getHeadquarterCountry());
        carBrandFormPage.submit();
        Assertions.assertThat(carBrandsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT);
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandNameForName(newCarBrand.getName())).contains(newCarBrand.getName());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandFoundedYearForName(newCarBrand.getName())).isEqualTo(newCarBrand.getFoundedYear());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandLogoUrlName(newCarBrand.getName())).contains(newCarBrand.getLogoUrl());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandHeadquarterForName(newCarBrand.getName())).contains(newCarBrand.getHeadquarter());
        Assertions.assertThat(carBrandsBrowsePage.getCarBrandOfficialSiteForName(newCarBrand.getName())).contains(newCarBrand.getOfficialSite());
    }

    @Test(dependsOnMethods = {"addingCarBrandTest", "editCarBrandTest"})
    public void deleteCarBrandTest() {
        carBrandsBrowsePage.deleteCarBrandForName(newCarBrand.getName());
        Assertions.assertThat(carBrandsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT);
        Assertions.assertThat(carBrandsBrowsePage.isCardWithCarBrandNameVisible(newCarBrand.getName())).isFalse();
    }

}
