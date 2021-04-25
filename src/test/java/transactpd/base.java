package transactpd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public RemoteWebDriver driver;
	public static String scrollInterval,pixelShift,pixelShift1,scrollInterval1,
	CancelscrollInterval,CancelpixelShift,CancelpixelShift1,CancelscrollInterval1,
	SavescrollInterval,SavepixelShift,SavepixelShift1,SavescrollInterval1;
	
	public static SoftAssert as = new SoftAssert();
	
	@BeforeMethod
	public void launchApplication() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://tsop-tradeshow.transactpd.net/Transact/DeviceSettings");
		driver.findElementById("UserName").sendKeys("ottomation");
		driver.findElementById("Password").sendKeys("ottom8tion!!");
		driver.findElementByXPath("//button[@class='login-button']").click();
	}

}
