package Utilites;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners extends TestListenerAdapter{
	
	public  ExtentHtmlReporter htmlReport; 
	public  ExtentTest test;	
	public  ExtentReports report;
	

	public void onStart(ITestContext testcontext)
	{
	     	 htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myreport.html");
	     	 htmlReport.config().setDocumentTitle("RestAssure Framework Report");
	     	 htmlReport.config().setReportName("EmployeeAPIReport");
	     	 htmlReport.config().setTheme(Theme.DARK);
	     	 
	     	 report = new ExtentReports();
	     	 report.attachReporter(htmlReport);
	     	 report.setSystemInfo("HostName", "LocalHost");
	     	 report.setSystemInfo("Environemnt", "QA");
	     	 report.setSystemInfo("User", "Mohit");

	}
	
    public void onTestSuccess(ITestResult testResult)
    {
    	test = report.createTest(testResult.getName());
    	test.log(Status.PASS, "Test Case is passed :"+testResult.getName());
    }
 
    public void onTestFailures(ITestResult testResult)
    {
    	test = report.createTest(testResult.getName());
    	test.log(Status.FAIL, "Test Case is failed :"+testResult.getName());
    	test.log(Status.FAIL, "Test Case is failed :"+testResult.getThrowable());
    }
    
    public void onTestskipped(ITestResult testResult)
    {
    	test = report.createTest(testResult.getName());
    	test.log(Status.SKIP, "Test Case is failed :"+testResult.getName());
    	test.log(Status.SKIP, "Test Case is failed :"+testResult.getThrowable());
    }
    
 
    public void onFinish(ITestContext testcontext)
    {
    	report.flush();
    }
}
