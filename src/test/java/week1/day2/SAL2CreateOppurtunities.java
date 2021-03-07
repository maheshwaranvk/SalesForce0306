package week1.day2;


import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL2CreateOppurtunities extends ProjectSpecificMethods {

	@Test
	public void createOppurtunities() {
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
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


