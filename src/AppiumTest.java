import java.net.MalformedURLException;

import java.net.URL;

import javax.websocket.DeploymentException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
//import io.appium.java_client.remote.IOSMobileCapabilityType;

public class AppiumTest {
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
		
		//enter username
		IOSElement username = (IOSElement) ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]"
				+ "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeTextField");
		if(username.isEnabled()) {
			username.clear();
			username.sendKeys("dfrdemo3.4@wsi.com");
		} else {
			System.out.println("Username field isn't enabled.");
		}
		
		//enter password
		IOSElement password = (IOSElement) ios.findElementByXPath(".//XCUIElementTypeSecureTextField");
		if(password.isEnabled()) {
			password.clear();
			password.sendKeys("wsi");
		} else {
			System.out.println("Password field isn't enabled.");
		}
		
		//click SignIn btn
		IOSElement signIn = (IOSElement) ios.findElementByAccessibilityId("Sign In");
		//IOSElement signIn = (IOSElement) ios.findElementByXPath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]");
		if(signIn.isDisplayed()) {
			signIn.click();			
		} else {
			System.out.println("SignIn btn isn't displayed.");
		}
		
		 ios.findElementByXPath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
 				+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]").click(); 
		
		/*TouchActions action = new TouchActions(ios);
		action.doubleTap(ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]"));
		action.perform();*/
		
		
		
		}

}