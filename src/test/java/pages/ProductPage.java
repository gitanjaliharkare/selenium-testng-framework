package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage {

	WebDriver driver;
	WebDriverWait wait;
	private int numberOfProducts;
	By btnMenu = By.id("react-burger-menu-btn");
	By btnLogout = By.id("logout_sidebar_link");
	By titleProduct = By.cssSelector("span[data-test='title']");

	private List<Map.Entry<String, String>> products = new ArrayList<>();
	protected List<String> productsInCart;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		products.add(Map.entry("Sauce Labs Backpack", "sauce-labs-backpack"));
		products.add(Map.entry("Sauce Labs Bike Light", "sauce-labs-bike-light"));
		products.add(Map.entry("Sauce Labs Bolt T-Shirt", "sauce-labs-bolt-t-shirt"));
		products.add(Map.entry("Sauce Labs Fleece Jacket", "sauce-labs-fleece-jacket"));
		products.add(Map.entry("Sauce Labs Onesie", "sauce-labs-onesie"));
		products.add(Map.entry("Test.allTheThings() T-Shirt (Red)", "test.allthethings()-t-shirt-(red)"));
		numberOfProducts = ThreadLocalRandom.current().nextInt(1, 7);
		productsInCart = new ArrayList<String>();
	}

	public List<Entry<String, String>> getProducts() {
		return products;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public boolean checkLoginSuccess() {
		WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleProduct));
		if (title != null) {
			return true;
		} else {
			return false;
		}

	}
	public List<String> getSelectedProductList()
	{
		return productsInCart;
	}

	public void addProduct(Entry<String, String> element) {
		String addElement = "add-to-cart-" + element.getValue();

		WebElement selectProduct = driver.findElement(By.id(addElement));
		selectProduct.click();
		
		productsInCart.add(element.getKey());
		System.out.println("Product " + element.getKey() + "added");

	}

	public void removeProduct(Entry<String, String> element) {
		String removeElement = "remove-" + element.getValue();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(removeElement)));
		driver.findElement(By.id(removeElement)).click();
		System.out.println("Product " + element.getKey() + "Removed");

	}

	public int getCartBadgeCount() {
		List<WebElement> l = driver.findElements(By.cssSelector(".shopping_cart_badge"));
		if (l.size() == 0) {
			return 0;
		} else {
			String text = driver.findElement(By.cssSelector(".shopping_cart_badge")).getText();
			return (Integer.parseInt(text));
		}

	}

	public void logout() {
		driver.findElement(btnMenu).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout)).click();
	}

}
