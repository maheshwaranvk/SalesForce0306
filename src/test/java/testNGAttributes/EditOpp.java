package testNGAttributes;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class EditOpp extends BaseClass{
	@Test(groups = {"oppurtunity"})
	public void editOppurtunities() throws InterruptedException {
		
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
			
		js.executeScript("arguments[0].value='Saleforce Automation by Mahesh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@role='menuitem' and @title='Edit']"));
		
		driver.findElementByXPath("//input[@name='CloseDate']").click();
		javaScriptClick(driver.findElementByXPath("//button[text()='Today']"));
		
		driver.findElementByXPath("//label[text()='Stage']/following::input[@required='']").click();
		driver.findElementByXPath("//span[@title='Perception Analysis']").click();
		
		
		driver.findElementByXPath("//label[text()='Delivery/Installation Status']/following::input[@role='combobox']").click();
		driver.findElementByXPath("//span[@title='In progress']").click();
		
		
		driver.findElementByXPath("//label[@data-aura-class='uiLabel']/following::textarea").sendKeys("SalesForce");
		
		driver.findElementByXPath("//button[text()='Save']").click();
		Thread.sleep(2000);
		String text = driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td[@class='slds-cell-edit cellContainer']//span[@class='slds-truncate'])[1]").getText();
		
		as.assertTrue(text.equalsIgnoreCase("Perception Analysis"));
		as.assertAll();
	}
}
