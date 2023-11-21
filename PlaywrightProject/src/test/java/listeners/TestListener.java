package listeners;

import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        new AllureListener().afterTestStart(new TestResult().setName(result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        new AllureListener().beforeTestStop(new TestResult().setName(result.getName()).setStatus(Status.PASSED));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        new AllureListener().beforeTestStop(new TestResult().setName(result.getName()).setStatus(Status.FAILED));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        new AllureListener().beforeTestStop(new TestResult().setName(result.getName()).setStatus(Status.SKIPPED));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        new AllureListener().beforeTestStop(new TestResult().setName(result.getName()).setStatus(Status.BROKEN));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        new AllureListener().beforeTestStop(new TestResult().setName(result.getName()).setStatus(Status.BROKEN));
    }
}
