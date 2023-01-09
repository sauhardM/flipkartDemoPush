package flipkart.Pages;

import java.time.Duration;

import org.junit.FixMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class GiftCardPage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//span[contains(text(),'Gift Cards')]")
	WebElement giftCardXpath;
	
	@FindBy(xpath = "//h1[contains(text(),'Gift Card Store')]")
	WebElement giftCardPageHeaderXpath;
	
	@FindBy(xpath = "//img[@src='https://rukminim1.flixcart.com/flap/100/100/image/8125f4708060ba40.jpg?q=50']")
	WebElement birthdayGiftCards;
	
	@FindBy(xpath = "//h1[contains(text(),'Digital Gift Cards')]")	
	WebElement birthdayGiftCardPageHeader;
	
	@FindBy(xpath = "/descendant::img[@alt='c'][1]")
	WebElement buyNowImgXpath;
	
	@FindBy(xpath = "//a[contains(text(),'VIEW ALL')]")
	WebElement viewAllXpath;
	
	@FindBy(xpath = "//img[@src='https://rukminim1.flixcart.com/flap/100/100/image/61b08c7fa14837b0.jpg?q=50']")
	WebElement shopByRsXpath;
	
	
	public GiftCardPage(WebDriver driver) {
		
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
	
	public void clickOnGiftCards() {
		
		giftCardXpath.click();
	}
	
	public void assertGiftCardPage() {
		
		Assert.assertTrue(giftCardPageHeaderXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("giftCardPageTitle"));
	}
	
	public void clickOnBirthdayGiftCards() {
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",viewAllXpath);
		
		birthdayGiftCards.click();
	}
	
	public void AssertBirthdayGiftCardPage() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("birthdayGiftCardPageHeaderLocator"))));

		
		Assert.assertTrue(birthdayGiftCardPageHeader.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("birthdayGiftCardPageTitle"));
	}
	
	public void scrollToShopByPrice() {
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",viewAllXpath);
		
	}
	
	public void clickOnShopByPrice() {
		
		shopByRsXpath.click();
	}
	
}
