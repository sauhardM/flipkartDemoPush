package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.DropdownProductSearchPage;

public class DropdownProductSearchTest extends BasePage {

	@Test(groups = {"HomePage"})
	public void dropDownProductSearch() throws Exception {
		
		DropdownProductSearchPage obj = new DropdownProductSearchPage(driver);
		
		obj.closePopup();
		test.log(LogStatus.INFO, "Popup closed");
		logger.info("Popup closed");
		
		obj.selectFromFahionDropdown();
		test.log(LogStatus.INFO, "Selecting category from dropdown");
		logger.info("Selecting category from dropdown");
		
		obj.openSelectedCategory();
		test.log(LogStatus.INFO, "Opened men's jacket category");
		logger.info("Opened men's jacket category");
		
		obj.asertionsOnMenCategoryPage();
		test.log(LogStatus.INFO, "Assertions passed");
		logger.info("Assertions passed");
		
	}
}
