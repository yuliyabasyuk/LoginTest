package tests;

import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSElement;
import pages.PreferencesPage;
import pages.ToolBar;

public class SignoutTest extends BaseTest {
	//IOSElement preferencesIcon = (IOSElement) ios.findElementByAccessibilityId("PREFERENCES");

	

	@Test

	public void goToPreferences() {

		ToolBar preferences = new ToolBar(ios);

		preferences.goToPreferencesPage();
	}

	public void Signout() {

		PreferencesPage logoutPage = new PreferencesPage(ios);

		logoutPage.signout();
	}

}
