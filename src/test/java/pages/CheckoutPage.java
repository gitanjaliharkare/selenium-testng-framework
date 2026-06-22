package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	By pageTitle = By.className("title");
	By txtfirstName =By.id("first-name");
	By txtlastName =By.id("last-name");
	By txtpostalCode =By.id("postal-code");
	By btnContinue = By.id("continue");
	By btnCancel =By.id("cancel");
	WebDriverWait wait;
	
   public CheckoutPage(WebDriver driver ) {
   this.driver=driver;
    wait = new WebDriverWait(this.driver,Duration.ofSeconds(15));
	}
	
	public boolean  onCheckoutPage() {
		
		WebElement title= wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
		return(title.getText().equals("Checkout: Your Information"));
	}
	public void enterFirstName(String firstName)
	{
		driver.findElement(txtfirstName).sendKeys(firstName);
	}
	public void enterLastName(String lastName)
	{
		driver.findElement(txtlastName).sendKeys(lastName);
	}
	public void enterPostalCode(String postalCode)
    {
	   driver.findElement(txtpostalCode).sendKeys(postalCode);	
	}
	public void clickContinue(){
	 driver.findElement(btnContinue).click();	
	}
	public void clickCancel(){
		 driver.findElement(btnCancel).click();	
	}
	public void continueWithUserInfo(String firstName,String LastName,String postalCode)
	{
		enterFirstName(firstName);
		enterLastName(LastName);
		enterPostalCode(postalCode);
		clickContinue();
	}
	
	
	
	
	

}
