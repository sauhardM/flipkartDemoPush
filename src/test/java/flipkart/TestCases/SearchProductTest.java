package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.SearchProductPage;

public class SearchProductTest extends BasePage {

	@Test(priority = 0,groups = {"ProductPage"})
	public void searchProduct() throws Exception{
		
		SearchProductPage obj = new SearchProductPage(driver);
		obj.closePopup();
		test.log(LogStatus.INFO, "Closed popup");
		logger.info("Closed popup");
		obj.enterProductOnSearchBar();
		test.log(LogStatus.INFO, "Product entered on search bar");
		logger.info("Product entered on search bar");
		obj.assertPageTitle();
		test.log(LogStatus.INFO, "Assertion Passed");
		logger.info("Assertion Passed");
	}
	
	@Test(priority = 1,groups = {"ProductPage"})
	public void openProduct() throws Exception {
		
		searchProduct();
		SearchProductPage obj = new SearchProductPage(driver);
		obj.openProduct();
		test.log(LogStatus.INFO, "Product opened in new page");
		logger.info("Product opened in new page");
		obj.assertProductPageTitle();
		test.log(LogStatus.INFO, "Assertion Passed");
		logger.info("Assertion Passed");
	}
	
	@Test(priority = 3,groups = {"ProductPage"})
	public void changePincode() throws Exception {
		
		openProduct();
		SearchProductPage obj = new SearchProductPage(driver);
		obj.changeDeliveryCode();
		test.log(LogStatus.INFO, "Pincode changed");
		logger.info("Pincode changed");
	}
}
