package opportunities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import utils.RetryAnalyz;

public class SAL6SortOppurtunities extends ProjectSpecificMethods{

	
	public int count;
	
	@Test
	public void sortOpputunities() throws ParseException, InterruptedException {
	clickMenu();
	js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));

	as.assertTrue(driver.findElementByXPath("//button[@title='Display as Table']").isEnabled());
	
	count = Integer.parseInt(driver.findElementByXPath("//div[@aria-live='polite']/span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D", ""));
	
	
	List<String> closeDateString = new ArrayList<String>();
	List<Date> closeDate = new ArrayList<Date>();
	
	for (int i = 1; i <= count; i++) {
		closeDateString.add(driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td/following::span[@class='uiOutputDate'])["+i+"]").getText());
		js.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td/following::span[@class='uiOutputDate'])["+i+"]"));	
		if(i==count)
		{
			count = Integer.parseInt(driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText().replaceAll("\\D", ""));
		}
	}
	
	for (String  a : closeDateString) {
		closeDate.add(new SimpleDateFormat("MM/dd/yyyy").parse(a));
	}
	
	Collections.sort(closeDate);
	
	
	js.executeScript("arguments[0].click()", driver.findElementByXPath("//th[@title='Close Date']//a"));
	Thread.sleep(3000);
	js.executeScript("arguments[0].click()", driver.findElementByXPath("//th[@title='Close Date']//a"));
	Thread.sleep(3000);
	
	
	List<WebElement> sortedDateWE = driver.findElementsByXPath("//table[@data-aura-class='uiVirtualDataTable']//td//span[@class='uiOutputDate']");
	List<String>sortDateString= new ArrayList<String>();
	
	for (int i = 1; i <=count; i++) {
		sortDateString.add(driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td//span[@class='uiOutputDate'])["+i+"]").getText());
		js.executeScript("arguments[0].scrollIntoView();", driver.findElementByXPath("(//table[@data-aura-class='uiVirtualDataTable']//td/following::span[@class='uiOutputDate'])["+i+"]"));
	}
	List<Date>sortedDate = new ArrayList<Date>();
	
	for (String e : sortDateString) {
		sortedDate.add(new SimpleDateFormat("MM/dd/yyyy").parse(e));
	}
	
	as.assertTrue(closeDate.equals(sortedDate));
	as.assertAll();
	}
}
