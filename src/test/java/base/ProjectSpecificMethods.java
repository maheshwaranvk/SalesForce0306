package base;

import java.sql.Time;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public static RemoteWebDriver driver;
	public String browser;
	public static JavascriptExecutor js;
	public static SoftAssert as;
	public static WebDriverWait wait;
	
	
@BeforeSuite
	public void browserName() {
	browser="chrome";
	as = new SoftAssert();
	}

@BeforeTest
public void openBrowser() {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);	
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 js = (JavascriptExecutor)driver;
		 driver.manage().deleteAllCookies();
	}

@BeforeClass
public void loadurl() {
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		driver.findElementById("Login").click();
	}

public static void clickMenu() {
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	driver.findElementByXPath("//button[text()='View All']").click();

}

public static void datePicker(String date) {

	Map<String,Integer> months = new HashMap<String,Integer>();
	months.put("JANUARY", 1);
	months.put("FEBRUARY", 2);
	months.put("MARCH", 3);
	months.put("APRIL", 4);
	months.put("MAY", 5);
	months.put("JUNE", 6);
	months.put("JULY", 7);
	months.put("AUGUST", 8);
	months.put("SEPTEMBER", 9);
	months.put("OCTOBER", 10);
	months.put("NOVEMBER", 11);
	months.put("DECEMBER", 12);
	
	Set<Entry<String, Integer>> entrySet = months.entrySet();

	driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
	driver.findElementByXPath("//button[text()='Today']").click();
	String attribute = driver.findElementByXPath("//a[@class='datePicker-openIcon display']/preceding-sibling::input").getAttribute("value");
	String[] today = attribute.split("/");
	String[] givenDate = date.split("/");
	
	int month = Integer.parseInt(today[0]);
	int givenDateMonth = Integer.parseInt(givenDate[0]);
	driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
	//SetMonth
	if(givenDateMonth> month)
		
	{
		
		while(givenDateMonth> month) {
		driver.findElementByXPath("//a[@title='Go to next month']").click();
		String text = driver.findElementByXPath("//h2[@class='monthYear']").getText();
		month=months.get(text);
		}
	}
	else if(givenDateMonth< month)
		
	{
		
		while(givenDateMonth< month) {
		driver.findElementByXPath("//a[@title='Go to previous month']").click();
		String text = driver.findElementByXPath("//h2[@class='monthYear']").getText();
		month=months.get(text);
		}
	}
	
	//Set Date
	Select year = new Select(driver.findElementByXPath("//select[@class='slds-select picklist__label']"));
	year.selectByVisibleText(givenDate[2]);
	driver.findElementByXPath("//table[@class='calGrid']//tr//span[text()='"+Integer.parseInt(givenDate[1])+"']").click();
}

public static void checkDisplay(String linkName) {
	as.assertTrue(driver.findElementByXPath("//div[@class='cs-card tile']//a[text()='"+linkName+"']").isDisplayed());
}

public void waitForIt(String we) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(we)));

}

public static void javaScriptClick(WebElement we) {
	js.executeScript("arguments[0].click()", we);

}
}
