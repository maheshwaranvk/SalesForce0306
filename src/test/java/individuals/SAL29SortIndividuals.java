package individuals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SAL29SortIndividuals {

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
		
		
		List<WebElement> namesWE = driver.findElementsByXPath("//table[@data-aura-class='uiVirtualDataTable']//a[@data-refid='recordId']");
		
		List<String> names = new ArrayList();		
		
		for (WebElement webElement : namesWE) {
			names.add(webElement.getAttribute("title"));
		}
		
		Collections.sort(names);
				
		  driver.
		  findElementByXPath("//span[@class='slds-truncate' and text()='Name']/..").
		  click();
		  Thread.sleep(3000);
		 
		  
		  List<WebElement> namesWEAfterSort = driver.findElementsByXPath(
		  "//table[@data-aura-class='uiVirtualDataTable']//a[@data-refid='recordId']");
		  List<String> namesAfterSort = new ArrayList();
		  
		  for (WebElement webElement : namesWEAfterSort) {
		  namesAfterSort.add(webElement.getAttribute("title")); }
		 
		  if(names.equals(namesAfterSort))
		  {
			  System.out.println("Individuals are sorted");		  }
		 
		
	else
	{System.out.println("Individuals are not sorted");}

}}
