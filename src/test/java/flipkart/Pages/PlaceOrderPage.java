package flipkart.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class PlaceOrderPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='_3dsJAO' and contains(text(),'Remove')]")
	WebElement removeBtnXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement placeOrderBtnXpath;
	
	@FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
	WebElement continueBtnXpath;
	
	@FindBy(xpath = "//input[@class='_2IX_2- _17N0em']")
	WebElement enterMobileXpath;
	
	
	public PlaceOrderPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	public void clickOnPlaceOrder() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("removeBtnLocator"))));
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",removeBtnXpath);
		
		placeOrderBtnXpath.click();
	}
	
	public void AssertPlaceOrderPage() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("continueBtnLocator"))));
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("PlaceOrderPageTitle"));
	}
	
	public void enterMobileNumber() {
		
		enterMobileXpath.sendKeys(ReadingTestDataFile.getProperty("mobileNumber"));
	}

	public void clickOnContinueBtn() {
		
		continueBtnXpath.click();
	}
}
