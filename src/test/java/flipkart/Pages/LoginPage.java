package flipkart.Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.model.Test;

import Com.JarUtils.ReadingPropertiesFile;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement LoginXpath;
	
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement enterNumberXpath;
	
	@FindBy(xpath = "//button[contains(text(),'Request OTP')]")
	WebElement requestOtpXpath;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	WebElement errorMessageXpath;
	
	//TestData
	String enterNumber = "8604680845";
	String enterInValidNumber = "123456789012";
	String InvalidLoginErrorMessage = "Please enter valid Email ID/Mobile number";
	String InvalidLoginMessageXpath = "//span[contains(text(),'Please enter valid Email ID/Mobile number')]";
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void clickOnLoginButton() {
		
		LoginXpath.click();
	}
	
	public void sendKeysToEnterNumber() {
		
		enterNumberXpath.sendKeys(enterNumber);
	}
	
	public void sendInValidKeysToEnterNumber() {
			
			enterNumberXpath.sendKeys(enterInValidNumber);
		}
	
	public void clickOnRequestOtp() {
		
		requestOtpXpath.click();
	}
	
	public void assertErrorMessage() {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(InvalidLoginMessageXpath)));
		Assert.assertEquals(errorMessageXpath.getText(),InvalidLoginErrorMessage );
	}
}
