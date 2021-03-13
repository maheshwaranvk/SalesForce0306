package opportunities;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;

public class SAL5CreateOpput extends ProjectSpecificMethods{

	@Test
	public void createOpp() throws FileNotFoundException, ParseException {
		clickMenu();
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//p[text()='Opportunities']"));
		driver.findElementByXPath("//div[@title='New']").click();
		
		
		  Calendar c = Calendar.getInstance(); //13 Mar 2021 Time   
			c.add(Calendar.DATE, 1); // 14 Mar 2021 Time
			
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
			
			
		datePicker(df.format(c.getTime()));
		
		driver.findElementByXPath("//button[@title='Save']").click();
			
		as.assertTrue(driver.findElementByXPath("//li[text()='These required fields must be completed: Opportunity Name, Stage']").isDisplayed());
		as.assertAll();
	
	}
	}

