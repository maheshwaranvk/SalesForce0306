package testNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LearningAttributes extends BaseClass{

	
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
	
	@Test(groups = {"automation"})
	private void CustomerServiceOptions() {
		
	driver.findElementByXPath("//span[text()='Mobile Publisher']/following::span[text()='Learn More']").click();
	Set<String> wH = driver.getWindowHandles();
	List<String> wHL=new ArrayList<String>(wH);
	
	driver.switchTo().window(wHL.get(1));
	
	checkDisplay("Overview");
	checkDisplay("Solutions");
	checkDisplay("Infrastructure");
	checkDisplay("Features");
	checkDisplay("Einstein Automate");
	checkDisplay("Related Products");
	checkDisplay("Mobile Publishing");
	checkDisplay("Digital Experiences");
	checkDisplay("Environments");
	checkDisplay("Feedback Management");
	checkDisplay("Salesforce Scheduler");
	checkDisplay("Privacy Center");
	checkDisplay("App Gallery");
	checkDisplay("Resources");

	as.assertAll();
}
	
	@Test(groups = {"automation"})
	public void administratorCertifications() {
		driver.findElementByXPath("//span[text()='Mobile Publisher']/following::span[text()='Learn More']").click();
		Set<String> wH = driver.getWindowHandles();
		List<String> wHL=new ArrayList<String>(wH);
		
		driver.switchTo().window(wHL.get(1));
		
		Actions build = new Actions(driver);
		
		build.moveToElement(driver.findElementByXPath("//button//span[text()='Support']")).perform();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a/span[text()='See all services > ']"));
		
		driver.findElementByXPath("//a[@class='carousel_collapsed_laucher collapsed_launcher']/span[@class='more']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[text()='Salesforce Certification']"));
		
		as.assertTrue(driver.findElementByXPath("//div[@class='cs-card tile']//a[text()='Administrator']").isDisplayed());
		as.assertAll();	

	}
	
	@Test(groups = {"automation"})
	public void architectCertifications() {
		driver.findElementByXPath("//span[text()='Mobile Publisher']/following::span[text()='Learn More']").click();
		Set<String> wH = driver.getWindowHandles();
		List<String> wHL=new ArrayList<String>(wH);
		
		driver.switchTo().window(wHL.get(1));
		
		Actions build = new Actions(driver);
		
		build.moveToElement(driver.findElementByXPath("//button//span[text()='Support']")).perform();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a/span[text()='See all services > ']"));
		
		driver.findElementByXPath("//a[@class='carousel_collapsed_laucher collapsed_launcher']/span[@class='more']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[text()='Salesforce Certification']"));
		
		driver.findElementByXPath("//div[text()='Salesforce Architect']").click();
		as.assertTrue(driver.getTitle().equalsIgnoreCase("Certification - Architect Overview"));

		checkDisplay("Application Architect");
		checkDisplay("B2C Solution Architect");
		checkDisplay("B2C Commerce Architect");
		checkDisplay("Heroku Architecture Designer");
		checkDisplay("System Architect");
		checkDisplay("Technical Architect");
		
		
		as.assertAll();

	}
	
	@Test(groups = {"oppurtunity"})
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
	
	@Test(groups = {"oppurtunity"}, dependsOnMethods = "createOppurtunities")
	public void deleteOppurtunity() throws InterruptedException {
		clickMenu();
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
		
		js.executeScript("arguments[0].value='Saleforce Automation by Pugazh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']").click();
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].value='Saleforce Automation by Pugazh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		as.assertTrue(driver.findElementByXPath("//p[text()='No items to display.']").isDisplayed());
		as.assertAll();
	}
}
