package tests;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.*;
public class LoginDataTest {
	
	
	@DataProvider(name="LoginData")
	public Object[][] getUserData() throws IOException
	{
	 	ExelUtility eu=new ExelUtility();
	 	ConfigReader cr = new ConfigReader();
		return eu.getExcelData(cr.getConfigValue("path"),cr.getConfigValue("sheetname"));
		
	}
	
	@Test(dataProvider = "LoginData",enabled = false)
	public void displayData(String username,String password,String expectedResult)
	{
		System.out.printf("\n%-15s : %-15s", username,password);
	}
	
	@Test(dataProvider = "LoginData")
	public void LoginTest(String username,String password,String expectedResult)
	{
		
	}
}
