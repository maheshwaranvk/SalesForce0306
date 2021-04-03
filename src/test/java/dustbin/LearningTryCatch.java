package dustbin;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class LearningTryCatch extends ProjectSpecificMethods{

	@Test
	public void learnTryandCatch() throws InterruptedException {
		String name = "Surya";
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Dashboards']"));
		
		waitForIt("//li[@class='slds-breadcrumb__item entityName']/*[text()='Dashboards']");
		

		
		try {
			driver.findElementByXPath("//input[@class='search-text-field slds-input input uiInput uiInputText uiInput--default uiInput--input']").sendKeys(name);
			Thread.sleep(3000);
			driver.findElementByXPath("(//table[@role='grid']//tr/td/following::*[@class='slds-button__icon'])[1]").click();
		} catch (NoSuchElementException e) {
			System.out.println("Searched Element is not found");
		}
		
	}
}
