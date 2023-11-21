package testngtests;

import listeners.TestListener;
import models.CarModel;
import models.testngpages.carbrand.CarBrandFormPage;
import models.testngpages.carbrand.carmodel.CarBrandModelsBrowsePage;
import models.testngpages.carbrand.carmodel.CarModelFormPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import static models.enums.SystemAlerts.*;

@Listeners(TestListener.class)
public class CarModelTest extends AbstractTest {

    private CarModel newCarModel = new CarModel.CarModelBuilder().build();
    private CarBrandFormPage carBrandFormPage;
    private CarBrandModelsBrowsePage carBrandModelsBrowsePage;
    private CarModelFormPage carModelFormPage;

    @BeforeClass
    public void prepareCarBrandForTest() {
        signIn(existedSimpleUser);
        carBrandFormPage = mainPage.clickAddCarBrand();
        carBrandFormPage.inputName(newCarModel.getCarBrand().getName())
                .inputLogoUrl(newCarModel.getCarBrand().getLogoUrl())
                .inputFoundedYear(newCarModel.getCarBrand().getFoundedYear())
                .inputOfficialSite(newCarModel.getCarBrand().getOfficialSite())
                .inputHeadquarterCity(newCarModel.getCarBrand().getHeadquarterCity())
                .inputHeadquarterCountry(newCarModel.getCarBrand().getHeadquarterCountry());
        carBrandFormPage.submit();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_ADDED_CAR_BRAND_TEXT.getAlertText());
        carBrandModelsBrowsePage = carBrandsBrowsePage.viewCarBrandModelsForName(newCarModel.getCarBrand().getName());
        assertThatCarBrandNameIsExpected(newCarModel);
        assertThatCarBrandLogoUrlIsExpected(newCarModel);
    }

    @Test
    public void addingCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.addCarModel()
                .inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_ADDED_CAR_MODEL_TEXT.getAlertText());
        assertThatCarModelExistAndHasExpectedData(newCarModel);
    }

    @Test(dependsOnMethods = "addingCarModelTest")
    public void editCarModelTest() {
        carModelFormPage = carBrandModelsBrowsePage.editCarModelForName(newCarModel.getName());
        newCarModel = new CarModel.CarModelBuilder().withCarBrand(newCarModel.getCarBrand()).build();
        carModelFormPage.inputName(newCarModel.getName())
                .selectClass(newCarModel.getCarModelClass())
                .inputNumberOfGenerations(newCarModel.getNumberOfGenerations());
        carModelFormPage.submit();
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_UPDATED_CAR_MODEL_TEXT.getAlertText());
        assertThatCarModelExistAndHasExpectedData(newCarModel);
    }

    @Test(dependsOnMethods = {"addingCarModelTest", "editCarModelTest"})
    public void deleteCarModelTest() {
        carBrandModelsBrowsePage.deleteCarModelForName(newCarModel.getName());
        assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_DELETED_CAR_MODEL_TEXT.getAlertText());
        assertThatCarModelIsExistOrNot(newCarModel, false);
    }

    private void assertThatCarModelExistAndHasExpectedData(CarModel carModel) {
        assertThatCarModelIsExistOrNot(carModel, true);
        assertThatCarBrandNameIsExpected(carModel);
        assertThatCarBrandLogoUrlIsExpected(carModel);
        assertThatCarModelNameIsExpected(carModel);
        assertThatCarModelNumberOfGenerationsIsExpected(carModel);
    }

    private void assertThatCarBrandNameIsExpected(CarModel carModel) {
        Assertions.assertThat(carBrandModelsBrowsePage.getCarBrandName())
                .as(String.format("Assert that car brand has name: %s", carModel.getCarBrand().getName()))
                .isEqualToIgnoringCase(carModel.getCarBrand().getName());
    }

    private void assertThatCarBrandLogoUrlIsExpected(CarModel carModel) {
        Assertions.assertThat(carBrandModelsBrowsePage.getCarBrandLogoUrl())
                .as(String.format("Assert that car brand has logo URL: %s", carModel.getCarBrand().getLogoUrl()))
                .isEqualTo(carModel.getCarBrand().getLogoUrl());
    }

    private void assertThatCarModelNameIsExpected(CarModel carModel) {
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNameForName(carModel.getName()))
                .as(String.format("Assert that car brand has founded year: %s", carModel.getName()))
                .isEqualTo(carModel.getName());
    }

    private void assertThatCarModelNumberOfGenerationsIsExpected(CarModel carModel) {
        Assertions.assertThat(carBrandModelsBrowsePage.getCarModelNumberOfGenerationsForName(carModel.getName()))
                .as(String.format("Assert that car brand has official site: %s", carModel.getNumberOfGenerations()))
                .isEqualTo(carModel.getNumberOfGenerations());
    }

    private void assertThatCarModelIsExistOrNot(CarModel carModel, boolean shouldExist) {
        Assertions.assertThat(carBrandModelsBrowsePage.isRowWithCarModelNameVisible(carModel.getName()))
                .as(String.format("Assert that car model with name %s is exist %s", carModel.getName(), shouldExist))
                .isEqualTo(shouldExist);
    }

}
