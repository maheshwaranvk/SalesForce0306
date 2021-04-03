package sal79_campaign;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL81AttachDocument extends ProjectSpecificMethods{

	@Test
	public void attachDoc() throws InterruptedException, AWTException {
		clickMenu();
		driver.findElementByXPath("//p[text()='Sales']").click();
		
		waitForIt("//h2[@class='header-title-container title']/*[text()='Quarterly Performance']");
		
		
		javaScriptClick(driver.findElementByXPath("//div[@class='slds-context-bar']//*[text()='Opportunities']"));
		
		js.executeScript("arguments[0].value='Bootcamp'", driver.findElementByXPath("//input[@class='slds-input']"));
		driver.findElementByXPath("//input[@class='slds-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElementByXPath("(//table[@role='grid']//tr//th//a[contains(@title,'Bootcamp')])[1]").click();

		waitForIt("//h1//div[@class='entityNameTitle slds-line-height--reset' and text()='Opportunity']");
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//div[@class='slds-tabs_card'])[2]//span[@class='slds-file-selector__button slds-button slds-button_neutral']"));
		
		StringSelection ss = new StringSelection("C:\\Users\\Mahesh\\Desktop\\periyar.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robo = new Robot();
		
		robo.setAutoDelay(2000);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
		waitForIt("//div[@class='slds-grid slds-grid--vertical-align-center slds-p-around--small']//*[@data-key='success']");
		driver.findElementByXPath("//div[@class='footerCmps ']//*[text()='Done']").click();
	}
	
}
