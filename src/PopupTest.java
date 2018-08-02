import java.net.MalformedURLException;


import java.net.URL;
import java.time.Duration;

import javax.websocket.DeploymentException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.WebDriverWait;


import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.IOSMobileCapabilityType;

public class PopupTest {
	//public static WebDriver driver; 
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException, DeploymentException, NoSuchElementException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.1");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "94AE137B-D0DE-4FA1-A848-D8C3BA22F627"); 
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
		//capabilities.setCapability("autoAcceptAlerts", true);
		//capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
		
		
		
		IOSDriver<?> ios;
		ios = new IOSDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//findElement by entire path
		
		ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]"
						+ "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"
						+ "/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("dfrdemo3.4@wsi.com");
				//findElement by part of the path
		ios.findElementByXPath(".//XCUIElementTypeSecureTextField").sendKeys("wsi");
		ios.findElementByAccessibilityId("Sign In").click();
		Thread.sleep(5000);
		ios.findElementByXPath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
				+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]").click();	

		
		
		
		}

}