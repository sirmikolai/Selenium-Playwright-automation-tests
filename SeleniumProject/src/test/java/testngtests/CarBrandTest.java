package testngtests;

import models.CarBrand;
import models.testngpages.CarBrandFormPage;
import org.testng.Assert;
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
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT);
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandNameForName(newCarBrand.getName()), newCarBrand.getName());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandFoundedYearForName(newCarBrand.getName()), newCarBrand.getFoundedYear());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandLogoUrlName(newCarBrand.getName()), newCarBrand.getLogoUrl());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandHeadquarterForName(newCarBrand.getName()), newCarBrand.getHeadquarter());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandOfficialSiteForName(newCarBrand.getName()), newCarBrand.getOfficialSite());
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
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_UPDATED_CAR_BRAND_TEXT);
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandNameForName(newCarBrand.getName()), newCarBrand.getName());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandFoundedYearForName(newCarBrand.getName()), newCarBrand.getFoundedYear());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandLogoUrlName(newCarBrand.getName()), newCarBrand.getLogoUrl());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandHeadquarterForName(newCarBrand.getName()), newCarBrand.getHeadquarter());
        Assert.assertEquals(carBrandsBrowsePage.getCarBrandOfficialSiteForName(newCarBrand.getName()), newCarBrand.getOfficialSite());
    }

    @Test(dependsOnMethods = {"addingCarBrandTest", "editCarBrandTest"})
    public void deleteCarBrandTest() {
        carBrandsBrowsePage.deleteCarBrandForName(newCarBrand.getName());
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT);
        Assert.assertFalse(carBrandsBrowsePage.isCardWithCarBrandNameVisible(newCarBrand.getName()));
    }

}
