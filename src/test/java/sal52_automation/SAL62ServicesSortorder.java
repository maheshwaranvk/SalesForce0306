package sal52_automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;


public class SAL62ServicesSortorder extends ProjectSpecificMethods{

@Test
public void serviceSort() {
	while(!(driver.findElementByXPath("//span[text()='See System Status']").isDisplayed())){
		driver.findElementByXPath("//button[@class='slds-button slds-button--neutral rightArrowButton uiButton']").click();
	}

	driver.findElementByXPath("//span[text()='See System Status']/following::span[text()='Get Started']").click();
	getwindows(1);
	driver.findElementByXPath("//p[@class='site-label' and text()='Home']").click();
	driver.findElementByXPath("//p[@class='site-label' and text()='   Compliance']").click();
	
	driver.findElementByXPath("//a[text()='Services']").click();
	
	waitForIt("//h1[@class='slds-text-heading_large' and text()='Services']");
	List<WebElement> servicesWE = driver.findElementsByXPath("//h2[@class='f5 mb2 lh-title']");
	List<String> servicesStr =  new ArrayList<String>();
	
	for (WebElement we : servicesWE) {
		
		servicesStr.add(we.getText().toLowerCase());
	}
	
	Collections.sort(servicesStr);
	
	
	driver.findElementByXPath("//div[@class='slds-button-group']//button").click();
	
	
	List<WebElement> servicesWE2 = driver.findElementsByXPath("//h2[@class='f5 mb2 lh-title']");
	List<String> servicesStr2 =  new ArrayList<String>();
	
	for (WebElement we : servicesWE2) {
		
		servicesStr2.add(we.getText().toLowerCase());
	}
	
	as.assertTrue(servicesStr2.equals(servicesStr));
}
}
