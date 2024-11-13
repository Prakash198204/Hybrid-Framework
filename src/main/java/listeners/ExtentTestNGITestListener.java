package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserFactory.BrowserFactory;
import helper.Utility;

public class ExtentTestNGITestListener implements ITestListener {
	
	ExtentReports extent =ExtentManager.getInstance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		//Test start - add test
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		// add pass logs
		parentTest.get().pass("Test passed");

	}
	
	public void onTestFailure(ITestResult result) {
		// add fail log, exception trace, add screenshot
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String base64 = Utility.captureScreenshotasBase64(driver);
		parentTest.get().fail("Test failed " +result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

	}
	

	public void onTestSkip(ITestResult result) {
		//add skip log
		parentTest.get().skip("Test skipped " +result.getThrowable().getMessage());

	}

	public void onFinish(ITestContext context) {
		// add finish flush
		extent.flush();

	}

}
