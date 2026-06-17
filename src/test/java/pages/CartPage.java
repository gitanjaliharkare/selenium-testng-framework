package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	public WebDriver driver;
	By cart = By.cssSelector(".shopping_cart_link");
	By cpTitle = By.cssSelector(".title");
	By productNames =By.cssSelector("div.inventory_item_name");
	List<WebElement> productVisibleInCart;
	WebDriverWait wait;
	
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		
	}
    
	public boolean onCartPage()
	{   driver.findElement(cart).click();
		WebElement txtCpTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(cpTitle));
		return(txtCpTitle.getText().equals("Your Cart"));
	}
	
	public boolean presenceOfSelectedProducts(List<String> productsAddedtoCart)
	{
	
		//List<String> productsAddedtoCart=pp.getSelectedProductList();
		boolean flag =true;
		productVisibleInCart = driver.findElements(productNames);
		List<String> txtProductVisibleInCart =new ArrayList<String>() ;
		for (int i=0;i<productVisibleInCart.size();i++) {
			txtProductVisibleInCart.add(productVisibleInCart.get(i).getText());
			System.out.println(txtProductVisibleInCart.get(i));
		}
		
		
		if (productsAddedtoCart.isEmpty() && txtProductVisibleInCart.isEmpty())
		{
			System.out.println("Cart is empty");
			return true;
		}
		System.out.println(productsAddedtoCart.size());
		System.out.println(txtProductVisibleInCart.size());
		if(productsAddedtoCart.size()==txtProductVisibleInCart.size())
		{
			for (String product : productsAddedtoCart) {
			 if(txtProductVisibleInCart.contains(product))
			 {
				 System.out.println("Product "+product+" is visible in on cart page.");
			 }else
			 {
				 System.out.println("Product "+product+" is not visible in on cart page.");
				 flag=false;
			 }
			
			}
		}else
		{
			System.out.println("Product selected and present on cart page are mismatch in number.");
			flag= false;
		}
		return flag;
				
	}
    	
}
