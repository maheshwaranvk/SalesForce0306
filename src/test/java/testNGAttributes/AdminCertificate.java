package testNGAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdminCertificate extends BaseClass{
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
	
}
