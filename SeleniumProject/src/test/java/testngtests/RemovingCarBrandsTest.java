package testngtests;

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
            Assert.assertEquals(carBrandsBrowsePage.getTextFromSuccessAlert(), SUCCESS_ALERT_DELETED_CAR_BRAND_TEXT);
            Assert.assertFalse(carBrandsBrowsePage.isCardWithCarBrandNameVisible(carBrandName));
        }
    }

}
