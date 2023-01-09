package flipkart.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class DropdownProductSearchPage {
	
	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//div[contains(text(),'Fashion')]")
	WebElement fashionDropdownXpath;
	
	@FindBy(xpath = "//a[contains(text(),'Winter')]")
	WebElement winterCategoryXpath;
	
	@FindBy(xpath = "//a[contains(text(),\"Men's Jackets\")]")
	WebElement mensJacketCategoryXpath;
	
	@FindBy(xpath = "//h1[contains(text(),\"Men's Jackets\")]")
	WebElement mensJacketPageHeaderXpath;
	
	
	public DropdownProductSearchPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	
	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void selectFromFahionDropdown() throws Exception{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(fashionDropdownXpath).build().perform();
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		actions.moveToElement(winterCategoryXpath).build().perform();
		
		actions.moveToElement(mensJacketCategoryXpath).build().perform();
		
	}
	
	public void openSelectedCategory() {
		
		mensJacketCategoryXpath.click();
	}
	
	public void asertionsOnMenCategoryPage() {
		
		Assert.assertTrue(mensJacketPageHeaderXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("mensJacketPageTile"));
	}
}
