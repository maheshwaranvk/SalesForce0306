package testNGAttributes;

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
import org.openqa.selenium.firefox.FirefoxProfile;
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

public class BaseClass extends ReadExcelData{
	public static RemoteWebDriver driver;
	//public String browser="chrome";
	public static JavascriptExecutor js;
	public static SoftAssert as;
	public static WebDriverWait wait;
	public static String excelFileName;
	
	

@Parameters({"browser"})
@BeforeMethod
public void openBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);	
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 js = (JavascriptExecutor)driver;
		 driver.manage().deleteAllCookies();
		 driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
			driver.findElementById("password").sendKeys("Bootcamp$123");
			driver.findElementById("Login").click();
			as = new SoftAssert();
	}


public void clickMenu() {
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	driver.findElementByXPath("//button[text()='View All']").click();

}


public void waitForIt(String we) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(we)));

}

public static void javaScriptClick(WebElement we) {
	js.executeScript("arguments[0].click()", we);

}

@DataProvider(name="fetchData")
public String[][] readDataFromExcel() throws IOException {
	return readExcelSheet(excelFileName);

}
public void checkDisplay(String linkName) {
	as.assertTrue(driver.findElementByXPath("//a[text()='"+linkName+"']").isDisplayed());
}


}
