package TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentReports extent=ExtentReporterNG.config();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //carete uniqe thread id
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test succeeds
    	extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
    	extentTest.get().fail(result.getThrowable());
    	
    	try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
    	
    	//Screenshot ,Attach the report
    	String FilePath = null;
		try {
			FilePath = takeScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(FilePath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but is within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests have run
    	extent.flush();
    }

}
