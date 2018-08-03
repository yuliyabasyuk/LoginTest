package pages;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class LoginPage extends BasePage {
	// *********Constructor*********
	public LoginPage(IOSDriver<?> ios) {
		super(ios);
	}

	IOSElement usernameField = (IOSElement) ios.findElementByXPath(".//XCUIElementTypeTextField");
	IOSElement passwordField = (IOSElement) ios.findElementByXPath(".//XCUIElementTypeSecureTextField");
	IOSElement signInBtn = (IOSElement) ios.findElementByAccessibilityId("Sign In");
	IOSElement locationAlert = (IOSElement) ios.findElementByXPath(
			"//XCUIElementTypeStaticText[@name=\"Allow “ENT” to access your location while you are using the app?\"]");
	IOSElement notificationAlert = (IOSElement) ios
			.findElementByXPath("//XCUIElementTypeAlert[@name=\"“ENT” Would Like to Send You Notifications\"]");

	public void login(String username, String password) throws InterruptedException {
		// Enter Username
		writeText(usernameField, username);

		// Enter Password
		writeText(passwordField, password);

		// Click 'Sign In' btn
		click(signInBtn);

		// Handle alert
		// ------------Thread.sleep(10000);

		try {
			if (locationAlert.isDisplayed()) {
				ios.switchTo().alert().accept();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Location Popup not found");
		}

		try {
			if (notificationAlert.isDisplayed()) {
				ios.switchTo().alert().accept();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Notifications Popup not found");
		}

		try {
			if (locationAlert.isDisplayed()) {
				ios.switchTo().alert().accept();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Location Popup not found");
		}

	}
}