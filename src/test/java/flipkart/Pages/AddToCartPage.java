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

public class AddToCartPage {

	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']") 
	WebElement addToCartBtnXpath;  
	
	@FindBy(xpath = "//span[contains(text(),'Place Order')]")
	WebElement placeOrderBtnXpath;
	
	@FindBy(xpath = "//div[@class='_3dsJAO' and contains(text(),'Remove')]")
	WebElement removeBtnXpath;
	
	//TestData
	String addToCart_BtnLocator = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']";
	String loginBtnLocator = "//a[contains(text(),'Login')]";
	String placeOrderLocator = "//span[contains(text(),'Place Order')]";
	String addToCartPageTitle = "Shopping Cart | Flipkart.com";
	
	
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
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(placeOrderLocator)));
		
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), addToCartPageTitle);
	}
	
	public void clickOnRemoveProduct() {
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",removeBtnXpath);
		
		removeBtnXpath.click();
	}
	
}
