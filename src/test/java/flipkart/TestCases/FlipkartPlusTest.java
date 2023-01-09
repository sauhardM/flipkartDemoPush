package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FlipkartPlusPage;

public class FlipkartPlusTest extends BasePage{

	@Test(groups = {"HomePage"})
	public void flipkartPlusTest() throws Exception{
		
		FlipkartPlusPage obj = new FlipkartPlusPage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.clickOnExplorePlus();
		test.log(LogStatus.INFO, "Clicked on explore plus");
		logger.info("Clicked on explore plus");
		
		obj.assertPageTitle();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		
		obj.clickOnSuperCoinLink();
		test.log(LogStatus.INFO, "Supercoin link clicked");
		logger.info("Supercoin link clicked");
		
		obj.assertSuperCoinPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
	}
}
