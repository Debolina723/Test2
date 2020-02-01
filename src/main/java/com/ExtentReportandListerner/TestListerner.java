package com.ExtentReportandListerner;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestUtil.TestUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;

public class TestListerner extends TestBase implements ITestListener {

	public TestListerner() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onTestStart(ITestResult tr) {
		log("Test Started....");
		ExtentTestManager.startTest(tr.getMethod().getMethodName(), " ");
	}

	
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");

		// This will print the class name in which the method is present
		log(tr.getTestClass());

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		log("Priority of this method is " + tr.getMethod().getPriority());

		System.out.println(".....");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test case is PASSED......");
	}

	
	public void onTestFailure(ITestResult tr) {

		log("Test '" + tr.getName() + "' FAILED");
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....Error......."+tr.getName()+"Test Has Failed...........");
		String methodName=tr.getName().toString().trim();
	       //ITestContext context = tr.getTestContext();
	     // WebDriver driver = (WebDriver)context.getAttribute("driver");
	       try {
			TestUtil.takesScreenshot(methodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		
	      
	      String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	   ExtentTestManager.getTest().log(LogStatus.FAIL, ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		
		
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test case is FAILED....");
		ExtentTestManager.getTest().log(LogStatus.FAIL, tr.getThrowable());
	}

	
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentTestManager.endTest();
        ExtentManager.getreporter().flush();
	}

	public void onStart(ITestContext result) {
		
		log("Test"+result.getName()+"Started");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	
}

