import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  org.openqa.selenium.NoSuchElementException;


public class iOS_Launch {
	public static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException, NoAlertPresentException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability( "bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.1");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "94AE137B-D0DE-4FA1-A848-D8C3BA22F627"); 
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//findElement by entire path
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"ENT\"]"
				+ "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeTextField")).sendKeys("dfrdemo3.4@wsi.com");
		
		
		
		//findElement by part of the path
		driver.findElement(By.xpath(".//XCUIElementTypeSecureTextField")).sendKeys("wsi");
		
		
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Sign In\"]")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 180);
        try{
        	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]/XCUIElementTypeOther/"
        			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
				+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]"))));
        	driver.findElement(By.xpath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]/XCUIElementTypeOther/"
        			+ "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/"
				+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]"));
        } catch (Exception e){
        		System.err.println("   no alert visible after "+ 180 +" sec.");
        }
        		
		//Thread.sleep(5000);
		
		/*WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		//driver.switchTo().alert().accept();*/
		
		
		
		/*WebDriverWait wait = new WebDriverWait(driver, 10);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        //return true;
	    } catch (Exception e) {
	        System.err.println("   no alert visible after "+ 10 +" sec.");
	       //return false;
	    }*/
		}

}