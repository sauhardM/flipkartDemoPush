package flipkart.Pages;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.TestException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.JarUtils.ReadingPropertiesFile;
import flipkart.Utilities.ExtentReportManager;

import flipkart.Utilities.Screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String browser, Mode;
	public static Logger logger = LogManager.getLogger(BasePage.class);

	@BeforeMethod
	public void setup(Method method) {

		// setting path for all drivers
		 browser = ReadingPropertiesFile.getProperty("browser");
		 Mode = ReadingPropertiesFile.getProperty("mode");
		 
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				logger.info("opening chrome browser.");
			    WebDriverManager.chromedriver().setup();
			    if (Mode.equalsIgnoreCase("Headless")) {
					ChromeOptions options = new ChromeOptions();
					options.addArguments("window-size= 1920, 1080");
					options.addArguments("--headless");
					driver = new ChromeDriver(options);
					System.out.println("headless mode");
				} else {
					driver = new ChromeDriver();
				}   
			}
			else if(browser.equalsIgnoreCase("edge")) {
				logger.info("opening edge browser.");
				WebDriverManager.edgedriver().setup();
				if (Mode.equalsIgnoreCase("Headless")) {
	                EdgeOptions options = new EdgeOptions();
	                options.addArguments("window-size= 1920, 1080");
	                options.addArguments("--headless");
	                driver = new EdgeDriver(options);
	                System.out.println("headless mode");
				} else {
					driver = new EdgeDriver();
				}   
				
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				logger.info("opening firefox browser.");
				WebDriverManager.firefoxdriver().setup();
				if (Mode.equalsIgnoreCase("Headless")) {
					FirefoxOptions options = new FirefoxOptions();
	                options.addArguments("window-size= 1920, 1080");
	                options.addArguments("--headless");
	                driver = new FirefoxDriver(options);
	                System.out.println("headless mode");
				} else {
					driver = new FirefoxDriver();
				}   
				
			}
			else {
				Assert.assertTrue("No browser type sent",false);
				System.out.println("Selected browser value should be either firefox or chrome or edge or headless --> Update in Configuration file is required");
				//throw an exception 
			}
			
			extent = ExtentReportManager.getInstance("Reports//Extent_demo.html");
			test = extent.startTest(method.getName());
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Integer waitDuration = Integer.valueOf(ReadingPropertiesFile.getProperty("waitDuration"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitDuration));
			driver.get(ReadingPropertiesFile.getProperty("url"));
			
		}
		catch (Exception e) {
			logger.warn(e.getMessage());
		}

	}
	
	
	@AfterMethod
	public void status(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if (result.getStatus()==ITestResult.FAILURE) {
			Screenshot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.ERROR, test.addScreenCapture(System.getProperty("user.dir") + "//Screenshots//" + result.getName() +" .jpg"));
			test.log(LogStatus.ERROR, result.getThrowable());
			test.log(LogStatus.FAIL, "Test case got failed");
		}
		    extent.flush();
		    driver.quit();
	}
}
	