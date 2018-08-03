package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ToolBar extends BasePage{
	IOSElement preferencesIcon = (IOSElement) ios.findElementByAccessibilityId("PREFERENCES");
	
	public ToolBar(IOSDriver<?> ios) {
		super(ios);
	}
	
	
	
	public void goToPreferencesPage() {
		preferencesIcon.click();		
	}

}
