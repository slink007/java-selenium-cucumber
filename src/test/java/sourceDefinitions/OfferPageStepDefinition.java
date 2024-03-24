package sourceDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
    TestContextSetup testContextSetup;
    
    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }
    
    @Then("user searched for same short name {string} on offers page to check if product exists")
	public void user_searched_for_same_short_name_on_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
    	switchToOffersPage();
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        String offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
    
    public void switchToOffersPage() {
    	if(!testContextSetup.driver.getCurrentUrl().
    			equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
    		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
            Set<String> handles = testContextSetup.driver.getWindowHandles();
            Iterator<String> i1 = handles.iterator();
            /*String parentWindow = */ i1.next();
            String childWindow = i1.next();
            testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            testContextSetup.driver.switchTo().window(childWindow);
    	}
    }
}
