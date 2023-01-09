package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.CareersPage;
import flipkart.Pages.GiftCardPage;

public class CareersTest extends BasePage {

	@Test(groups = {"HomePage"})
	public void testCareers() throws Exception {
		
		CareersPage obj = new CareersPage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scrolled down to the bottom of the page");
		logger.info("Scrolled down to the bottom of the page");
		
		obj.clickOnCareers();
		test.log(LogStatus.INFO, "Clicked on careers option in footer");
		logger.info("Clicked on careers option in footer");
		
		obj.assertCareerPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
		
		obj.moveToJobs();
		test.log(LogStatus.INFO, "Opening jobs at India");
		logger.info("Opening jobs at India");
	}
}
