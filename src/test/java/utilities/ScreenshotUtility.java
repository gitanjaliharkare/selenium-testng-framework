package utilities;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ScreenshotUtility {
	TakesScreenshot ts;
	WebDriverWait wait;
	WebDriver driver;
	String fileName;
	public ScreenshotUtility(WebDriver driver,String fname)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		fileName=fname;
	}
	public String takeTimeStamp()
	{
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String timestamp= now.format(formater);
		return timestamp;
	}
	public void captureScreenshot()
	{
		ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots/"+fileName+"_"+takeTimeStamp()+".png");
		try {
			Files.copy(src.toPath(), dest.toPath());
			System.out.println("captured screenshot successfully with name : "+dest.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
