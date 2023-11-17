package listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import models.testngpages.MainPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testngtests.abstractclasses.AbstractTest;

import java.io.ByteArrayInputStream;

public class AllureListener implements TestLifecycleListener {

    private static final Log logger = LogFactory.getLog(AllureListener.class);

    @Override
    public void beforeTestStop(TestResult result) {
        WebDriver driver = AbstractTest.getDriverFromThreadLocal();
        if (result.getStatus() != Status.PASSED) {
            if (driver != null) {
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                logger.info(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
            }
        }
    }
}
