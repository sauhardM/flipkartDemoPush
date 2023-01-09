package flipkart.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class AdvertisePage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//span[contains(text(),'Advertise')]")
	WebElement advertiseBtnXpath;
	
	@FindBy(xpath = "//div[contains(text(),'Brand Pulse')]")
	WebElement advertisePageHeaderXpath;
	
	@FindBy(xpath = "//input[@placeholder='Search for a brand or category']")
	WebElement brandCategorySearchXpath;
	
	@FindBy(xpath = "/descendant::div[@class='item-container flex'][1]")
	WebElement samsungBrandInMobileXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Awareness Trend of')]")
	WebElement brandPageHeader;
	
	public AdvertisePage(WebDriver driver) { 
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void scrollDownToBottom() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void clickOnFooterAdvertise() {
		
		advertiseBtnXpath.click();
	}
	
	public void assertAdvertisePage() {
		
		Assert.assertTrue(advertisePageHeaderXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("advertisePageTitle"));
	}
	
	public void searchBrand() {
		
		brandCategorySearchXpath.sendKeys(ReadingTestDataFile.getProperty("Brand"));
	}
	
	public void selectBrand() {
		
		samsungBrandInMobileXpath.click();
	}
	
	public void assertPageHeader() {
		
		Assert.assertTrue(brandPageHeader.isDisplayed());
	}
}
