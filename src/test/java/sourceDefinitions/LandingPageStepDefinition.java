package sourceDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	public String landingPageProductName;
	
	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
	    driver = new FirefoxDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    driver.manage().window().maximize();
	}
	
	@When("user searched with short name {string} and extracted actual product name")
	public void user_searched_with_short_name_and_extracted_actual_product_name(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(2000);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	}
}
