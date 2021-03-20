package automation;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import base.ProjectSpecificMethods2;

public class SAL59DwldPDF extends ProjectSpecificMethods2 {

	@Test
	public void downloadPDF() throws IOException {
		
		
		while(!(driver.findElementByXPath("//span[text()='View Release Notes']").isDisplayed())){
			driver.findElementByXPath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']").click();
		}
		
		driver.findElementByXPath("(//article[@class='onesetupHelpTile']//span[text()='View Release Notes']/following::span[text()='Get Started'])[1]").click();
		
		getwindows(1);
		driver.findElementById("select-input").click();
		driver.findElementByXPath("//span[contains(@title,'Summer') and contains(@title,'20')]").click();
		
		driver.findElementByXPath("//a[@class='link slds-button slds-button_neutral' and contains(text(),'PDF')]").click();
		
		getwindows(2);
		
		System.out.println(driver.getCurrentUrl());
		
		as.assertTrue(readPDF(driver.getCurrentUrl(),"Salesforce Spring ’21 Release"));

	}
}
