package individuals;
//https://mercury-bootcamp.atlassian.net/browse/SAL-25?atlOrigin=eyJpIjoiZjg1NmQ2YWZmYjBkNDM1MGE4OTY4ZGVlNjMwZDU0ZjMiLCJwIjoiaiJ9

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SA25CreateIndividuals {

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
		
		driver.findElementByXPath("//span[@class='slds-truncate' and text()='Individuals']/following::*[@class='slds-icon slds-icon-text-default slds-icon_xx-small' and @data-key='chevrondown']").click();
		
		
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[@one-appnavbarmenuitem_appnavbarmenuitem='' and text()='New Individual']"));
		String lName = "sara";
		driver.findElementByXPath("//input[@placeholder='Last Name']").sendKeys(lName);
		driver.findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']").click();
		
		String name = driver.findElementByXPath("//div[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp']/span").getText();		
		
		if(lName.equalsIgnoreCase(name))
		{
			System.out.println("Individuals Created");
		}
		else
		{
			System.out.println("Individuals not Created");
		}
			
	}
}
