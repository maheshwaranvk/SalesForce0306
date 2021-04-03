package sal18_dashboard;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL23VerifyDashboard extends ProjectSpecificMethods{

	int iValue;
	@Test
	public void verifyDashB() throws InterruptedException {
		
		String name = "Mahesh";
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Dashboards']"));
		
		waitForIt("//li[@class='slds-breadcrumb__item entityName']/*[text()='Dashboards']");

	
		//js.executeScript("arguments[0].value='Salesforce Automation by Mahesh'",driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']"));
		
		driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']").sendKeys(name);
		//js.executeScript("arguments[0].value='Saleforce Automation by Mahesh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		//driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		List<WebElement> dashBoardName = driver.findElementsByXPath("//table[@role='grid']//tr//th[@scope='row']//a");
		
		for (int i = 1; i <= dashBoardName.size(); i++) {
			driver.findElementByXPath("(//table[@role='grid']//tr/td/following::*[@class='slds-button__icon'])["+i+"]").click();
			driver.findElementByXPath("(//div[@class='slds-dropdown slds-dropdown_left']//*[text()='Subscribe'])["+i+"]").click();
			waitForIt("//h2[text()='Edit Subscription']");
			
			if(!driver.findElementByXPath("//div[@class='modal-footer slds-modal__footer']//*[text()='Unsubscribe']").isDisplayed()) {
				driver.findElementByXPath("//div[@class='analyticsScheduleSelectorBase analyticsSubscribeDialog']//*[text()='Daily']").click();
				driver.findElementByXPath("//div[@class='modal-footer slds-modal__footer']//*[text()='Save']").click();	
				iValue=i;
				Thread.sleep(5000);
				break;
			}
			else {
				driver.findElementByXPath("//div[@class='modal-footer slds-modal__footer']//*[text()='Cancel']").click();
				continue;
			}
			
		}
		
		
		driver.findElementByXPath("(//table[@role='grid']//tr/td/following::*[@class='slds-button__icon'])["+iValue+"]").click();
		driver.findElementByXPath("(//div[@class='slds-dropdown slds-dropdown_left']//*[text()='Subscribe'])["+iValue+"]").click();
		waitForIt("//h2[text()='Edit Subscription']");
		
		as.assertTrue(driver.findElementByXPath("//div[@class='modal-footer slds-modal__footer']//*[text()='Unsubscribe']").isDisplayed());
		
		
		

	}
}
