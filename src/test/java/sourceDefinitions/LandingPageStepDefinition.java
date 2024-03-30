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
	LandingPage lp;
    
    public LandingPageStepDefinition(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.lp = testContextSetup.pageObjectManager.getLandingPage();
    }
	
	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() throws IOException {
		String currentURL = testContextSetup.testBase.WebDriverManager().getCurrentUrl();
		String expectedURL = testContextSetup.testBase.url;
		Assert.assertEquals(currentURL, expectedURL);
	}
	
	@When("^user searched with short name (.+) and extracted actual product name$")
	public void user_searched_with_short_name_and_extracted_actual_product_name(String shortName) throws InterruptedException {
		lp.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = lp.getProductName();
	}
	
	@When("^Added (.+) items of the selected product to cart$")
	public void added_items_product(int quantity) {
		lp.incrementQuantity(quantity);
		lp.addToCart();
	}
}
