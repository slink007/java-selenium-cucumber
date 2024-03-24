package options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="sourceDefinitions", 
                 monochrome=true)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
}
