package practest.Udemy;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.reflect.Method; 

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SureReports {

	ExtentSparkReporter extenthtmlReporter;
	ExtentReports extentreport;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setSureFireReport()
	{
		String reportPath = System.getProperty("user.dir") + "\\reports\\surefire-reports\\";
		extenthtmlReporter=new ExtentSparkReporter(reportPath);
		extenthtmlReporter.config().setDocumentTitle("Title");
		extenthtmlReporter.config().setEncoding("UTF-8");
		extenthtmlReporter.config().setReportName("Report:");
		extenthtmlReporter.config().setTheme(Theme.DARK);
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(extenthtmlReporter);
		extentreport.setSystemInfo("Computer name:", "DESKTOP-6788M5A");
		extentreport.setSystemInfo("OS", "Windows_NT");
		extentreport.setSystemInfo("PROCESSOR_ARCHITECTURE", "AMD64");
			
	}
	
	@Test
	public void omniLogin()
	{
		//extentTest.createNode("OMNI");
		System.out.println("OMNI Login successfully");
		
	}
	
	@Test
	public void createOrder()
	{
		    System.out.println("Order was not created successfully");
			Assert.fail("Order not created successfully");
	}
	
	@Test(enabled=true)
	public void submitOrder()
	{
		System.out.println("Order was not submitted successfully");
			
	}
	@BeforeMethod
	public void interview(Method method)
	{
		String className = this.getClass().getSimpleName();
		extentTest = extentreport.createTest(className + "-" + method.getName());
	}
	@AfterMethod
	public void reviewOrder(ITestResult result)
	{
		String methodName = result.getName();
		extentTest.createNode(methodName);
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, MarkupHelper.createLabel(methodName + " – Test Case Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " – Test Case Failed", ExtentColor.RED));
			// Here you can add screenshot in the report for fail case
			extentTest.fail(methodName + "Test Step Failed");
			}
		if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + "– Test Case Skipped", ExtentColor.ORANGE));
			extentTest.skip(methodName + "Test Step Skipped");
			}
			if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS,MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			extentTest.pass(methodName + "Test Step Passed");
			}
	}
	@AfterTest
	public void tearDown()
	{
		extentreport.flush();
		SimpleDateFormat sd=new SimpleDateFormat("yyyyMMddHHmmss");
		Date d=new Date();
		String filedest=System.getProperty("user.dir") + "\\reports\\surefire-reports\\index.html";
	    File f=new File(filedest);
	    String sb=System.getProperty("user.dir") + "\\output\\surefire-reports\\" +sd.format(d).toString();
	    File dest=new File(sb);
	    f.renameTo(dest);
	    
	}
}
