package dustbin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassA {

	
@BeforeMethod
	public void beforeMethodClassA() {
		System.out.println("Before Method in Class A");

	}

@Test
public void atTestA1() {
	System.out.println("@Test1 in Class A");

}

@Test
public void atTestA2() {
	System.out.println("@Test2 in Class A");

}
@AfterMethod
public void afterMethodClassA() {
	System.out.println("After Method in Class A");

}	

	}
