package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public String url;

	public WebDriver WebDriverManager() throws IOException {
		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/global.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String browser_prop = prop.getProperty("browser");
			String browser_mvn = System.getProperty("browser");
			String browser = browser_mvn != null ? browser_mvn : browser_prop;

			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
			url = prop.getProperty("url");
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}
}
