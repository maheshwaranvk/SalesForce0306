package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIt {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		driver.findElementById("Login").click();
		
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		
		WebElement ind = driver.findElementByXPath("//p[text()='Individuals']");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ind);
		
		
		js.executeScript("arguments[0].value='kumar'", driver.findElementByXPath("//input[@name='Individual-search-input']"));
		
		driver.findElementByXPath("//input[@name='Individual-search-input']").sendKeys(Keys.SPACE);
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//button[@name='refreshButton']"));
	}
}
