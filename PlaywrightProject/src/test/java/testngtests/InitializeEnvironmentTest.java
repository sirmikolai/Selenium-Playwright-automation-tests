package testngtests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testngtests.abstractclasses.AbstractTest;

@Listeners(TestListener.class)
public class InitializeEnvironmentTest extends AbstractTest {

    @Test
    public void initializeEnvironmentTest() {
        assertThatMainPageIsVisible();
    }

}
