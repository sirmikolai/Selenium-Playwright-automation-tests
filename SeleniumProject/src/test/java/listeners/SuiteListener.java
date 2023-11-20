package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import static utils.AllureEnvironmentWriter.writeAllureEnvironmentProperties;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        writeAllureEnvironmentProperties();
    }

}
