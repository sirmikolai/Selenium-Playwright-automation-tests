package testngtests;

import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

public class InitializeEnvironmentTest extends AbstractTest {

    @Test
    public void initializeEnvironmentTest() {
        assertThatMainPageIsVisible();
    }

}
