package sal18_dashboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL22SortDashborad extends ProjectSpecificMethods{

	
	@Test
	public void sortDashB() throws InterruptedException {
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Dashboards']"));
		
		waitForIt("//li[@class='slds-breadcrumb__item entityName']/*[text()='Dashboards']");
		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		//BEFORE SORTING
		List<WebElement> dashBoardNameWe = driver.findElementsByXPath("//table[@role='grid']//tr/following::th//a");
		List<String> dashBoardName = new ArrayList<String>();
		
		String countString = driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", "");
		int count = Integer.parseInt(countString);
		
		for (int i = 1; i <=count; i++) {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElementByXPath("(//table[@role='grid']//tr/following::th//a)["+(i)+"]"));
			dashBoardName.add(driver.findElementByXPath("(//table[@role='grid']//tr/following::th//a)["+(i)+"]").getText().toLowerCase());
			
			if(i==count) {
				String countString2 = driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", "");
				int count2 = Integer.parseInt(countString);
				if(count==count2) {
					break;
				}
				else {
					count = Integer.parseInt(driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", ""));
				}
			}
		}
		Collections.sort(dashBoardName);
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		
		//CLICK SORT	
		javaScriptClick(driver.findElementByXPath("//table[@role='grid']//tr//th//span//span[text()='Dashboard Name']/parent::a"));
		Thread.sleep(3000);
		
		
		//AFTER SORT
		List<WebElement> dashBoardNameSortWe = driver.findElementsByXPath("//table[@role='grid']//tr/following::th//a");
		List<String> dashBoardNameSort = new ArrayList<String>();
		
		String countString3 = driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", "");
		int count3 = Integer.parseInt(countString);
		
		
		
		for (int i = 1; i <=count3; i++) {
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElementByXPath("(//table[@role='grid']//tr/following::th//a)["+(i)+"]"));
			dashBoardNameSort.add(driver.findElementByXPath("(//table[@role='grid']//tr/following::th//a)["+(i)+"]").getText().toLowerCase());
			
			if(i==count3) {
				String countString2 = driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", "");
				int count2 = Integer.parseInt(countString2);
				if(count3==count2) {
					break;
				}
				else {
					count = Integer.parseInt(driver.findElementByXPath("//p[@class='slds-text-body--small result-count-label']//span[@class='countSortedByFilteredBy uiOutputText']").getText().replaceAll("\\D", ""));
				}
			}
		}
		
		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
		/*
		 * System.out.println("Before Sort"); for (String string : dashBoardName) {
		 * System.out.println(string); }
		 * 
		 * 
		 * System.out.println("After Sort"); for (String string : dashBoardNameSort) {
		 * System.out.println(string); }
		 */
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//COMPARE BOTH LISTs
		as.assertTrue(dashBoardNameSort.equals(dashBoardName));
		as.assertAll();
		 
		 
		
	}
}
