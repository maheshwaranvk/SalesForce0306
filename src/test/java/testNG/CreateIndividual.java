package testNG;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import base.ProjectSpecificMethods3;

public class CreateIndividual extends BaseClass{
	

	@BeforeClass
	public void readExcelName() {
		excelFileName="CreateIndi";
	}
	

	@Test(dataProvider = "fetchData")
	public void createInd(String lName) throws InterruptedException {
		clickMenu();
		Thread.sleep(4000);
		javaScriptClick(driver.findElementByXPath("//p[text()='Individuals']"));
		

		driver.findElementByXPath("//div[@title='New']").click();
		driver.findElementByXPath("//span[@class='slds-truncate' and text()='Individuals']/following::*[@class='slds-icon slds-icon-text-default slds-icon_xx-small' and @data-key='chevrondown']").click();
		
		javaScriptClick(driver.findElementByXPath("//span[@one-appnavbarmenuitem_appnavbarmenuitem='' and text()='New Individual']"));
		
		
		driver.findElementByXPath("//input[@placeholder='Last Name']").sendKeys(lName);
		driver.findElementByXPath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']").click();
		
		String name = driver.findElementByXPath("//div[@class='slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp']/span").getText();		

		as.assertTrue(name.equalsIgnoreCase(lName));
		as.assertAll();
	}
}
