package assessment;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import utils.RetryAnalyz;

public class Assessment0314 extends ProjectSpecificMethods{

	@Test
	public void assessmentMe0314() throws InterruptedException {
	clickMenu();
	
	
	javaScriptClick(driver.findElementByXPath("//p[text()='Service Console']"));
	
	Thread.sleep(5000);
	//javaScriptClick(driver.findElementByXPath("//div[@class='slds-context-bar__icon-action']"));
	driver.findElementByXPath("//button[@title='Show Navigation Menu']//*[@data-key='chevrondown']").click();
	javaScriptClick(driver.findElementByXPath("//span[@class='slds-media__body']//span[text()='Home']"));

	waitForIt("//span[text()='Closed']/following-sibling::span[@class='metricAmount uiOutputText']");

	int closedValue = Integer.parseInt(driver.findElementByXPath("//span[text()='Closed']/following-sibling::span[@class='metricAmount uiOutputText']").getText().replaceAll("\\D", ""));
	int openValue = Integer.parseInt(driver.findElementByXPath("//span[contains(text(),'Open')]/following-sibling::span[@class='metricAmount uiOutputText']").getText().replaceAll("\\D", ""));
	int goalValue=closedValue+openValue;
	
	if((closedValue+openValue)>10000) {
		goalValue=10000;
	}
	
	
	driver.findElementByXPath("//button[@title='Edit Goal']//*[@data-key='edit']").click();
	driver.findElementByXPath("//input[@aria-describedby='currencyCode']").clear();
	driver.findElementByXPath("//input[@aria-describedby='currencyCode']").sendKeys(String.valueOf(goalValue));
	driver.findElementByXPath("//div[@class='homeGoalEditor']//span[text()='Save' and @class=' label bBody']").click();
	
	javaScriptClick(driver.findElementByXPath("//button[@title='Show Navigation Menu']"));
	javaScriptClick(driver.findElementByXPath("//span[@class='slds-media__body']//span[text()='Dashboards']"));
	javaScriptClick(driver.findElementByXPath("//div[@title='New Dashboard']"));
	driver.switchTo().frame(driver.findElementByXPath("//iframe[@title='dashboard']"));
	waitForIt("//div[@class='slds-modal__container createModal']//h2[text()='New Dashboard']");
	
	
	
	String dashboardName ="Test1_Workout";
		
	driver.findElementByXPath("//input[@id='dashboardNameInput']").sendKeys(dashboardName);
	driver.findElementById("dashboardDescriptionInput").sendKeys("Testing");
	driver.findElementById("submitBtn").click();
	Thread.sleep(2000);
	driver.switchTo().parentFrame();
	driver.switchTo().frame(driver.findElementByXPath("//div[@class='dashboardContainer']//iframe"));
	driver.findElementByXPath("//button[@class='slds-button doneEditing']").click();
	
	as.assertTrue(driver.findElementByXPath("//span[@class='slds-page-header__title slds-truncate'and text()='"+dashboardName+"']").isDisplayed());
	driver.findElementByXPath("//button[text()='Subscribe']").click();
	
	driver.switchTo().parentFrame();
	Thread.sleep(4000);
	driver.findElementByXPath("//span[text()='Daily']").click();

	dropdown(driver.findElementById("time"), "visibletext", "10:00 AM");
	driver.findElementByXPath("//div[@class='modal-container slds-modal__container']//span[text()='Save']").click();
	
	waitForIt("//span[@data-aura-class='forceActionsText' and text()='You started a dashboard subscription.']");
	as.assertTrue(driver.findElementByXPath("//span[@data-aura-class='forceActionsText' and text()='You started Dashboard Subscription.']").isDisplayed());
	
	driver.findElementByXPath("//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container' and @title='Close "+dashboardName+"']");
	
	
	as.assertAll();
	
	}
}
