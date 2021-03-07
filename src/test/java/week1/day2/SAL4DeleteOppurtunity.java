package week1.day2;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL4DeleteOppurtunity extends ProjectSpecificMethods{

	@Test
	public void deleteOppurtunity() throws InterruptedException {
		clickMenu();
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
		
		js.executeScript("arguments[0].value='Saleforce Automation by Sara'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']").click();
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].value='Saleforce Automation by Sara'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		as.assertTrue(driver.findElementByXPath("//p[text()='No items to display.']").isDisplayed());
		as.assertAll();
	}
}
