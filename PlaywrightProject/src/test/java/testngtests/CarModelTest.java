package testngtests;

import models.CarModel;
import models.testngpages.CarBrandFormPage;
import models.testngpages.CarBrandModelsBrowsePage;
import models.testngpages.CarModelFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
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
        Assertions.assertThat(carBrandsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT);
        carBrandModelsBrowsePage = carBrandsBrowsePage.viewCarBrandModelsForName(newCarModel.getCarBrand().getName());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarBrandLogoUrl()).contains(newCarModel.getCarBrand().getLogoUrl());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarBrandName()).contains(newCarModel.getCarBrand().getName());
    }

    @Test
    public void addingCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.addCarModel()
                .inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        Assertions.assertThat(carBrandModelsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT);
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNameForName(newCarModel.getName())).contains(newCarModel.getName());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelClassForName(newCarModel.getName())).isEqualTo(newCarModel.getCarModelClass());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNumberOfGenerationsForName(newCarModel.getName())).isEqualTo(newCarModel.getNumberOfGenerations());
    }

    @Test(dependsOnMethods = "addingCarModelTest")
    public void editCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.editCarModelForName(newCarModel.getName());
        newCarModel = new CarModel.CarModelBuilder().withCarBrand(newCarModel.getCarBrand()).build();
        carModelFormPage.inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        Assertions.assertThat(carBrandModelsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT);
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNameForName(newCarModel.getName())).contains(newCarModel.getName());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelClassForName(newCarModel.getName())).isEqualTo(newCarModel.getCarModelClass());
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNumberOfGenerationsForName(newCarModel.getName())).isEqualTo(newCarModel.getNumberOfGenerations());
    }

    @Test(dependsOnMethods = {"addingCarModelTest", "editCarModelTest"})
    public void deleteCarBrandTest() {
        carBrandModelsBrowsePage.deleteCarModelForName(newCarModel.getName());
        Assertions.assertThat(carBrandModelsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT);
        Assertions.assertThat(carBrandModelsBrowsePage.isRowWithCarModelNameVisible(newCarModel.getName())).isFalse();
    }

}
