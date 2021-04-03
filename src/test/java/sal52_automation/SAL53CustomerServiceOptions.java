package sal52_automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL53CustomerServiceOptions extends ProjectSpecificMethods{

	@Test
	private void CustomerServiceOptions() {
		
	driver.findElementByXPath("//span[text()='Mobile Publisher']/following::span[text()='Learn More']").click();
	Set<String> wH = driver.getWindowHandles();
	List<String> wHL=new ArrayList<String>(wH);
	
	driver.switchTo().window(wHL.get(1));
	
	checkDisplay("Overview");
	checkDisplay("Solutions");
	checkDisplay("Infrastructure");
	checkDisplay("Features");
	checkDisplay("Einstein Automate");
	checkDisplay("Related Products");
	checkDisplay("Mobile Publishing");
	checkDisplay("Digital Experiences");
	checkDisplay("Environments");
	checkDisplay("Feedback Management");
	checkDisplay("Salesforce Scheduler");
	checkDisplay("Privacy Center");
	checkDisplay("App Gallery");
	checkDisplay("Resources");

	as.assertAll();
}
}