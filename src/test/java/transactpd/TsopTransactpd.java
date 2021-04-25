package transactpd;

import org.testng.annotations.Test;

public class TsopTransactpd extends base{

	@Test
	public void setValues() {
		scrollInterval = driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[1]").getAttribute("value");
		pixelShift = driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[1]").getAttribute("value");
		
		scrollInterval1= driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[2]").getAttribute("value");
		pixelShift1= driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[2]").getAttribute("value");
	}
	
	@Test
	public void getCancelValues() {
		driver.findElementByXPath("//button[text()='Cancel']").click();
		driver.findElementByXPath("//a[text()='Device Settings']").click();
		
		CancelscrollInterval = driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[1]").getAttribute("value");
		CancelpixelShift = driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[1]").getAttribute("value");
		
		CancelscrollInterval1= driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[2]").getAttribute("value");
		CancelpixelShift1= driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[2]").getAttribute("value");
	}
	
	@Test
	public void getSaveValues() {
		driver.findElementByXPath("//input[@value='Save']").click();
		driver.findElementByXPath("//a[text()='Device Settings']").click();
		
		CancelscrollInterval = driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[1]").getAttribute("value");
		CancelpixelShift = driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[1]").getAttribute("value");
		
		CancelscrollInterval1= driver.findElementByXPath("(//input[@data-val-number='The field Scroll Interval (in milliseconds) must be a number.'])[2]").getAttribute("value");
		CancelpixelShift1= driver.findElementByXPath("(//input[@data-val-number='The field Number of pixels to shift each interval must be a number.'])[2]").getAttribute("value");
		
		if ((scrollInterval.equalsIgnoreCase(CancelscrollInterval) && pixelShift.equalsIgnoreCase(CancelpixelShift)
				&& scrollInterval1.equalsIgnoreCase(CancelscrollInterval1) && pixelShift1.equalsIgnoreCase(CancelpixelShift1)
				&& scrollInterval.equalsIgnoreCase(SavescrollInterval) && pixelShift.equalsIgnoreCase(SavepixelShift)
				&& scrollInterval1.equalsIgnoreCase(SavescrollInterval1) && pixelShift1.equalsIgnoreCase(SavepixelShift1)))
				{
			System.out.println("The Values are equal");
		}
		
	}
	

}
