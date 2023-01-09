package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.PlaceOrderPage;

public class PlaceOrderTest extends BasePage{

	@Test(groups = {"ProductPage"})
	public void placeOrder() throws Exception {
		
		AddToCartTest obj = new AddToCartTest();
		obj.addingProductToTheCart();
		PlaceOrderPage obj2 = new PlaceOrderPage(driver);
		obj2.clickOnPlaceOrder();
		test.log(LogStatus.INFO, "Clicked on place order button");
		logger.info("Clicked on place order button");
		obj2.AssertPlaceOrderPage();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		obj2.enterMobileNumber();
		test.log(LogStatus.INFO, "Mobile number entered");
		logger.info("Mobile number entered");
		obj2.clickOnContinueBtn();
		test.log(LogStatus.INFO, "Continue button clicked");
		logger.info("Continue button clicked");		
		
	}
}
