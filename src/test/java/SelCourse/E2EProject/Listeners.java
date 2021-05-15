package SelCourse.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import res.ExtentReporterNG;


public class Listeners extends base implements ITestListener{
ExtentTest etest;
ExtentReports extent= ExtentReporterNG.getExtentReport();
ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		etest= extent.createTest(result.getMethod().getMethodName());
		test.set(etest);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	test.get().log(Status.PASS, "Test passed");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		String test1=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			
			test.get().addScreenCaptureFromPath(getScreenshot(test1,driver), test1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	extent.flush();
	}

}
