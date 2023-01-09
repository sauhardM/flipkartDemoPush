package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.SignUpPage;

public class SignUpTest extends BasePage {

	
	@Test(groups = {"HomePage"})
	public void signUpTestCase() throws Exception{
		
		SignUpPage obj = new SignUpPage(driver);
		obj.closePopup();
		test.log(LogStatus.INFO, "Closed popup"); 
		logger.info("Closed popup");
		obj.moveToElementLogin();
		test.log(LogStatus.INFO, "cursor moved to login button");
		logger.info("cursor moved to login button");
		obj.moveToSignUpButton();
		test.log(LogStatus.INFO, "cursor moved to signUp button");
		logger.info("cursor moved to signUp button");
		obj.assertBannerMessage();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		obj.enterMobileNumber();
		test.log(LogStatus.INFO, "Mobile number entered");
		logger.info("Mobile number entered");
		obj.clickOnContinueButton();
		test.log(LogStatus.INFO, "Continue button clicked");
		logger.info("Continue button clicked");
	}
	
}
