package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import practest.Udemy.Base;

public class Listeners extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test Success::");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		File cFileY=scrShot.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat fs=new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cals= Calendar.getInstance();
		Date cal=cals.getTime();
		File dFileY=new File("C:\\Users\\Nidhi Gupta\\Downloads\\Seleniumshots\\" + fs.format(cal) +".png");
		try {
			FileUtils.copyFile(cFileY, dFileY);
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

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
