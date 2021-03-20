package base;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.text.PDFTextStripper;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

public class ProjectSpecificMethods extends ReadExcelData{
	public static RemoteWebDriver driver;
	public String browser;
	public static JavascriptExecutor js;
	public static SoftAssert as;
	public static WebDriverWait wait;
	public static String excelFileName;
	
	
@BeforeSuite
	public void browserName() {
	browser="chrome";
	as = new SoftAssert();
	}

@BeforeMethod
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
		 driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
			driver.findElementById("password").sendKeys("Bootcamp$123");
			driver.findElementById("Login").click();
	}


public void loadurl() {
		
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we)));

}

public static void javaScriptClick(WebElement we) {
	js.executeScript("arguments[0].click()", we);

}

public static void getwindows(int windowIndex) {
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String>windowHandlesList = new ArrayList<String>(windowHandles);
	
	driver.switchTo().window(windowHandlesList.get(windowIndex));
}

public static boolean readPDF(String pdfurl , String verifyText) throws IOException {
	URL url = new URL(pdfurl);
	
	InputStream openStream = url.openStream();
	BufferedInputStream fileParse = new BufferedInputStream(openStream);
	
	PDDocument document = null;
	document = PDDocument.load(fileParse);
	
	String text = new PDFTextStripper().getText(document);
	
	return text.contains(verifyText);

}

public static void dropdown(WebElement we, String searchby, String value) {
	Select dp = new Select(we);
	
	if(searchby.equalsIgnoreCase("visibletext")) {
		dp.selectByVisibleText(value);
	}
	
	else if(searchby.equalsIgnoreCase("value")) {
		
		dp.selectByValue(value);
	}
	
	else if(searchby.equalsIgnoreCase("index")) {
		dp.selectByIndex(Integer.parseInt(value));
	}

}


@DataProvider(name="fetchData")
public String[][] readDataFromExcel() throws IOException {
	return readExcelSheet(excelFileName);

}


}
