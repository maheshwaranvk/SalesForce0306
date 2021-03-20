package serviceResources;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL112CreateServiceResources extends ProjectSpecificMethods{

	@Test
	public void createResources() throws InterruptedException {
		clickMenu();
		
		javaScriptClick(driver.findElementByXPath("//p[text()='Service Resources']"));
		Thread.sleep(3000);
		
		javaScriptClick(driver.findElementByXPath("//div[@title='New']"));
		waitForIt("//h2[text()='New Service Resource']");
		
		String name ="Mahesh";
		driver.findElementByXPath("//input[@class=' input']").sendKeys(name);
		
		driver.findElementByXPath("//input[@role='combobox' and @title='Search People']").click();
		driver.findElementByXPath("//li[@role='presentation']//div[@class='primaryLabel slds-truncate slds-lookup__result-text']").click();
		
		driver.findElementByXPath("//span[text()='Resource Type']/following::a[@aria-disabled='false' and @class='select']").click();
		
		List<WebElement> resourceTypeWE = driver.findElementsByXPath("//a[@role='menuitemradio']");
		List<String> resourceTypeStr = new ArrayList<String>();
		
		for (WebElement webElement : resourceTypeWE) {
			resourceTypeStr.add(webElement.getAttribute("title"));
		}
		
		driver.findElementByXPath("//a[@role='menuitemradio' and @title='Technician']").click();
		driver.findElementByXPath("(//label[@class='slds-checkbox']/following::input[@type='checkbox'])[2]").click();
		driver.findElementByXPath("//div[@data-aura-class='forceDetailPanelDesktop']/following::span[text()='Save']").click();
		

	}

	
}
