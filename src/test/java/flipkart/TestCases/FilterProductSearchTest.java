package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FilterProductSearchPage;

public class FilterProductSearchTest extends BasePage {

	@Test(groups = {"ProductPage"})
	public void filterSearch() throws Exception{
		
		DropdownProductSearchTest obj = new DropdownProductSearchTest();
		
		obj.dropDownProductSearch();
		
		FilterProductSearchPage obj2 = new FilterProductSearchPage(driver);
		
		obj2.selectGender();
		test.log(LogStatus.INFO, "Gender selected");
		logger.info("Gender selected");
		
		obj2.selectFlipkartAssured();
		test.log(LogStatus.INFO, "Flipkart assured selected");
		logger.info("Flipkart assured selected");
		
		obj2.selectDiscount();
		test.log(LogStatus.INFO, "Discount selected");
		logger.info("Discount selected");
		
		obj2.selectSize();
		test.log(LogStatus.INFO, "Size selected");
		logger.info("Size selected");
		
		obj2.filterAmount();
		test.log(LogStatus.INFO, "Amount filtered");
		logger.info("Amount filtered");
		
	}
}
