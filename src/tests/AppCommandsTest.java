package tests;

import org.testng.annotations.Test;

public class AppCommandsTest extends BaseTest {

	@Test
	public void manipulationWithApp() throws InterruptedException {
		
		
		ios.closeApp();
		System.out.println("App is closed");

		ios.removeApp(appPath);
		System.out.println("App is removed");
		
		installApp(ios, appPath);
		System.out.println("App is installed");
		
		ios.launchApp();
		System.out.println("App is launched");

	}

}
