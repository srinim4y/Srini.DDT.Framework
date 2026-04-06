package swagLabs.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import swagLabs.BaseTest.BaseTest;
import swagLabs.GenericUtilities.JavaUtilities;
import swagLabs.GenericUtilities.WebDriverUtility;

/**
 * This class provides implementation to the ITestListeners of TestNG
 */
public class ListenersImplementation implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " @Test Execution starts");
		
		//create test for Extent Report
		test = report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName + " @Test Execution Success");
		
		//Log the test status in Extent Report
		test.log(Status.PASS, methodName + " -> @Test Execution PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName + " @Test Execution Failed");
		
		//capturing exception
		System.out.println("The Exception is :" + result.getThrowable());
		
		//Log the test status in Extent Report
		test.log(Status.FAIL,methodName + " -> @Test Execution FAIL");
		test.log(Status.WARNING,result.getThrowable());
		
		//Capture Screenshot
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtilities jUtil = new JavaUtilities();
		
		//Capture the screenshot name
		String screenshotName = methodName+"-"+jUtil.getSystemDate();
		
		try {
			
			//wUtil.captureScreenshot(BaseTest.sDriver, screenshotName); // This is the initial line for capturing screenshot
			String path = wUtil.captureScreenshot(BaseTest.sDriver, screenshotName); // Here we are storing in String to use in Extent Report (While writing code for Extent Report)
			
			//Attach screenshot to report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " @Test Execution Skipped");
		//capturing the exception
		System.out.println("The Exception is :" + result.getThrowable());
		
		//Log the test status in Extent Report
		test.log(Status.SKIP, methodName + " -> @Test Execution FAIL");
		test.log(Status.WARNING,result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution starts");
		
		//Basic configuration of Extent Reports
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report-" + new JavaUtilities().getSystemDate() + ".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Swag Labs UI Automation Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "https://www.TestEnv.com");
		report.setSystemInfo("Reporter Name", "Srini");
				
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Finished");
		
		//generate Extent Report
		report.flush();
		
	}
	

}
