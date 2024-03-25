package sourceDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
    TestContextSetup testContextSetup;
    
    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    
    @Then("user searched for same short name {string} on offers page to check if product exists")
	public void user_searched_for_same_short_name_on_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException, IOException {
    	switchToOffersPage();
    	OfferPage op = testContextSetup.pageObjectManager.getOfferPage();
    	op.searchItem(shortName);
    	String offerPageProductName = op.getProductName();
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
    
    public void switchToOffersPage() throws IOException {
    	if(!testContextSetup.testBase.WebDriverManager().
    			getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
    		testContextSetup.genericUtils.SwitchWindowToChild();
    	}
    }
}
