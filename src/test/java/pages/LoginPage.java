package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	By txtUsername =By.id("user-name");
	By txtPassword = By.id("password");
	By btnLoginbutton = By.id("login-button");
	By txtErrorMessage= By.cssSelector("h3[data-test='error']");
	By btnErrorMessage = By.cssSelector("button[data-test='error-button']");
	
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void enterUsername(String username)
	{	WebElement txtBoxUsername =driver.findElement(txtUsername);
		txtBoxUsername.clear();
		txtBoxUsername.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		WebElement txtBoxPassword =driver.findElement(txtPassword);
		txtBoxPassword.clear();
		txtBoxPassword.sendKeys(password);
	}
	public void clickLoginbutton() {
		driver.findElement(btnLoginbutton).click();
	}
	
	public boolean checkErrorMessage()
	{
	 WebElement errorMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(txtErrorMessage));
	 if(errorMessage.isDisplayed())
	 {
		 driver.findElement(btnErrorMessage).click();
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	}
	
	public void login(String username,String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickLoginbutton();
	}
}
