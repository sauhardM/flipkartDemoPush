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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import flipkart.Utilities.ReadingTestDataFile;

public class CareersPage {

	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'✕')]")
	WebElement popUPCloseButton;
	
	@FindBy(xpath = "//a[contains(text(),'Careers')]")
	WebElement careersXpath;
	
	@FindBy(xpath = "//a[@id='candidate-login-before']")
	WebElement candidateLoginXpath;
	
	@FindBy(xpath = "/descendant::a[contains(text(),'Jobs')][1]")
	WebElement jobsXpath;
	
	@FindBy(xpath = "/descendant::a[contains(text(),'Jobs @ India')][1]")
	WebElement jobsAtIndia;
	
	
	public CareersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopup() {
		popUPCloseButton.click();
	}
	
	public void scrollDownToBottom() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void clickOnCareers() {
		
		careersXpath.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ReadingTestDataFile.getProperty("candidateLoginLocator"))));
	}
	
	public void assertCareerPage() throws Exception {
		
		Thread.sleep(5000);
		
		Assert.assertTrue(candidateLoginXpath.isDisplayed());
		
		Assert.assertEquals(driver.getTitle(), ReadingTestDataFile.getProperty("careersPageTitle"));
	}
	
	public void moveToJobs() {
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(jobsXpath).build().perform();
		
//		actions.moveToElement(jobsAtIndia).build().perform();

		jobsAtIndia.click();
		
	}
}
