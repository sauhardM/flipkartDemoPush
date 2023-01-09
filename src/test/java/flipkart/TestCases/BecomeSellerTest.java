package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.BecomeSellerPage;

public class BecomeSellerTest extends BasePage{

	@Test(groups = {"HomePage"})
	public void becomeSeller() throws Exception{
		
		BecomeSellerPage obj = new BecomeSellerPage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.clickOnBecomeSellerBtn();
		test.log(LogStatus.INFO, "Click on become seller btn");
		logger.info("Click on become seller btn");
		
		obj.AssertSellerPageTitle();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
		
		obj.clickOnStartSelling();
		test.log(LogStatus.INFO, "Clicked on start selling button");
		logger.info("Clicked on start selling button");
		
		obj.AssertStartSellingPageTitle();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		
		obj.enterNumberAndEmail();
		test.log(LogStatus.INFO, "Mobile number and email entered");
		logger.info("Mobile number and email entered");
		
		obj.clickOnRegisterAndContinue();
		test.log(LogStatus.INFO, "Clicked on register and continue button");
		logger.info("Clicked on register and continue button");
		
	}
	
}
