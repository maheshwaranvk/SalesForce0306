package dustbin;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestParameters {

	public String city = "Villupuram";
	@Parameters({"name","age"})
	@Test
	public void testit(String name , String age, String city) {
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(city);
	}
	
	
	
}
