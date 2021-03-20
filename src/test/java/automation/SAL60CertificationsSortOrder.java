package automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL60CertificationsSortOrder extends ProjectSpecificMethods{

	@Test
	public void CertificationsSortOrder() {
		
		while(!(driver.findElementByXPath("//span[text()='See System Status']").isDisplayed())){
			driver.findElementByXPath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']").click();
		}

		driver.findElementByXPath("//span[text()='See System Status']/following::span[text()='Get Started']").click();
		getwindows(1);
		driver.findElementByXPath("//p[@class='site-label' and text()='Home']").click();
		driver.findElementByXPath("//p[@class='site-label' and text()='   Compliance']").click();
		
		
		driver.findElementByXPath("(//div[@class='slds-button-group']//button[@class='slds-button slds-button_neutral'])[2]").click();
		List<WebElement> servicesWE = driver.findElementsByXPath("//h2[@class='f5 mb2 lh-title']");
		List<String> services = new ArrayList<String>();
		
		for (WebElement we : servicesWE) {
			services.add(we.getText().toLowerCase());
		}
		Collections.sort(services);
		
		if(driver.findElementByXPath("//div[@class='slds-button-group']//button[@class='slds-button slds-button_neutral']").getText().equalsIgnoreCase(" Sort by popularity ")==false)
		{
		driver.findElementByXPath("(//div[@class='slds-button-group']//button[@class='slds-button slds-button_neutral'])[2]").click();
		}
		
		List<WebElement> servicesWE2 = driver.findElementsByXPath("//h2[@class='f5 mb2 lh-title']");
		List<String> services2 = new ArrayList<String>();
		
		for (WebElement we : servicesWE2) {
			services2.add(we.getText().toLowerCase());
		}
		
		for (String string : services2) {
			System.out.println(string);
		
		}
		System.out.println("-------------------------------------------------------");
		
		for (String string : services) {
			System.out.println(string);
		}
		
		
		  as.assertTrue(services2.equals(services)); as.assertAll();
		 
		
	}
	
}
