package individuals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SAL27DeleteIndividuals {

	public static void main(String[] args) throws InterruptedException {
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
		
		
		js.executeScript("arguments[0].value='sara'", driver.findElementByXPath("//input[@name='Individual-search-input']"));
		driver.findElementByXPath("//input[@name='Individual-search-input']").sendKeys(Keys.SPACE);
	
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//button[@name='refreshButton']"));
		
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//a[@data-aura-class='forceOutputLookup'])[1]"));
		driver.findElementByXPath("//span[text()='Details']").click();
		driver.findElementByXPath("//button[@title='Edit Name']").click();
		
		String lName = driver.findElementByXPath("//input[@placeholder='Last Name']").getAttribute("value");
		
		driver.findElementByXPath("//div[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']").click();
		
		js.executeScript("arguments[0].value='sara'", driver.findElementByXPath("//input[@name='Individual-search-input']"));
		driver.findElementByXPath("//input[@name='Individual-search-input']").sendKeys(Keys.SPACE);
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//button[@name='refreshButton']"));
		
		if(driver.findElementByXPath("//p[text()='No items to display.']").isEnabled()) {
			System.out.println("Individuals Deleted");
		}
		else {
			System.out.println("Individuals not Deleted");
		}
}
}