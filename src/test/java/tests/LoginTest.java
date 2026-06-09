package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseClass;
import listeners.ScreenshotListener;
import pages.*;
import utilities.*;
@Listeners(ScreenshotListener.class)
public class LoginTest extends BaseClass {
	BaseClass bc;
	LoginPage lp;
	ProductPage pp;

	@BeforeClass
	@Parameters("browser")
	public void launchBrowser(@Optional("") String browser) {
	
		setup(browser);
		
	}

	@DataProvider(name = "LoginData")
	public Object[][] getUserData() throws IOException {
		ExelUtility eu = new ExelUtility();
		ConfigReader cr = new ConfigReader();
		return eu.getExcelData(cr.getConfigValue("path"), cr.getConfigValue("sheetname"));

	}
	
	@Test(dataProvider = "LoginData")
	public void loginTests(String username, String password, String expectedResult) {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);
		lp.login(username, password);

		if (expectedResult.equalsIgnoreCase("success")) {
			Assert.assertTrue(pp.checkLoginSuccess());
			pp.logout();
		} else if (expectedResult.equalsIgnoreCase("Failure")) {
			Assert.assertTrue(lp.checkErrorMessage());
		//	Assert.assertTrue(false);

		}
	}
  
	@AfterClass
	public void quitBrowser() {
		teardown();
	}
}
