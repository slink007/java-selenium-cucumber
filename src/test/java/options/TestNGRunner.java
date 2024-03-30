package options;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="sourceDefinitions", 
                 monochrome=true, tags="@PlaceOrder or @OffersPage",
                 plugin={"html:target/cucumber.html", "json:target/cucumber.json",
                		 "junit:target/cucumber.xml",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})  // Add , tags="@PlaceOrder" to only run that scenario
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios() {
		return super.scenarios();
	}
}
