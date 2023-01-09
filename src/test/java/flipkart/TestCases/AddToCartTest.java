package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.AddToCartPage;
import flipkart.Pages.BasePage;

public class AddToCartTest extends BasePage{

//	@Test(priority = 0,groups = {"HomePage"})
	public void addingProductToTheCart() throws Exception{
		 
		SearchProductTest obj = new SearchProductTest();  	
		obj.changePincode();
		AddToCartPage obj2 = new AddToCartPage(driver);
		obj2.scrollDownToAddToCartButton();
		test.log(LogStatus.INFO, "Scrolled down to add to cart button");
		logger.info("Scrolled down to add to cart button");
		obj2.clickOnAddToCartBtn();
		test.log(LogStatus.INFO, "Clicked on add to cart button");
		logger.info("Clicked on add to cart button");
				
	}
	
	@Test(priority = 1,groups = {"HomePage"})
	public void removeFromCart() throws Exception {
		
		addingProductToTheCart();
		AddToCartPage obj2 = new AddToCartPage(driver);
		obj2.AssertCartPage();
		test.log(LogStatus.INFO, "Assertion passed"); 
		logger.info("Assertion passed");
		obj2.clickOnRemoveProduct();
		test.log(LogStatus.INFO, "Product removed from cart");
		logger.info("Product removed from cart");
	}
}
