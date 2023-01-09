package flipkart.Pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Utilities.ReadingTestDataFile;

public class AddToCartPage {

	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']") 
	WebElement addToCartBtnXpath;  
	
	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement placeOrderBtnXpath;
	
	@FindBy(xpath = "//div[@class='_3dsJAO' and contains(text(),'Remove')]")
	WebElement removeBtnXpath;
	
	
	
	public AddToCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void scrollDownToAddToCartButton() throws Exception{
		
				
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		System.out.println(driver.getTitle());
		
		jse.executeScript("arguments[0].scrollIntoView(true);",addToCartBtnXpath);
		
	}
	
	public void clickOnAddToCartBtn() {
		
		addToCartBtnXpath.click();
	}
	
	public void AssertCartPage() throws Exception{
		
		Thread.sleep(5000);
		
//		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("placeOrderLocator"))));
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("addToCartPageTitle"));
	}
	
	public void clickOnRemoveProduct() { 
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",removeBtnXpath);
		
		removeBtnXpath.click();
	}
	
}
