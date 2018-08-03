package tests;

import org.openqa.selenium.NoSuchElementException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSElement;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	/*@Test(dataProvider = "provideCredentials")
	public void Login(String username, String password) throws InterruptedException, NoSuchElementException {

		LoginPage loginPage = new LoginPage(ios);

		loginPage.login(username, password);

		IOSElement mapElement = (IOSElement) ios.findElementByAccessibilityId("MAP");
		if (mapElement.isDisplayed()) {
			System.out.println("Successful login. Map is displayed.");
		}

		Assert.assertTrue(mapElement.isDisplayed());

	}*/
	
	@Test
	public void Login() throws InterruptedException, NoSuchElementException {

		LoginPage loginPage = new LoginPage(ios);

		loginPage.login("dfrdemo2.2@wsi.com", "wsi");
	}
	

	/*@DataProvider(name = "provideCredentials")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelReader.getTableArray("/Users/ybasi/OPTIMA/LoginTestData.xlsx", "Sheet2");

		return (testObjArray);

	}*/

}
