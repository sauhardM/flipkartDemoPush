package flipkart.Pages;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Com.JarUtils.ReadingPropertiesFile;
import flipkart.Utilities.ReadingTestDataFile;

public class SignUpPage {

	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement LoginXpath;
	
	@FindBy(xpath = "//div[contains(text(),'Sign Up')]")
	WebElement signUpXpath;
	
	@FindBy(xpath = "//span[contains(text(),\"Looks like you're new here!\")]")
	WebElement newMemberBannerMessageXpath;
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement enterMobileNumberXpath;
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement coninueButtonXpath;
	
	
	public SignUpPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void moveToElementLogin() throws Exception{
		
		Actions actions = new Actions(driver);
		actions.moveToElement(LoginXpath).build().perform();
	}
	
	public void moveToSignUpButton() throws Exception {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(signUpXpath).build().perform();
		signUpXpath.click();
	}
	
	public void assertBannerMessage() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("newMemberBannerMessageLocator"))));
		
		Assert.assertEquals(newMemberBannerMessageXpath.getText(), ReadingTestDataFile.getProperty("newMemberBannerMessage") );
	}
	
	public void enterMobileNumber() {
		
		enterMobileNumberXpath.sendKeys(ReadingTestDataFile.getProperty("mobileNumber"));
	}
	
	public void clickOnContinueButton() {
		
		coninueButtonXpath.click();
	}
	
}
