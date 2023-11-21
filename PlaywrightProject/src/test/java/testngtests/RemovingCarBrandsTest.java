package testngtests;

import listeners.TestListener;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.util.List;

import static models.enums.SystemAlerts.SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT;

@Listeners(TestListener.class)
public class RemovingCarBrandsTest extends AbstractTest {

    @Test
    public void removingCarBrandsTest() {
        signIn(existedSimpleUser);
        List<String> carBrandsToDelete = carBrandsBrowsePage.getCarBrandsToDelete();
        carBrandsToDelete.forEach(carBrandName -> {
            carBrandsBrowsePage.deleteCarBrandForName(carBrandName);
            assertThatSuccessAlertHasExpectedText(SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT.getAlertText());
            assertThatCarBrandIsExistOrNot(carBrandName, false);
        });
    }

    private void assertThatCarBrandIsExistOrNot(String carBrandName, boolean shouldExist) {
        Assertions.assertThat(carBrandsBrowsePage.isCardWithCarBrandNameVisible(carBrandName))
                .as(String.format("Assert that car brand with name %s is exist: %s", carBrandName, shouldExist))
                .isEqualTo(shouldExist);
    }

}
