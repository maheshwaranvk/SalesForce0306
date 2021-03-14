package automation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL56BoardExamSchedule extends ProjectSpecificMethods{

	@Test
	public void boardExamSchedule() throws InterruptedException {
		
		List<String> nextMonthDates = new ArrayList<String>();
		nextMonthDates.add("Apr 12 - Apr 16");
		nextMonthDates.add("Apr 26 - Apr 30");
		
		List<String> nextMonthLocation = new ArrayList<String>();
		nextMonthLocation.add("Virtual - CET");
		nextMonthLocation.add("Virtual - PST");
		
		
		driver.findElementByXPath("//span[text()='Mobile Publisher']/following::span[text()='Learn More']").click();
		Set<String> wH = driver.getWindowHandles();
		List<String> wHL=new ArrayList<String>(wH);
		
		driver.switchTo().window(wHL.get(1));
		
		Actions build = new Actions(driver);
		
		build.moveToElement(driver.findElementByXPath("//button//span[text()='Support']")).perform();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a/span[text()='See all services > ']"));
		
		driver.findElementByXPath("//a[@class='carousel_collapsed_laucher collapsed_launcher']/span[@class='more']").click();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[text()='Salesforce Certification']"));
		
		driver.findElementByXPath("//div[text()='Salesforce Architect']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Technical Architect']/preceding::a[text()='More Details']").click();
		Set<String> swH = driver.getWindowHandles();
		List<String> swHL=new ArrayList<String>(swH);
		
		driver.switchTo().window(swHL.get(2));
		
		List<WebElement> statusWE = driver.findElementsByXPath("//div[text()='Status']/following::div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--3-of-12']");
		List<String> dates = new ArrayList<String>();
		List<String> location = new ArrayList<String>();
		
		
		  for (int i = 0; i <statusWE.size(); i++) {
		  if(statusWE.get(i).getText().equalsIgnoreCase("Planning")) {
		  
		  dates.add(driver.
		  findElementByXPath("(//div[text()='Status']/following::div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--5-of-12'])["
		  +(i+1)+"]").getText()); location.add(driver.
		  findElementByXPath("(//div[text()='Status']/following::div[@class='slds-col--padded slds-size--1-of-1 slds-medium-size--4-of-12'])["
		  +(i+1)+"]").getText());
		  
		  } }
		  
		  Calendar c=	Calendar.getInstance();
			c.add(Calendar.MONTH, 1);
			String[] split = c.getTime().toString().split(" ");
			
			List<String> nextMonthDatesVerify = new ArrayList<String>();
			List<String> nextMonthLocationVerify = new ArrayList<String>();
		
			for (int i = 0; i <dates.size(); i++) {
				if(dates.get(i).contains(split[1])==true){
					nextMonthDatesVerify.add(dates.get(i));
					nextMonthLocationVerify.add(location.get(i));
			}
					
			}
			as.assertTrue(nextMonthDatesVerify.equals(nextMonthDates));
			as.assertTrue(nextMonthLocationVerify.equals(nextMonthLocation));
			as.assertAll();
}}

