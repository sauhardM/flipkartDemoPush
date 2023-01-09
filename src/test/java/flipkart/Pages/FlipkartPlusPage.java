package flipkart.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class FlipkartPlusPage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//a[contains(text(),'Explore')]")
	WebElement explorePlusXpath;
	
	@FindBy(xpath = "//a[@to='https://www.flipkart.com/supercoin']")
	WebElement superCoinLinkXpath;
	
	@FindBy(xpath = "//div[contains(text(),'SuperCoin Balance')]")
	WebElement superCoinsBalanceXpath;
	
	
	public FlipkartPlusPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void clickOnExplorePlus() {
		
		explorePlusXpath.click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("superCoinLinkLocator"))));
	}
	
	public void assertPageTitle() {
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("explorePlusPageTitle"));
	}
	
	public void clickOnSuperCoinLink() {
		
		superCoinLinkXpath.click();
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("superCoinsBalanceLocator"))));
	}
	
	public void assertSuperCoinPage() {
		
		Assert.assertTrue(superCoinsBalanceXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(),ReadingTestDataFile.getProperty("superCoinPageTitle") );
	}
	
}
