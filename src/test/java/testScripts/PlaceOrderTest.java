package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class PlaceOrderTest {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductsListPage listPage;
	CartPage cartPage;
	CheckOutPage chkoutPage;
	
	public PlaceOrderTest()
	{
		TestBase.initDriver();
		driver= TestBase.getDriver();
		loginPage = new LoginPage(driver);
		listPage= new ProductsListPage(driver);
		cartPage = new CartPage(driver);
		chkoutPage = new CheckOutPage(driver);
	}

	
	@BeforeTest
	public void setup()
	{
		TestBase.OpenUrl("https://www.saucedemo.com/");
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		loginPage.validLogin("standard_user", "secret_sauce");
	}
	

	@Test(priority=2)
	public void additemTest()
	{
		boolean isOnProductsPage = listPage.isOnProducts();
		Assert.assertTrue(isOnProductsPage);
		listPage.addTocart();
		listPage.viewCart();
		
	}
	
	@Test(priority=3)
		public void checkoutitemTest()
	{
		cartPage.checkOutItems();
		
	}
	
	@Test(priority=4)
	public void checkoutPageTest()
{
	chkoutPage.ProvideDetails("aaa","bbb","1243");
	chkoutPage.checkoutOrder();
	boolean sucessPage= chkoutPage.isOrderSuccess();
	Assert.assertTrue(sucessPage);
}

}
