import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class NewTest {
	private IOSDriver<?> ios;
	private WebDriverWait wait;
	
@BeforeClass
	public void Setup() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.1");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "94AE137B-D0DE-4FA1-A848-D8C3BA22F627"); 
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
		ios = new IOSDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		wait = new WebDriverWait(ios, 5);
	}
  @Test
  public void Login() {
	  
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
		
		//WebDriverWait wait = new WebDriverWait(ios, 5);
	    wait.until(ExpectedConditions.elementToBeClickable(By.name("Sign In")));
		
		ios.findElementByAccessibilityId("Sign In").click();
	  
  }
  
  @Test
  public void getRoute() {
	  //WebDriverWait wait1 = new WebDriverWait(ios, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search.departure")));
	    
	    ios.findElementByAccessibilityId("search.departure").sendKeys("KBOS");
	    ios.findElementByAccessibilityId("search.destination").sendKeys("KMIA");		    
		 
	    
	    //WebDriverWait wait4 = new WebDriverWait(ios, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Continue")));
	    
	    ios.findElementByAccessibilityId("Continue").click();
	    
	    //WebDriverWait wait5 = new WebDriverWait(ios, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search.get.routes")));
	    
	    ios.findElementByAccessibilityId("search.get.routes").click();
	    
	    
	    //WebDriverWait wait6 = new WebDriverWait(ios, 5);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("SELECT A ROUTE")));
	    
	    ios.findElementByAccessibilityId("SelectedRouteTable.0.0").click();
	  
  }
}
