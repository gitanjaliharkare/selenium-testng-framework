package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseClass {
	public WebDriver driver;
	public ConfigReader cr;
	public void setup(@Optional("")String browserName)
	{
		cr=new ConfigReader();
		if (browserName.isEmpty())
		{
		 browserName=cr.getConfigValue("browser");
		}
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();	
		}else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();	
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();	
		} 
		driver.get(cr.getConfigValue("url"));
		driver.manage().window().maximize();
		
	}
	public void teardown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	

}
