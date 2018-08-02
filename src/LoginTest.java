import java.net.MalformedURLException;



import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class LoginTest {
	private IOSDriver<?> ios;
	private WebDriverWait wait;
	
@BeforeClass
	public void Setup() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.4");
		capabilities.setCapability("deviceName", "iPad Pro 10.5 inch");
		capabilities.setCapability("udid", "043A8BC4-8B39-4EF9-9D2C-15237647044B"); 
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
		ios = new IOSDriver<> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		
		wait = new WebDriverWait(ios, 10);
		
		
	}
  @Test
  public void Login() throws InterruptedException,  NoSuchElementException{
	  
		//enter username
		IOSElement username = (IOSElement) ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]"
				+ "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeTextField");
		if(username.isEnabled()) {
			
			if(username.getAttribute("value").isEmpty()) {
				System.out.println("Text field is empty");
			} else {
				System.out.println("Text field is NOT empty");
			}
			
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
	    //!!!!wait.until(ExpectedConditions.elementToBeClickable(By.name("Sign In")));
		
		ios.findElementByAccessibilityId("Sign In").click();
		
		Thread.sleep(10000);
		/*try{IOSElement locationAlert = (IOSElement) ios.findElementByXPath("//XCUIElementTypeAlert[@name=\"Allow “ENT” to access your location while you are using the app?\"]");
			if(locationAlert.isDisplayed()) {
			ios.findElementByXPath("//XCUIElementTypeButton[@name=\"Allow\"]").click();
			} 
		} catch(Exception e){
    			System.err.println("No alert visible");        	
		}*/
		
		IOSElement locationAlert = (IOSElement) ios.findElementByName("Allow “ENT” to access your location while you use the app?");
				//findElementByXPath("//XCUIElementTypeAlert[@name=\"Allow “ENT” to access your location while you are using the app?\"]");
		if(locationAlert.isDisplayed()) {
		ios.findElementByAccessibilityId("Allow").click();}
			
		}
		
		
		
		
		//ios.findElementByXPath("//XCUIElementTypeButton[@name=\"Allow\"]").click();
		
	  
  
  
  @Test
  public void getRoute() throws  NoSuchElementException {
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
