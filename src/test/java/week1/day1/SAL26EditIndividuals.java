package week1.day1;
//https://mercury-bootcamp.atlassian.net/browse/SAL-26

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SAL26EditIndividuals {

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
		
		
		js.executeScript("arguments[0].value='kumar'", driver.findElementByXPath("//input[@name='Individual-search-input']"));
		driver.findElementByXPath("//input[@name='Individual-search-input']").sendKeys(Keys.SPACE);
	
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//button[@name='refreshButton']"));
		
		Thread.sleep(3000);
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/parent::lightning-primitive-icon)[1]"));
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@role='menuitem' and @title='Edit']"));
		  
//		  driver.findElementByXPath("(//lightning-icon[@class='slds-icon-utility-down slds-icon_container']/lightning-primitive-icon)[2]").click();
		  
		  driver.
		  findElementByXPath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']//a"
		  ).click(); driver.
		  findElementByXPath("//li[@class='uiMenuItem uiRadioMenuItem']/a[@title='Mr.']"
		  ).click(); driver.
		  findElementByXPath("//input[@class='firstName compoundBorderBottom form-element__row input']"
		  ).sendKeys("Ganesh"); driver.
		  findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']"
		  ).click();
		  
		  String text = driver.
		  findElementByXPath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']/a"
		  ).getText(); if(text.contains("Ganesh")) {
		  System.out.println("FirstName Updated"); } else {
		  System.out.println("Not Updated"); }
		 
		 
	}
}
