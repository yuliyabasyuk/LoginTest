import java.net.MalformedURLException;
import java.net.URL;

import javax.websocket.DeploymentException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.ios.IOSElement;

public class AppiumIOSTestOLL {
	// public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException, DeploymentException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability("bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.1");
		capabilities.setCapability("deviceName", "iPad Air 2");
		capabilities.setCapability("udid", "94AE137B-D0DE-4FA1-A848-D8C3BA22F627");
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");

		IOSDriver<?> ios;
		URL remoteURL = new URL("http://127.0.0.1:4723/wd/hub");
		ios = new IOSDriver<>(remoteURL, capabilities);
		//
		// System.out.println(ios.getPageSource());
		//
		// enter login (full path)
		ios.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"ENT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
				.sendKeys("dfrdemo3.4@wsi.com");
		// enter passwd (full path)
		ios.findElementByXPath(
				"//XCUIElementTypeApplication[@name=\"ENT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
				.sendKeys("wsi");
		Thread.sleep(2000);
		// hide keyboard
		ios.hideKeyboard("Hide keyboard");
		if (ios.isKeyboardShown()) {
			System.out.println("Not closed keyabord!");
		} else
			System.out.println("keyboard closed fine");
		Thread.sleep(2000);

		// Signing in
		System.out.println("clicking Sign In..");
		ios.findElementByAccessibilityId("Sign In").click();

		// Wait max 20s and check if system alert exists.
		System.out.println("sleeping 25s and then checking if system popup exists..");
		// System.out.println("#### Session id is: " + ios.getSessionId());
		Thread.sleep(25000);

		IOSElement gpsAlert = (IOSElement) ios.findElementByAccessibilityId(
				"This application uses location data to display your location on the map and provide a list of nearby stations.");

		if (gpsAlert.isDisplayed()) {
			System.out.println("is displayed gpsAlert! ");
			ios.switchTo().alert().accept();
			if (gpsAlert.isDisplayed()) {
				System.out.println("still dispayed..");
				ios.switchTo().alert().accept();
			}
			System.out.println("Accepted the gpsAlert!");
		} else {
			System.out.println("system alert doesn't appear after 20s.");
		}

		// Process system alert about APNS usage
		Thread.sleep(10000);
		IOSElement apnsAlert = (IOSElement) ios.findElementByAccessibilityId(
				"Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.");
		if (apnsAlert.isDisplayed()) {
			System.out.println("is displayed apnsAlert! ");
			ios.switchTo().alert().accept();
			System.out.println("Accepted the apnsAlert!");
		}

		Thread.sleep(5000);
		ios.quit();

	}

}
