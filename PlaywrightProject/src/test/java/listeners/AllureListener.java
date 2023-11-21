package listeners;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import testngtests.abstractclasses.AbstractTest;

import java.io.ByteArrayInputStream;

import static utils.AllureEnvironmentWriter.writeAllureEnvironmentProperties;

public class AllureListener implements TestLifecycleListener {

    private static final Log logger = LogFactory.getLog(AllureListener.class);

    @Override
    public void afterTestStart(TestResult result) {
        logger.info(String.format("=== Test %s started ===", result.getName()));
        writeAllureEnvironmentProperties();
    }

    @Override
    public void beforeTestStop(TestResult result) {
        logger.info(String.format("=== Test %s finished with status %s ===", result.getName(), result.getStatus()));
        Page playwrightPage = AbstractTest.getPageFromThreadLocal();
        if (result.getStatus() != Status.PASSED) {
            if (playwrightPage != null) {
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(playwrightPage.screenshot()));
            }
        }
    }
}
