package sal52_automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL58SAL57VerifyGoogleAppStore extends ProjectSpecificMethods{

	@Test
	public void verifyGoogleApp() {
		driver.findElementById("tab_setupHomeCarousel_page3").click();
		driver.findElementByXPath("//span[text()='Google Play']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowHandlesList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		as.assertTrue(driver.findElementByXPath("//span[text()='SalesforceA']").isDisplayed());
		as.assertAll();		

	}
}
