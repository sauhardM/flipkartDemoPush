package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.customerCarePage;

public class customerCareTest extends BasePage {

	@Test(groups = {"HomePage"})
	public void testCustomerCareSupport() throws Exception{
		
		customerCarePage obj = new customerCarePage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.moveToMoreOptions();
		test.log(LogStatus.INFO, "Cursor moved to more in navbar");
		logger.info("Cursor moved to more in navbar");
		
		obj.clickMoreOption();
		test.log(LogStatus.INFO, "Clicked more options in navbar");
		logger.info("Clicked more options in navbar");
		
		obj.moveToCustomerCareOption();
		test.log(LogStatus.INFO, "Cursor moved to customer care24x7 in navbar");
		logger.info("Cursor moved to customer care24x7 in navbar");
		
		obj.clickCustomerCareOption();
		test.log(LogStatus.INFO, "Clicked customer care 24x7 option");
		logger.info("Clicked customer care 24x7 option");
		
		obj.assertCustomerCarePage();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		
		obj.moveToInsuaranceHelpTopic();
		test.log(LogStatus.INFO, "Page scrolled down to insuarance help topic");
		logger.info("Page scrolled down to insuarance help topic");
		
		obj.clickSuperCoinsTopic();
		test.log(LogStatus.INFO, "Supercoin topic selected");
		logger.info("Supercoin topic selected");
		
		obj.selectYourQuery();
		test.log(LogStatus.INFO, "Question regarding topic selected");
		logger.info("Question regarding topic selected");
		
		obj.assertFeedback();
		test.log(LogStatus.INFO, "Assertion Passed");
		logger.info("Assertion Passed");
		
		obj.givingFeedback();
		test.log(LogStatus.INFO, "Feedback given as Yes");
		logger.info("Feedback given as Yes");
		
		obj.assertFeedbackMessage();
		test.log(LogStatus.INFO, "Assertion Passed");
		logger.info("Assertion Passed");
		
	}
}
