package flipkart.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.GiftCardPage;

public class GiftCardTest extends BasePage {

	@Test(priority = 0,groups = {"HomePage"})
	public void testGiftCards() {
		
		GiftCardPage obj = new GiftCardPage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scrolled down to the bottom of the page");
		logger.info("Scrolled down to the bottom of the page");
		
		obj.clickOnGiftCards();
		test.log(LogStatus.INFO, "Clicked on gift card footer");
		logger.info("Clicked on gift card footer");
		
		obj.assertGiftCardPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
		
		
	}
	
	@Test(priority = 1,groups = {"HomePage"})
	public void testBirthdayGiftCards() {
		
		testGiftCards();

		GiftCardPage obj = new GiftCardPage(driver);
		
		obj.clickOnBirthdayGiftCards();
		test.log(LogStatus.INFO, "Clicked on birthday gift cards");
		logger.info("Clicked on birthday gift cards");
		
		obj.AssertBirthdayGiftCardPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
	}
	
	@Test(priority = 2)
	public void testShopByPriceGiftCards() {
		
		testGiftCards();

		GiftCardPage obj = new GiftCardPage(driver);
		
		obj.scrollToShopByPrice();
		test.log(LogStatus.INFO, "Scrolled down to the shop by price section");
		logger.info("Scrolled down to the shop by price section");
		
		obj.clickOnShopByPrice();
		test.log(LogStatus.INFO, "Selected gift card by price");
		logger.info("Selected gift card by price");
		
		obj.AssertBirthdayGiftCardPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
	}
}
