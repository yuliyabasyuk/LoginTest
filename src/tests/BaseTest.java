package tests;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;


public class BaseTest {
	public IOSDriver<?> ios;
	public WebDriverWait wait;
	public String appPath;
	public String bundleId;
	

	// InstallApp
	public void installApp(IOSDriver<?> driver, String appPath) {
		Map<String, Object> params = new HashMap<>();
		params.put("app", appPath);
		driver.executeScript("mobile: installApp", params);
	}

	/*
	 * // LaunchApp
	 * public void launchApp(IOSDriver<?> driver, String bundleId) {
	 * Map<String, Object> params = new HashMap<>(); params.put("bundleId",
	 * bundleId); if (driver.isAppInstalled(bundleId)) {
	 * driver.executeScript("mobile: launchApp", params); } }
	 */

	@BeforeClass
	public void Setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("appWaitActivity", "*");
		capabilities.setCapability("bundleId", "com.wsi.Pilotbrief.Debug.ENT");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.0.1");
		capabilities.setCapability("deviceName", "iPad Pro 9.7-inch");
		capabilities.setCapability("udid", "94EF5502-2E7F-4BDC-BCC1-C401A297A91C");
		capabilities.setCapability("app", "/Users/ybasi/Apps/Pilotbrief.ENT.app");

		// capabilities.setCapability("noResetValue","false");
		ios = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		ios.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(ios, 10);
		appPath = "/Users/ybasi/Apps/Pilotbrief.ENT.app";
		bundleId = "com.wsi.Pilotbrief.Debug.ENT";
		
		

		System.out.println("DEBUG SESSION ID: " + ios.getSessionId());


	}

}
