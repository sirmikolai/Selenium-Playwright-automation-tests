package testngtests;

import models.CarModel;
import models.testngpages.CarBrandFormPage;
import models.testngpages.CarBrandModelsBrowsePage;
import models.testngpages.CarModelFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

public class CarModelTest extends AbstractTest {

    private CarModel newCarModel = new CarModel.CarModelBuilder().build();
    private static final String SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT = "Success! Car model has been added.";
    private static final String SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT = "Success! Car model has been updated.";
    private static final String SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT = "Success! Car model has been removed.";
    private CarBrandFormPage carBrandFormPage;
    private CarBrandModelsBrowsePage carBrandModelsBrowsePage;
    private CarModelFormPage carModelFormPage;

    @BeforeClass
    public void prepareCarBrandForTest() {
        signIn(existedSimpleUser);
        carBrandFormPage = mainPage.goToAddingCarBrandForm();
        carBrandFormPage.inputName(newCarModel.getCarBrand().getName())
                .inputLogoUrl(newCarModel.getCarBrand().getLogoUrl())
                .inputFoundedYear(newCarModel.getCarBrand().getFoundedYear())
                .inputOfficialSite(newCarModel.getCarBrand().getOfficialSite())
                .inputHeadQuarterCity(newCarModel.getCarBrand().getHeadquarterCity())
                .inputHeadquarterCountry(newCarModel.getCarBrand().getHeadquarterCountry());
        carBrandFormPage.submit();
        Assert.assertEquals(mainPage.getTextFromSuccessAlert(), SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT);
        carBrandModelsBrowsePage = carBrandsBrowsePage.viewCarBrandModelsForName(newCarModel.getCarBrand().getName());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarBrandLogoUrl(), newCarModel.getCarBrand().getLogoUrl());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarBrandName(), newCarModel.getCarBrand().getName());
    }

    @Test
    public void addingCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.addCarModel()
                .inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        Assert.assertEquals(carBrandModelsBrowsePage.getTextFromSuccessAlert(), SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT);
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelNameForName(newCarModel.getName()), newCarModel.getName());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelClassForName(newCarModel.getName()), newCarModel.getCarModelClass());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelNumberOfGenerationsForName(newCarModel.getName()), newCarModel.getNumberOfGenerations());
    }

    @Test(dependsOnMethods = "addingCarModelTest")
    public void editCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.editCarModelForName(newCarModel.getName());
        newCarModel = new CarModel.CarModelBuilder().withCarBrand(newCarModel.getCarBrand()).build();
        carModelFormPage.inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        Assert.assertEquals(carBrandModelsBrowsePage.getTextFromSuccessAlert(), SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT);
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelNameForName(newCarModel.getName()), newCarModel.getName());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelClassForName(newCarModel.getName()), newCarModel.getCarModelClass());
        Assert.assertEquals(carBrandModelsBrowsePage.getCarModelNumberOfGenerationsForName(newCarModel.getName()), newCarModel.getNumberOfGenerations());
    }

    @Test(dependsOnMethods = {"addingCarModelTest", "editCarModelTest"})
    public void deleteCarBrandTest() {
        carBrandModelsBrowsePage.deleteCarModelForName(newCarModel.getName());
        Assert.assertEquals(carBrandModelsBrowsePage.getTextFromSuccessAlert(), SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT);
        Assert.assertFalse(carBrandModelsBrowsePage.isRowWithCarModelNameVisible(newCarModel.getName()));
    }

}
