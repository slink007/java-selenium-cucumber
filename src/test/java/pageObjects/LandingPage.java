package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By increment = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public void incrementQuantity(int quantity) {
		while(--quantity > 0) {
			driver.findElement(increment).click();
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}

	public String getProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
}
