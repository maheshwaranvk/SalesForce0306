package sal18_dashboard;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL19CreateDashboard extends ProjectSpecificMethods{

	@Test
	public void createDashB() throws InterruptedException {
		
		String name = "Salesforce Automation by Mahesh";
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Dashboards']"));
		
		waitForIt("//li[@class='slds-breadcrumb__item entityName']/*[text()='Dashboards']");

		javaScriptClick(driver.findElementByXPath("//div[text()='New Dashboard']"));
		
		waitForIt("//iframe[@title='dashboard']");
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@title='dashboard']"));
		
		driver.findElementById("dashboardNameInput").sendKeys(name);
		driver.findElementByXPath("//button[text()='Create']").click();
		
		/*
		 * driver.switchTo().parentFrame();
		 * driver.switchTo().frame(driver.findElementByXPath(
		 * "//iframe[@title='dashboard']"));
		 */
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@title='dashboard']"));
		driver.findElementByXPath("//button[text()='Done']").click();
	
		waitForIt("//h1//*[text()='Dashboard']");
		as.assertTrue(driver.findElementByXPath("//h1//*[text()='"+name+"']").isDisplayed());
		
	}
}
