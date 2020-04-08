package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber","com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
		format = {"json:target/Destination/cucumber.json"},
		glue = {"stepdefs"},
		features = {"src/test/features"})
public class CucumberTests {}
