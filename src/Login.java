import java.net.MalformedURLException;

import java.net.URL;

import javax.websocket.DeploymentException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSElement;

public class Login {
	//public static WebDriver driver; 
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException, DeploymentException, NoSuchElementException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.4");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "747AB755-6088-4206-96C9-AB17B31978EB"); 
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
				
				WebDriverWait wait = new WebDriverWait(ios, 5);
			    wait.until(ExpectedConditions.elementToBeClickable(By.name("Sign In")));
				
				ios.findElementByAccessibilityId("Sign In").click();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Allow “ENT” to access your location while you are using the app?")));
				ios.findElementByAccessibilityId("Allow").click();
				
				//IOSElement dep = (IOSElement) ios.findElementByAccessibilityId("search.departure");
				/*int maxWait = 7000;
				for(int i = 0; i < maxWait/1000; i++) {
					IOSElement dep = (IOSElement) ios.findElementByAccessibilityId("search.departure");
					if(dep.isEnabled()) {
						dep.sendKeys("KBOS");
					} else {
						Thread.sleep(1000);
						System.out.println(i);						
					}
				}*/
				
				
				
				WebDriverWait wait1 = new WebDriverWait(ios, 5);
			    wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("search.departure")));
			    
			    ios.findElementByAccessibilityId("search.departure").sendKeys("KBOS");
			    
			    //WebDriverWait wait2 = new WebDriverWait(ios, 5);
			    //wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("Continue")));
			    
			    //ios.findElementByAccessibilityId("Continue").click();
			    
			    /*WebDriverWait wait2 = new WebDriverWait(ios, 5);
			    wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("search.departure.edit")));
			    
			    ios.findElementByAccessibilityId("search.departure.edit").click();*/
			    
			    //WebDriverWait wait3 = new WebDriverWait(ios, 5);
			    //wait3.until(ExpectedConditions.presenceOfElementLocated(By.name("search.destination")));
			    
			    ios.findElementByAccessibilityId("search.destination").sendKeys("KMIA");		    
			 
			    
			    WebDriverWait wait4 = new WebDriverWait(ios, 5);
			    wait4.until(ExpectedConditions.presenceOfElementLocated(By.name("Continue")));
			    
			    ios.findElementByAccessibilityId("Continue").click();
			    
			    WebDriverWait wait5 = new WebDriverWait(ios, 5);
			    wait5.until(ExpectedConditions.presenceOfElementLocated(By.name("search.get.routes")));
			    
			    ios.findElementByAccessibilityId("search.get.routes").click();
			    
			    
			    WebDriverWait wait6 = new WebDriverWait(ios, 5);
			    wait6.until(ExpectedConditions.presenceOfElementLocated(By.name("SELECT A ROUTE")));
			    
			    ios.findElementByAccessibilityId("SelectedRouteTable.0.0").click();
			    
			    Thread.sleep(3000);
			    //check whether 'Add Alt' btn is present
			    IOSElement addAltBtn = (IOSElement) ios.findElementByXPath("//XCUIElementTypeButton[@name=\"ADD ALT\"]");
			    
			    if(addAltBtn.isEnabled()) {
			    		System.out.println(" 'ADD ALT' btn is enabled");
			    } else {
			    		System.out.println(" 'ADD ALT' btn is not enabled");
			    }
			    
			    ios.closeApp();
			   
			    
			    
			    
			    
		
		/*Thread.sleep(5000);	
		
	
		ios.findElementByXPath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
				+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]").click();
		
		TouchActions action = new TouchActions(ios);
		action.doubleTap(ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/"
				+ "XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]"));
		action.perform();*/
		
		
		
		
		
		
		
		
		

		
		
		
		}

}