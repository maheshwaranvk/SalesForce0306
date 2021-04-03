package sal79_campaign;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import base.ProjectSpecificMethods2;
import base.ProjectSpecificMethods3;

public class SAL84CCreateNewOpportunity extends ProjectSpecificMethods3{

	@Test
	public void createNewOpp() throws InterruptedException {
		
		String opName="Oppurtunity from Mahesh";
		clickMenu();
		javaScriptClick(driver.findElementByXPath("//p[@class='slds-truncate' and text()='Sales']"));
		
		waitForIt("//span[@title='Quarterly Performance']");
		
		javaScriptClick(driver.findElementByXPath("//div[@class='slds-context-bar']//*[text()='Opportunities']"));
		
		js.executeScript("arguments[0].value='Bootcamp'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@role='menuitem' and @title='Edit']"));
		
		driver.findElementByXPath("//input[@name='Name']").clear();
		driver.findElementByXPath("//input[@name='Name']").sendKeys(opName);

		 Calendar c = Calendar.getInstance(); 
			c.add(Calendar.DATE, 1); 
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			driver.findElementByXPath("//input[@name='CloseDate']").clear();
			
			driver.findElementByXPath("//input[@name='CloseDate']").sendKeys(df.format(c.getTime()));
			
			driver.findElementByXPath("//label[text()='Stage']/following::input[@required='']").click();
			driver.findElementByXPath("//span[@title='Needs Analysis']").click();
			
			driver.findElementByXPath("//button[@name='SaveEdit']").click();
			
			js.executeScript("arguments[0].value='"+opName+"'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
			driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			
			as.assertTrue(driver.findElementByXPath("(//a[@data-refid='recordId' and @title='Oppurtunity from Mahesh'])[1]").isDisplayed());
	}
}
