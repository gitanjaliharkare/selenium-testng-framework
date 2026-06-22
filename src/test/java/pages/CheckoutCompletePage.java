package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage {

	By title = By.className("title");
	By header = By.cssSelector("h2.complete-header");
	By btnBackHome = By.id("back-to-products");
	WebDriver driver;
	WebDriverWait wait;

	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public boolean onCheckoutCompletePage() {
		WebElement txtTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		WebElement txtheader = wait.until(ExpectedConditions.visibilityOfElementLocated(header));
		return (txtTitle.getText().equals("Checkout: Complete!")
				&& txtheader.getText().equals("Thank you for your order!"));

	}

	public void goBackHome() {
		driver.findElement(btnBackHome).click();
	}

}
