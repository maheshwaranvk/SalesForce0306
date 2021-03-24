package testNGAttributes;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteOpp extends BaseClass {

	@Test(groups = {"oppurtunity"})
	public void deleteOppurtunity() throws InterruptedException {
		clickMenu();
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		
		
		js.executeScript("arguments[0].value='Saleforce Automation by Pugazh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click()", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//*[@data-key='down']/..)[1]"));
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//span[text()='Delete']").click();
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].value='Saleforce Automation by Pugazh'", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		
		as.assertTrue(driver.findElementByXPath("//p[text()='No items to display.']").isDisplayed());
		as.assertAll();
	}
}
