package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class CheckoutCompleteTest extends BaseClass{
	LoginPage lp;
	ProductPage pp;
	CartPage cp;
	CheckoutPage cop;
	CheckoutOverviewPage coop;
	CheckoutCompletePage cocp;
	@BeforeTest
	@Parameters("browser")
	public void launchbrowser(@Optional String browserName)
	{
		super.setup(browserName);	
	}
	@Test(priority = 0)
	@Parameters({"username","password"})
	public void Login(String userName,String password) {
		lp=new LoginPage(driver);
		lp.login(userName, password);		
	}
	@Test(priority = 1)
	public void testAddProductsToCart() {
		pp = new ProductPage(driver);
		
		System.out.println("Adding all products to cart");
		for (int i = 0; i < pp.getProducts().size(); i++) {
			Map.Entry<String, String> element = pp.getProducts().get(i);
			pp.addProduct(element);
			Assert.assertEquals(i + 1, pp.getCartBadgeCount());

		}
	}
	@Test(priority = 3)
	public void gotoCartPage() {
		cp=new CartPage(driver);
	  Assert.assertTrue(cp.onCartPage());	 
		
	}
	@Test(priority = 4)
	public void gotoCheckoutPage() {
		
		cp=new CartPage(driver);
		cp.gotoCheckout();
		cop = new CheckoutPage(driver);
		Assert.assertTrue(cop.onCheckoutPage());
	}
	
	@Test(priority = 5)
	@Parameters({"firstname","lastname","pincode"})
	public void testContinueWithValidInfo(String firstName,String LastName,String postalCode)
	{
		
		cop.continueWithUserInfo(firstName, LastName, postalCode);
		coop= new CheckoutOverviewPage(driver);
		Assert.assertTrue(coop.onCheckoutOverviewPage());
		System.out.println("Successfully On Checkout Overview page");
		
		
	}
	@Test(priority = 6)
	public void testProductsOnCheckoutOverviewPage()
	{
		Assert.assertTrue(coop.presenceOfSelectedProductsOnOverview(pp.getSelectedProductList()));
	   	
	}
	@Test(priority = 7)
	public void testBillingTotal()
	{
		Assert.assertEquals(coop.calculatedBill(), coop.visibleBill(),0.01,"Visible bill does not matches calculated bill");
	}
	
	@Test(priority =8)
	public void testGotoCheckoutCompletePage()
	{
		coop.finishCheckout();
		cocp = new CheckoutCompletePage(driver);
		Assert.assertTrue(cocp.onCheckoutCompletePage());
		
	}
	
	@Test(priority = 9)
	public void testGotoHome()
	{
		cocp.goBackHome();
		pp.testOnHomePage();
		Assert.assertEquals(pp.getCartBadgeCount(),0);
		System.out.println("Successfully back to home");
		pp.logout();
	}
	
	
	
	@AfterTest
	public void quitBrowser() {
		teardown();
	}


}
