import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.DeploymentException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class InstallLaunchApp {

	public static void main(String[] args)
			throws MalformedURLException, InterruptedException, DeploymentException, NoSuchElementException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability("bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.4");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "747AB755-6088-4206-96C9-AB17B31978EB");
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");

		IOSDriver<?> ios = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		String appPath = "/Users/ybasi/Apps/Pilotbrief.ENT.app";
		String bundleId = "com.wsi.Pilotbrief.Debug.ENT";
		
		boolean isInstalled = ios.isAppInstalled("com.wsi.Pilotbrief.Debug.ENT");
		System.out.println(isInstalled);

		
				
		
		System.out.println("DEBUG SESSION ID: " + ios.getSessionId());

		// enter username
		IOSElement username = (IOSElement) ios.findElementByXPath("//XCUIElementTypeApplication[@name=\"ENT\"]"
				+ "/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther"
				+ "/XCUIElementTypeOther/XCUIElementTypeTextField");
		if (username.isEnabled()) {
			username.clear();
			username.sendKeys("dfrdemo3.4@wsi.com");
		} else {
			System.out.println("Username field isn't enabled.");
		}

		// enter password
		IOSElement password = (IOSElement) ios.findElementByXPath(".//XCUIElementTypeSecureTextField");
		if (password.isEnabled()) {
			password.clear();
			password.sendKeys("wsi");
		} else {
			System.out.println("Password field isn't enabled.");
		}

		WebDriverWait wait = new WebDriverWait(ios, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Sign In")));

		ios.findElementByAccessibilityId("Sign In").click();

		try {

			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.name("Allow “ENT” to access your location while you are using the app?")));
			ios.findElementByAccessibilityId("Allow").click();
		} catch (Exception e) {
			System.out.println("Popup is not appeared");
		}

		ios.closeApp();

		//ios.terminateApp("com.wsi.Pilotbrief.Debug.ENT");

		ios.launchApp();
		System.out.println("DEBUG SESSION ID: " + ios.getSessionId());

		/*
		 * //TerminateApp Map<String, Object> paramsT = new HashMap<>();
		 * paramsT.put("bundleId", bundleId); ios.executeScript("mobile: terminateApp",
		 * paramsT);
		 * 
		 * 
		 * 
		 * // InstallApp
		 * 
		 * Map<String, Object> paramsI = new HashMap<>(); paramsI.put("app", appPath);
		 * ios.executeScript("mobile: installApp", paramsI);
		 * 
		 * 
		 * // LaunchApp
		 * 
		 * Map<String, Object> paramsL = new HashMap<>(); paramsL.put("bundleId",
		 * bundleId); if (ios.isAppInstalled(bundleId)) {
		 * ios.executeScript("mobile: launchApp", paramsL); }
		 */

	}
}
