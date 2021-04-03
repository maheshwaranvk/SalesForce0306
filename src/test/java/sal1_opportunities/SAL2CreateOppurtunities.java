package sal1_opportunities;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import base.ProjectSpecificMethods3;

public class SAL2CreateOppurtunities extends ProjectSpecificMethods3 {
	
	@BeforeSuite
	public void readExcelName() {
		excelFileName="CreateIndi";
	}

	@Test(dataProvider="fetchData")
	public void createOppurtunities(String opName) {
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
		driver.findElementByXPath("//div[@title='New']").click();
		
		//String opName ="Salesforce Automation by Sara";
		
		waitForIt("//h2[text()='New Opportunity']");
		
		
		
		driver.findElementByXPath("//input[@name='Name']").sendKeys(opName);
		
		driver.findElementByXPath("//label[text()='Close Date']/following::input[@type='text' and @name='CloseDate']").click();
		
		javaScriptClick(driver.findElementByXPath("//button[text()='Today']"));
		
		javaScriptClick(driver.findElementByXPath("//label[text()='Stage']/following::input[@role='combobox' and @required='']"));
		driver.findElementByXPath("//span[@title='Needs Analysis']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		
		String text = driver.findElementByXPath("//slot[@slot='primaryField']//lightning-formatted-text").getText();
		
		as.assertTrue(text.equalsIgnoreCase(opName));
		as.assertAll();
		
	}
	
}

