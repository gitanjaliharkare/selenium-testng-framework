package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseClass;
import utilities.*;

public class ScreenshotListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass= result.getInstance();
		WebDriver driver =((BaseClass)testClass).driver;
		ScreenshotUtility su= new ScreenshotUtility(driver,result.getName());
		su.captureScreenshot();
		
	}

}
