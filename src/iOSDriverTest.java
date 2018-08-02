import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class iOSDriverTest {
	private static DesiredCapabilities capabilities; 
	static IOSDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("automationName", "XCUITest");		
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3.1");
		capabilities.setCapability("deviceName", "iPad (5th generation)");
		capabilities.setCapability("udid", "9BA8CA85-4B46-471E-9DA3-7751245BD56D");
		//capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
		
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

}
