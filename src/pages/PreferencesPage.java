package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class PreferencesPage extends BasePage {
	public PreferencesPage(IOSDriver<?> ios) {
		super(ios);
	}
	
	IOSElement accountSubscriptionBtn = (IOSElement) ios.findElementByAccessibilityId("PreferencesAccountButton");
	IOSElement signOutBtn = (IOSElement) ios.findElementByAccessibilityId("Sign Out");
	
	public void signout() {
		click(accountSubscriptionBtn);
		click(signOutBtn);
	}



}
