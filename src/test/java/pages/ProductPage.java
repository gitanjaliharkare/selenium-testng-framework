package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;
	By btnMenu = By.id("react-burger-menu-btn");
	By btnLogout =By.id("logout_sidebar_link");
	By titleProduct = By.cssSelector("span[data-test='title']");
	
	public ProductPage(WebDriver driver)
	{
		this.driver =driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	public boolean checkLoginSuccess()
	{
	 WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(titleProduct));
	 if(title !=null)
	 {
		 return true;
	 }else
	 {
		 return false;
	 }
	 
	}
	
	public void logout()
	{
		driver.findElement(btnMenu).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout)).click();
	}

}
