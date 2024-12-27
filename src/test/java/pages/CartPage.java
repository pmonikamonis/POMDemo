package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(css = "div.cart_item")
	WebElement cartList;
	
	@FindAll(value = @FindBy(css = "div.cart_item"))
	List<WebElement> items;
	
	@FindBy(id = "remove-sauce-labs-backpack")
	WebElement rmvBtn;
	
	@FindBy(css = "button[data-test='continue-shopping']")
	WebElement contBtn;
	
	@FindBy(css = "button[data-test='checkout']")
	WebElement checkoutBtn;
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void checkOutItems()
	{
		checkoutBtn.click();
	}
	
	

}
