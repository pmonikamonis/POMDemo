package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy(id = "first-name")
	WebElement fname;
	
	@FindBy(id = "last-name")
	WebElement lname;
	
	@FindBy(id = "postal-code")
	WebElement zipcode;
	
	@FindBy(id = "continue")
	WebElement ctnBtn;
	
	@FindBy(id = "finish")
	WebElement finishBtn;
	
	@FindBy(css = "h2.complete-header")
	WebElement successMsg;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void ProvideDetails(String strfName, String strlName, String pCode)
	{
		fname.sendKeys(strfName);
		lname.sendKeys(strlName);	
		zipcode.sendKeys(pCode);
		ctnBtn.click();
		
	}
	
	public void checkoutOrder()
	{
		finishBtn.click();
	}
	
	public boolean isOrderSuccess()
	{
	return successMsg.isDisplayed();	
	}
}
