package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ProductPage;

public class ExploratoryProductTest extends BaseClass{
	LoginPage lp;
	ProductPage pp;

	@BeforeClass
	@Parameters("browser")
	public void launchBrowser(@Optional String browserName) {
		// TODO Auto-generated method stub
		super.setup(browserName);
	}

	@Test(priority = 0)
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		lp = new LoginPage(driver);
		lp.login(username, password);
	}

	@Test(priority = 1)
	public void testAddSelectedToCart() {
		pp = new ProductPage(driver);
		System.out.println("Adding " + pp.getNumberOfProducts() + " products to cart");
		for (int i = 0; i < pp.getNumberOfProducts(); i++) {
			Map.Entry<String, String> element = pp.getProducts().get(i);
			pp.addProduct(element);
			Assert.assertEquals(i + 1, pp.getCartBadgeCount());

		}

	}

	@Test(priority = 2)
	public void testDeleteSelectedFromCart() {
		
		System.out.println("Removing " + pp.getNumberOfProducts() + " products from cart");
		for (int i = 0; i < pp.getNumberOfProducts(); i++) {
			Map.Entry<String, String> element = pp.getProducts().get(i);

			pp.removeProduct(element);
			Assert.assertEquals(pp.getNumberOfProducts() - (i + 1), pp.getCartBadgeCount());
		}

	}

	@AfterClass
	public void quitBrowser() {
		teardown();
	}


}
