package opportunities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class clickDates extends ProjectSpecificMethods{
	
	@Test
	public void daYPicker(String date) {
		
		Map<String,Integer> months = new HashMap<String,Integer>();
		months.put("JANUARY", 1);
		months.put("FEBRUARY", 2);
		months.put("MARCH", 3);
		months.put("APRIL", 4);
		months.put("MAY", 5);
		months.put("JUNE", 6);
		months.put("JULY", 7);
		months.put("AUGUST", 8);
		months.put("SEPTEMBER", 9);
		months.put("OCTOBER", 10);
		months.put("NOVEMBER", 11);
		months.put("DECEMBER", 12);
		
		Set<Entry<String, Integer>> entrySet = months.entrySet();
		
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		driver.findElementByXPath("//div[@title='New']").click();
		
		driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
		driver.findElementByXPath("//button[text()='Today']").click();
		String attribute = driver.findElementByXPath("//a[@class='datePicker-openIcon display']/preceding-sibling::input").getAttribute("value");
		String[] today = attribute.split("/");
		String[] givenDate = date.split("/");
		int month = Integer.parseInt(today[0]);
		int givenDateMonth = Integer.parseInt(givenDate[0]);
		
		//SetMonth
		if(givenDateMonth> month)
			
		{
			driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
			while(givenDateMonth> month) {
			driver.findElementByXPath("//a[@title='Go to next month']").click();
			String text = driver.findElementByXPath("//h2[@class='monthYear']").getText();
			month=months.get(text);
			}
		}
		else if(givenDateMonth< month)
			
		{
			driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
			while(givenDateMonth< month) {
			driver.findElementByXPath("//a[@title='Go to previous month']").click();
			String text = driver.findElementByXPath("//h2[@class='monthYear']").getText();
			month=months.get(text);
			}
		}
		
		//Set Date
		
		
		
		Select year = new Select(driver.findElementByXPath("//select[@class='slds-select picklist__label']"));
		year.selectByVisibleText(givenDate[2]);
		driver.findElementByXPath("//table[@class='calGrid']//tr//span[text()='"+Integer.parseInt(givenDate[1])+"']").click();
		
		
	}

}
