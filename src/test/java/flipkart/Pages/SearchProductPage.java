package flipkart.Pages;

import java.io.InterruptedIOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchProductPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement searchBarXpath;
	
	@FindBy(xpath = "//a[@class='s1Q9rs'  and @title='PHILIPS OneBlade QP2525/10 Trimmer 43 min  Runtime 3 Length Settings']")
	WebElement productXPath;
	
	@FindBy(xpath = "//span[contains(text(),'Change')]")
	WebElement change_BtnXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Check')]")
	WebElement check_BtnXpath;
	
	
	
	//TestData
	String product = "philips one blade";
	String productSearchPageTitle = "Philips One Blade- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
	String showingResultsForProduct = "//span[@class='_10Ermr']//span[contains(text(),'"+product+"')]";
	String productPageTitle = "PHILIPS OneBlade QP2525/10 Trimmer 43 min Runtime 3 Length Settings Price in India - Buy PHILIPS OneBlade QP2525/10 Trimmer 43 min Runtime 3 Length Settings online at Flipkart.com";
	String deliveryPincodeLocation = "//input[@id='pincodeInputId']";
	String kanpurPinCode = "208011";
	
	public SearchProductPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void enterProductOnSearchBar() {
		
		searchBarXpath.sendKeys(product);
		searchBarXpath.sendKeys(Keys.RETURN);
	}
	
	public void assertPageTitle() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(showingResultsForProduct)));
		Assert.assertEquals(driver.getTitle(),productSearchPageTitle );
	}
	
	public void openProduct() {
		
		productXPath.click();
	}
	
	public void assertProductPageTitle() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(deliveryPincodeLocation)));
		Assert.assertEquals(driver.getTitle(), productPageTitle);
	}
	
	public void changeDeliveryCode() {
		
		driver.findElement(By.xpath(deliveryPincodeLocation)).clear();
		driver.findElement(By.xpath(deliveryPincodeLocation)).sendKeys(kanpurPinCode);
		check_BtnXpath.click();
	}
}
