package flipkart.Pages;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BecomeSellerPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//a[@class='_3-PJz-']/span[contains(text(),'Become a Seller')]")
	WebElement becomeSellerBtnXpath;
	
	@FindBy(xpath = "//div[contains(text(),'Start Selling')]")
	WebElement startSellingBtnXpath;
	
	@FindBy(xpath = "//input[@name='mobileNumber']")
	WebElement mobileNumberXpath;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Register & Continue')]")
	WebElement registerAndContBtnXpath;
	
	//TestData
	String startSellingBtnLocator = "//div[@class='styles__RegisterContainer-sc-1kfv72o-0 ilMBvo']";
	String becomeSellerPageTitle = "Sell Online - Become a Online Seller in India | Flipkart Seller Hub";
	String startSellingPageTitle = "Seller Dashboard";
	String registerAndContinueBtnLocator = "//span[contains(text(),'Register & Continue')]";
	String mobileNumber = "8604680845";
	String eMail = "mishra.sauhard@gmail.com";
	
	public BecomeSellerPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void clickOnBecomeSellerBtn() {
		becomeSellerBtnXpath.click();
	}
	
	public void AssertSellerPageTitle() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(startSellingBtnLocator)));
		
		Assert.assertTrue(startSellingBtnXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), becomeSellerPageTitle);
	}
	
	public void clickOnStartSelling() {
		
		startSellingBtnXpath.click();
	}
	
	public void AssertStartSellingPageTitle() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(registerAndContinueBtnLocator)));

		
		Assert.assertEquals(driver.getTitle(), startSellingPageTitle);
	}
	
	public void enterNumberAndEmail() {
		
		mobileNumberXpath.sendKeys(mobileNumber);
		emailXpath.sendKeys(eMail);
	}
	
	public void clickOnRegisterAndContinue() {
		
		registerAndContBtnXpath.click();
	}
}
