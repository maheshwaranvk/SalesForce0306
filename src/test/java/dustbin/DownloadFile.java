package dustbin;



import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {
	
	RemoteWebDriver driver;
	File folder;
	
	@Test
	public void downloadAFile() {
		folder =  new File("target");
		folder.mkdir();
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups",0);
		prefs.put("download.default_directory",folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(options);
		
		driver.get("http://www.leafground.com/pages/download.html");
		driver.findElementByXPath("//a[text()='Download Excel']").click();

	}

}
