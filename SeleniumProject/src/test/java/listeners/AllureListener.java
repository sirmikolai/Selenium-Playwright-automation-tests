package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testngtests.abstractclasses.AbstractTest;

import java.io.ByteArrayInputStream;

public class AllureListener implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {
        WebDriver driver = AbstractTest.getDriverFromThreadLocal();
        if (result.getStatus() != Status.PASSED) {
            if (driver != null) {
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            }
        }
    }
}
