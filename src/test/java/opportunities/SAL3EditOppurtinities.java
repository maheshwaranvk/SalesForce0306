package opportunities;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL3EditOppurtinities extends ProjectSpecificMethods{

	@Test
	public void editOppurtunities() throws InterruptedException {
		
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
			
		js.executeScript("arguments[0].value='Saleforce Automation by Mahesh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@role='menuitem' and @title='Edit']"));
		
		driver.findElementByXPath("//div[@class='form-element']//input").click();
		driver.findElementByXPath("(//span[@class='slds-day weekend todayDate selectedDate DESKTOP uiDayInMonthCell--default']/following::span)[1]").click();
		
		driver.findElementByXPath("//span[@class='label inputLabel uiPicklistLabel-left form-element__label uiPicklistLabel']//span[text()='Stage']/following::a[@aria-required='true']").click();
		driver.findElementByXPath("//a[@title='Perception Analysis']").click();
		
		driver.findElementByXPath("//span[text()='Delivery/Installation Status']/following::a[@class='select']").click();
		driver.findElementByXPath("//li/a[@title='In progress']").click();
		driver.findElementByXPath("//label[@data-aura-class='uiLabel']/following::textarea").sendKeys("SalesForce");
		
		driver.findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']").click();
		Thread.sleep(2000);
		String text = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td[@class='slds-cell-edit cellContainer']//span[@class='slds-truncate'])[1]").getText();
		
		as.assertTrue(text.equalsIgnoreCase("Perception Analysis"));
		as.assertAll();
	}
}
