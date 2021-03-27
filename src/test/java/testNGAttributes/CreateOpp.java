package testNGAttributes;

import org.testng.annotations.Test;

public class CreateOpp extends BaseClass{
	@Test(groups = {"oppurtunity"},invocationCount = 2,threadPoolSize = 2)
	public void createOppurtunities() {
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
		driver.findElementByXPath("//div[@title='New']").click();
		
		waitForIt("//h2[text()='New Opportunity']");
		driver.findElementByXPath("//input[@name='Name']").sendKeys("SalesForce Automation by Pugazh");
		
		driver.findElementByXPath("//label[text()='Close Date']/following::input[@type='text' and @name='CloseDate']").click();
		
		javaScriptClick(driver.findElementByXPath("//button[text()='Today']"));
		
		javaScriptClick(driver.findElementByXPath("//label[text()='Stage']/following::input[@role='combobox' and @required='']"));
		driver.findElementByXPath("//span[@title='Needs Analysis']").click();
		driver.findElementByXPath("//button[text()='Save']").click();
		
		String text = driver.findElementByXPath("//slot[@slot='primaryField']//lightning-formatted-text").getText();
		
		as.assertTrue(text.equalsIgnoreCase("SalesForce Automation by Pugazh"));
		as.assertAll();
		
	}
}
