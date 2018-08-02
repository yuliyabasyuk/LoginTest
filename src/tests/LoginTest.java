package tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSElement;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	

	@Test(dataProvider = "provideCredentials")
	public void Login(String username, String password) throws InterruptedException, NoSuchElementException {

		LoginPage loginPage = new LoginPage(ios, wait);

		loginPage.login(username, password);
		
		
		
		//Assert.assertEquals(mapElement.isDisplayed(), true);
		IOSElement mapElement = (IOSElement) ios.findElementByAccessibilityId("MAP");
		
		System.out.println(mapElement.isDisplayed());
		Assert.assertTrue(mapElement.isDisplayed());

	}

	@DataProvider(name = "provideCredentials")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelReader.getTableArray("/Users/ybasi/OPTIMA/LoginTestData.xlsx",
				"Sheet2");

		return (testObjArray);

	}

}
