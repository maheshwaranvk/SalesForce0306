package sal79_campaign;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL80CreateCampaign extends ProjectSpecificMethods{

	@Test()
	public void createCampaign() {
		
		String campName="BootCamp by Karthik";
		clickMenu();
		javaScriptClick(driver.findElementByXPath("//p[@class='slds-truncate' and text()='Sales']"));
		
		waitForIt("//span[@title='Quarterly Performance']");
		//driver.findElementByXPath("//div[@class='slds-context-bar']//*[text()='Campaigns']").click();
		javaScriptClick(driver.findElementByXPath("//div[@class='slds-context-bar']//*[text()='Campaigns']"));
		
		
		waitForIt("//a[@class='forceActionLink']/*[text()='New']");
		driver.findElementByXPath("//a[@class='forceActionLink']/*[text()='New']").click();
		
		driver.findElementByXPath("//div[@data-aura-class='forceDetailPanelDesktop']//span[text()='Campaign Name']/following::input[@required='']").sendKeys(campName);
		
		
		 Calendar c = Calendar.getInstance(); 
			c.add(Calendar.DATE, 1); 
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			
		datePicker(df.format(c.getTime()), "//div[@class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']/preceding::a[@class='datePicker-openIcon display']");
		
		c.add(Calendar.DATE, 1);
		datePicker(df.format(c.getTime()), "//div[@class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']/following::a[@class='datePicker-openIcon display']");
		
		driver.findElementByXPath("//div[@class='actionsContainer']//button/span[text()='Save']").click();
	
		waitForIt("//div[@class='entityNameTitle slds-line-height_reset']");
		
		as.assertTrue(campName.equalsIgnoreCase(driver.findElementByXPath("//div[@class='entityNameTitle slds-line-height_reset']/following::div[@class='testonly-outputNameWithHierarchyIcon slds-grid sfaOutputNameWithHierarchyIcon']/span[@data-aura-class='uiOutputText']").getText()));
		
		as.assertAll();
	}
}
