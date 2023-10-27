package testngtests;

import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

import java.util.List;

public class RemovingCarBrandsTest extends AbstractTest {

    @Test
    public void removingCarBrandsTest() {
        signIn(existedSimpleUser);
        List<String> carBrandsToDelete = carBrandsBrowsePage.getCarBrandsToDelete();
        for (String carBrandName: carBrandsToDelete) {
            carBrandsBrowsePage.deleteCarBrandForName(carBrandName);
            Assertions.assertThat(carBrandsBrowsePage.getTextFromSuccessAlert()).contains(SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT);
            Assertions.assertThat(carBrandsBrowsePage.isCardWithCarBrandNameVisible(carBrandName)).isFalse();
        }
    }

}
