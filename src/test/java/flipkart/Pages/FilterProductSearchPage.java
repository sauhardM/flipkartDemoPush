package flipkart.Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FilterProductSearchPage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//div[contains(text(),'Gender')]")
	WebElement genderSelectXpath;
	
	@FindBy(xpath = "//div[@title='Men']")
	WebElement selectMenXpath;
	
	@FindBy(xpath = "//h1[contains(text(),\"Men's Jackets\")]")
	WebElement mensJacketPageHeaderXpath;
	
	@FindBy(xpath = "//img[@class='_3U-Vxu']")
	WebElement flipkartAssuredXpath;
	
	@FindBy(xpath = "//div[contains(text(),'Discount')]")
	WebElement DiscountXpath;
	
	@FindBy(xpath = "//div[contains(text(),'30% or more')]")
	WebElement selectDiscount;
	
	@FindBy(xpath = "//div[contains(text(),'Size')]")
	WebElement sizeXpath;
	
	@FindBy(xpath = "/descendant::div[@class='_3879cV'][5]")
	WebElement selectSize;
	
	@FindBy(xpath = "/descendant::div[@class='_3FdLqY'][2]")
	WebElement priceBar;
	
	@FindBy(xpath = "/descendant::div[@class='_2TbXIJ'][5]")
	WebElement dropLocationPriceBar;
	
	@FindBy(xpath = "//div[contains(text(),'Customer Ratings')]")
	WebElement customerRatingXpath;
	
	
	public FilterProductSearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement element){
		
		   Actions actions = new Actions(driver);
		   actions.moveToElement(element).build().perform();
		}
	
	public void selectGender() throws Exception{
		
		Assert.assertTrue(genderSelectXpath.isDisplayed());
		
		genderSelectXpath.click();
		
		selectMenXpath.click();
		
		Thread.sleep(5000);
		
	}
	
	public void selectFlipkartAssured() {
		
		
		flipkartAssuredXpath.click();
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",customerRatingXpath);
		
	}
	
	public void selectDiscount() throws Exception{
		
		DiscountXpath.click();
		
		selectDiscount.click();
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",customerRatingXpath);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Thread.sleep(5000);
				
	}
	
	public void selectSize() {
		
		sizeXpath.click();
		
		System.out.println("clicked 1");
		
		selectSize.click();
		
		System.out.println("clicked 2");
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",customerRatingXpath);

	}
	
	public void filterAmount() {
		
		Actions actions=new Actions(driver); 
		
		actions.dragAndDrop(priceBar,dropLocationPriceBar).build().perform();
	
	}
	 
}
