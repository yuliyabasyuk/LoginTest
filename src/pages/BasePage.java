package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BasePage {
	public IOSDriver<?> ios;
	// public WebDriverWait wait;

	// Constructor
	public BasePage(IOSDriver<?> driver /* WebDriverWait wait */) {
		this.ios = driver;
		// this.wait = wait;
	}

	// Click Method
	public void click(IOSElement element) {
		if (element != null) {
			if (element.isEnabled()) {
				element.click();
			} else {
				System.out.println(element.getTagName() + "is disabled");
			}
		} else {
			System.out.println("Element is null");
		}
	}

	// Write Text
	public void writeText(IOSElement textField, String text) {
		if (textField != null) {
			if (textField.isEnabled()) {
				if (!textField.getAttribute("value").isEmpty()) {
					textField.clear();
				}
				textField.sendKeys(text);
			} else {
				System.out.println(textField.getTagName() + " is disabled");
			}
		} else {
			System.out.println("Element is null");
		}
	}

}
