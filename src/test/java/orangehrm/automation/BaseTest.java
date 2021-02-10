package orangehrm.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	ExtentReports extent; 
	@BeforeSuite
	public void startReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}
	
	@BeforeClass
	public void driverSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Opening Chrome Browser");
		driver.manage().window().maximize();
		System.out.println("Maximizing Browser");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("AfterClass");
		System.out.println("-----------------------");
		System.out.println("Closing Chrome Browser");
		driver.quit();
	}

	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
