package flipkart.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class customerCarePage {
	
	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//div[@class='exehdJ']")
	WebElement moreXpath;
	
	@FindBy(xpath = "//div[contains(text(),'24x7 Customer Care')]")
	WebElement customerCareXpath;
	
	@FindBy(xpath = "//h1[contains(text(),'Flipkart Help Center | 24x7 Customer Care Support')]")
	WebElement customerCarePageHeader;
	
	@FindBy(xpath = "//span[contains(text(),'Insurance')]")
	WebElement insuaranceXpath;
	
	@FindBy(xpath = "/descendant::span[contains(text(),'SuperCoins')][1]")
	WebElement superCoinsXpath;
	
	@FindBy(xpath = "//span[contains(text(),'View More')]")
	WebElement viewMoreXpath;
	
	@FindBy(xpath = "//p[contains(text(),'How do I renew my benefits as part of SuperCoin Mi')]")
	WebElement superCoinQuestion;
	
	@FindBy(xpath = "//span[contains(text(),'Was this helpful?')]")
	WebElement feedbackXpath;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement feedbackYesBtnXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Thank you for your feedback')]")
	WebElement feedbackMessageXpath;
	
	public customerCarePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void moveToMoreOptions() {
		
		Actions actions=new Actions(driver); 
		
		actions.moveToElement(moreXpath).build().perform();
		
	}
	
	public void clickMoreOption() {
		
		moreXpath.click();
	}
	
	public void moveToCustomerCareOption() {
		
		Actions actions=new Actions(driver); 
		
		actions.moveToElement(customerCareXpath).build().perform();
		
	}
	
	public void clickCustomerCareOption() {
		
		customerCareXpath.click();
	}
	
	public void assertCustomerCarePage() {
		
		Assert.assertTrue(customerCarePageHeader.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("customerCarePageTitle"));
	}
	
	public void moveToInsuaranceHelpTopic() {
		
		JavascriptExecutor jse  = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView(true);",insuaranceXpath);
		
	}
	
	public void clickSuperCoinsTopic() {
		
		superCoinsXpath.click();
	}
	
	public void selectYourQuery() {
		
		viewMoreXpath.click();

		superCoinQuestion.click();
	}
	
	public void assertFeedback() {
		
		Assert.assertTrue(feedbackXpath.isDisplayed());
	}
	
	public void givingFeedback() {
		
		feedbackYesBtnXpath.click();
	}
	
	public void assertFeedbackMessage() {
		
		Assert.assertTrue(feedbackMessageXpath.isDisplayed());
	}

}
