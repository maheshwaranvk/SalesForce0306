package dustbin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassB {

	
	@BeforeMethod
	public void beforeMethodClassB() {
		System.out.println("Before Method in Class B");

	}
	
	@Test
	public void atTestB1() {
		System.out.println("@Test1 in Class B");

	}
	@AfterMethod
	public void afterMethodClassB() {
		System.out.println("After Method in Class B");
	}	
}
