package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage {
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(), 'Place Order')]");
	
    WebDriver driver;
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void CheckoutItems(int quantity) throws InterruptedException {
    	driver.findElement(cartBag).click();
    	driver.findElement(checkOutButton).click();
    	Thread.sleep(1000);
    	getValue(quantity);
    }
    
    public Boolean VerifyPromoBtn() {
    	return driver.findElement(promoBtn).isDisplayed();
    }
    
    public Boolean VerifyPlaceOrder() {
    	return driver.findElement(placeOrder).isDisplayed();
    }
    
    public void getValue(int quantity) {
    	List<WebElement> things = driver.findElements(By.cssSelector("tbody tr td"));
    	Assert.assertEquals(quantity, Integer.parseInt(things.get(2).getText()));
    }
}