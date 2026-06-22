package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

	WebDriverWait wait;
	WebDriver driver;
	List<WebElement> productVisibleOnOverview;
	List<WebElement> productPrice;
	By productNames = By.cssSelector("div.inventory_item_name");
	By title = By.className("title");
	By price = By.className("inventory_item_price");
	By txtTax = By.className("summary_tax_label");
	By txtTotal = By.className("summary_total_label");
	By btnFinish = By.id("finish");

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public boolean onCheckoutOverviewPage() {
		WebElement txtTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
		return (txtTitle.getText().equals("Checkout: Overview"));
	}

	public boolean presenceOfSelectedProductsOnOverview(List<String> productsAddedtoCart) {
		boolean flag = true;
		productVisibleOnOverview = driver.findElements(productNames);
		List<String> txtProductVisibleInCart = new ArrayList<String>();
		for (int i = 0; i < productVisibleOnOverview.size(); i++) {
			txtProductVisibleInCart.add(productVisibleOnOverview.get(i).getText());
			System.out.println(txtProductVisibleInCart.get(i));
		}

		if (productsAddedtoCart.isEmpty() && txtProductVisibleInCart.isEmpty()) {
			System.out.println("Cart is empty");
			return true;
		}
		System.out.println(productsAddedtoCart.size());
		System.out.println(txtProductVisibleInCart.size());
		if (productsAddedtoCart.size() == txtProductVisibleInCart.size()) {
			for (String product : productsAddedtoCart) {
				if (txtProductVisibleInCart.contains(product)) {
					System.out.println("Product " + product + " is visible in on cart page.");
				} else {
					System.out.println("Product " + product + " is not visible in on cart page.");
					flag = false;
				}

			}
		} else {
			System.out.println("Product selected and present on cart page are mismatch in number.");
			flag = false;
		}
		return flag;

	}

	public float calculatedBill() {

		productPrice = driver.findElements(price);
		float sum = 0;

		for (WebElement pp : productPrice) {
			String sPrice = pp.getText();
			float realPrice = Float.parseFloat(sPrice.split("[$]")[1]);
			System.out.println(realPrice);
			sum += realPrice;
		}
		String sTax = driver.findElement(txtTax).getText();
		float realTax = Float.parseFloat(sTax.split("[$]")[1]);
		System.out.println("Tax = " + realTax);
		float totalBill = sum + realTax;
		System.out.println("Total Bill = " + totalBill);
		return (totalBill);
	}

	public float visibleBill() {
		String sTotalBill = driver.findElement(txtTotal).getText();
		float visibleTotal = Float.parseFloat(sTotalBill.split("[$]")[1]);
		System.out.println("Visible Total = " + visibleTotal);
		return (visibleTotal);

	}

	public void finishCheckout() {
		driver.findElement(btnFinish).click();
	}

}
