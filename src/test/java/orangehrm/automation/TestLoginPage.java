package orangehrm.automation;



import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class TestLoginPage extends BaseTest{
	ExtentTest test;

	@BeforeMethod
	public void startTest() {
		test = extent.createTest("TestLoginPage", "test the login page");
	}
	
	@AfterMethod
	public void endTest() {
		test.log(Status.INFO, "End of test");
	}
	
	@Test
	public void testCase01() {
		test.log(Status.INFO, "testcase01 started");
		String actualErrorMsg = new LoginPage(driver)
								.load()
								.inputUsername("Admin")
								.inputPassword("")
								.clickLogin()
								.getErrorMessage();
		boolean result = actualErrorMsg.equals("Password cannot be empty");
		if(result) {
			
			test.pass("details", 
				MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		}
		else {
			test.fail("details", 
					MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		}
		Assert.assertTrue(result);
	}
	
	
}


