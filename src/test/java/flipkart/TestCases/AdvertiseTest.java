package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.AdvertisePage;
import flipkart.Pages.BasePage;

public class AdvertiseTest extends BasePage{

	@Test(priority = 0,groups = {"HomePage"})
	public void testAdvertisement() throws Exception{
		
		AdvertisePage obj = new AdvertisePage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scrolled down to the bottom of the page");
		logger.info("Scrolled down to the bottom of the page");
		
		obj.clickOnFooterAdvertise();
		test.log(LogStatus.INFO, "Clicked on footer advertise");
		logger.info("Clicked on footer advertise");
		
		obj.assertAdvertisePage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
		
	}
	
	@Test(priority = 1,groups = {"HomePage"})
	public void testBrand() throws Exception{
		
		testAdvertisement();
		
		AdvertisePage obj = new AdvertisePage(driver);
		
		obj.searchBrand();
		test.log(LogStatus.INFO, "Searched Brand");
		logger.info("Searched Brand");
		
		obj.selectBrand();
		test.log(LogStatus.INFO, "Selected brand");
		logger.info("Selected brand");
		
		obj.assertPageHeader();
		test.log(LogStatus.INFO, "Assertion passed");
		logger.info("Assertion passed");
		

	}
}
