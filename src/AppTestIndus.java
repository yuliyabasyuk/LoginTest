import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;


public class AppTestIndus {
	//public static IOSDriver iOSDriver;
	public static IOSDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium-version", "1.8");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("deviceName", "iPad Air");
		capabilities.setCapability("udid", "30718860-7011-4E01-BD6C-95A6763B2A9D");
		capabilities.setCapability("app", "/Users/ybasi/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator\n" + 
				"IntegrationApp.app");
		capabilities.setCapability("bundleId", "com.facebook.wda.integrationAppYB");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability("automationName", "XCUITest");
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElementByName("Alerts").click();
		Thread.sleep(5000);
			
		
		
	}

}
