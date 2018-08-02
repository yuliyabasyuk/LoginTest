import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Before;
import org.junit.After;
import org.junit.Test; 
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class PBLoginJUnit {
	WebDriver driver;
	
@Before
public void setup() throws MalformedURLException, InterruptedException {
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("appWaitActivity", "*");
	capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
	capabilities.setCapability("platformName", "iOS");
	capabilities.setCapability("platformVersion", "10.3.1");
	capabilities.setCapability("deviceName", "iPad Air 10.3");
	capabilities.setCapability("udid", "E7CAEA35-5B8C-49D5-9DAA-1E76C16EF115");
	capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
	
	//Create RemoteWebDriver instance and connect to the Appium server
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
}


	@Test
	public void PBLogin() throws Exception{
		
	}
	
	@After
	public void teardrop() {
		driver.quit();
	}
	

}
