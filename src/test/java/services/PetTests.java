package services;


import com.cucumber.listener.Reporter;
import org.junit.AfterClass;

import java.io.File;


public class PetTests
{

	@AfterClass

	public void coreTest() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "kmaayeh");
		Reporter.setSystemInfo("Application Name", "Pet Store API Testing");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name"));
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");	}


}
