package sal52_automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL57VerifyiAppStore extends ProjectSpecificMethods{

	@Test
	public void verifyiApp() {
		
		String url ="https://apps.apple.com/us/app/salesforcea/";
		
		
		driver.findElementById("tab_setupHomeCarousel_page3").click();
		driver.findElementByXPath("//span[text()='App Store']").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowHandlesList = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowHandlesList.get(1));
		
		driver.findElementByXPath("//button[text()='Confirm']").click();
		
		
		as.assertTrue(driver.getCurrentUrl().contains(url));
		as.assertAll();
		
	}
}
