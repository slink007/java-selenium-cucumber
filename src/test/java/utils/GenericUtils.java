package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SwitchWindowToChild() {
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> handles = driver.getWindowHandles();
        Iterator<String> i1 = handles.iterator();
        /*String parentWindow = */ i1.next();
        String childWindow = i1.next();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.switchTo().window(childWindow);
	}

}
