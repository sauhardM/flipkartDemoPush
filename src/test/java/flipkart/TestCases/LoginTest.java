package flipkart.TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import flipkart.Pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import flipkart.Pages.BasePage;
import flipkart.Pages.LoginPage;

public class LoginTest extends BasePage {
	
	
	@Test (priority=0,groups = {"HomePage"})
	public void validCredentialsLogin() throws InterruptedException{
		
		LoginPage obj = new LoginPage(driver);  
		obj.closePopup();
		test.log(LogStatus.INFO, "Closed popup");
		logger.info("Closed popup");
		obj.clickOnLoginButton();
		test.log(LogStatus.INFO, "Clicked on login button");
		logger.info("Clicked on login button");
		obj.sendKeysToEnterNumber();
		test.log(LogStatus.INFO, "Entered mobile number");
		logger.info("Entered mobile number");
		obj.clickOnRequestOtp();
		test.log(LogStatus.INFO, "Clicked on request OTP");
		logger.info("Clicked on request OTP");
	}
	
	@Test (priority = 1,groups = {"HomePage"})
	public void  inValidCredentialsLogin() throws InterruptedException {
		
		LoginPage obj = new LoginPage(driver);
		obj.closePopup();
		test.log(LogStatus.INFO, "Closed popup");
		logger.info("Closed popup");
		obj.clickOnLoginButton();
		test.log(LogStatus.INFO, "Clicked on login button");
		logger.info("Clicked on login button");
		obj.sendInValidKeysToEnterNumber();;
		test.log(LogStatus.INFO, "Entered Invalid mobile number");
		logger.info("Entered Invalid mobile number");
		obj.clickOnRequestOtp();
		test.log(LogStatus.INFO, "Clicked on request OTP");
		logger.info("Clicked on request OTP");
		obj.assertErrorMessage();
		test.log(LogStatus.INFO, "Assertion Passed");
		logger.info("Assertion Passed");
	}
}
