package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOppurtunity {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com﻿");
		driver.manage().window().maximize();
		
		driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		driver.findElementById("Login").click();
		
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		
		driver.findElementByXPath("//p[@class='slds-truncate' and text()='Sales']").click();
		
	//	driver.findElementByXPath("//a[@class='slds-context-bar__label-action dndItem' and @title='Opportunities']").click();
		
		
		  WebElement opp = driver.findElementByXPath("//a[@title='Opportunities']");
		  
		  JavascriptExecutor js = (JavascriptExecutor)driver;//upcasting
		  js.executeScript("arguments[0].click()", opp);
		 
		
		driver.findElementByXPath("//div[@title='New']").click();
		
		String opName ="Salesforce Automation by Mahesh";
		
		driver.findElementByXPath("//span[@class='' and text()='Opportunity Name']/following::input[@class=' input' and @type='text' and @aria-required='true']").sendKeys(opName);
		
		driver.findElementByXPath("//div[@class='form-element']//input").click();
		driver.findElementByXPath("//button[@class='today slds-button slds-align_absolute-center slds-text-link']").click();
		
		driver.findElementByXPath("//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']//span[text()='Stage']/following::a[@aria-required='true']").click();
		driver.findElementByXPath("//a[@title='Needs Analysis']").click();
		driver.findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']").click();
		
		String text = driver.findElementByXPath("//slot[@slot='primaryField']//lightning-formatted-text").getText();
		
		if(text.equalsIgnoreCase(opName)) {
		System.out.println("Oppurtunity Created");
	}
		else {
			System.out.println("Oppurtunity not Created");}
		}

}
