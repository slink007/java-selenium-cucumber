package sourceDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	TestContextSetup testContextSetup;
    
    public LandingPageStepDefinition(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
    }
	
	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() throws IOException {
		String currentURL = testContextSetup.testBase.WebDriverManager().getCurrentUrl();
		String expectedURL = testContextSetup.testBase.url;
		Assert.assertEquals(currentURL, expectedURL);
	}
	
	@When("user searched with short name {string} and extracted actual product name")
	public void user_searched_with_short_name_and_extracted_actual_product_name(String shortName) throws InterruptedException {
		LandingPage lp = testContextSetup.pageObjectManager.getLandingPage();
		lp.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = lp.getProductName();
	}
}
