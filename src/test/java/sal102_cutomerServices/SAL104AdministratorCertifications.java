package sal102_cutomerServices;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL104AdministratorCertifications extends ProjectSpecificMethods {

	@Test
	public void AdministratorCertifications() {
		driver.findElementByXPath("//span[text()='Mobile Publisher']/following::*[text()='Learn More']").click();
		getwindows(1);
		System.out.println(driver.getTitle());
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//button[@class='nav-item-link child-menu']//span[text()='Resources']")).perform();
	
		javaScriptClick(driver.findElementByXPath("//a/span[text()='Salesforce Certification ']"));
		
		getwindows(2);
		
		as.assertTrue(driver.findElementByXPath("//div[text()='Certification']/following::a[text()='Administrator']").isDisplayed());
		
		driver.findElementByXPath("//div[text()='Certification']/following::a[text()='Administrator']").click();
		List<WebElement> classes = driver.findElementsByXPath("//ul[@class='bullets Fz(18px) Lh(1.5) Fw(l)']//a");
		
		List<String> classNames = new ArrayList<String>();
		
		for (WebElement we : classes) {
			classNames.add(we.getText());
		}
		
		String titleName = "Certification - Administrator";
		
		for (String string : classNames) {
			System.out.println(string);
		}
		
		as.assertTrue(titleName.equalsIgnoreCase(driver.getTitle()));
		as.assertAll();

	}
}
