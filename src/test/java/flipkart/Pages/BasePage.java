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
import org.openqa.selenium.firefox.FirefoxDriver;
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


public class BasePage {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Logger logger = LogManager.getLogger(BasePage.class);

	@BeforeMethod
	public void setup(Method method) {

		// setting path for all drivers
		String browser = ReadingPropertiesFile.getProperty("browser");
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				logger.info("opening chrome browser.");
			    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			    driver = new ChromeDriver();
			    
			}
			else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
				logger.info("opening edge browser.");
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				logger.info("opening firefox browser.");
			}
			else if(browser.equalsIgnoreCase("headless")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(true);
				options.addArguments("window-size=1920,1080");
			    driver = new ChromeDriver(options);
				logger.info("headless browser.");
				System.out.println("headless browser");

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
	