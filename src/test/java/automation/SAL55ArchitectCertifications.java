package automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL55ArchitectCertifications extends ProjectSpecificMethods{
	
	
	@Test
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

}
