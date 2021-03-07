package week1.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SAL28CreateIndividuals {

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
		
		driver.findElementByXPath("//div[@title='New']").click();
		
		driver.findElementByXPath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']//a").click(); 
		driver.findElementByXPath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='Mr.']").click();
		driver.findElementByXPath("//input[@placeholder='First Name']").sendKeys("Mahesh");
		driver.findElementByXPath("(//span[@class=' label bBody' and text()='Save'])[2]").click();
		
		if(driver.findElementByXPath("//li[@class='form-element__help' and text()='Complete this field.']").isEnabled())
		{
			System.out.println("(Complete this field) displayed for the Last Name");
		}
		else
		{
			
			System.out.println("Alert is not displayed");
		}
		
		
	}
}
