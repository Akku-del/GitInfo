package practest.Udemy;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import practest.Udemy.*;

public class InitialSteps extends Base {
	
WebDriver localDriver;
	InitialSteps(WebDriver driver)
	{
		this.localDriver=driver;
	}
	 InitialPage pageObject=new InitialPage(driver);
	public void SignUp()
	{
		
		pageObject.firstnamepf.sendKeys("test");
		pageObject.lastnamepf.sendKeys("bansal");
		pageObject.email.sendKeys("noreply@test.com");
		pageObject.password.sendKeys("akku");
		
		TakesScreenshot scrShot =(TakesScreenshot)driver;
		File cFile=scrShot.getScreenshotAs(OutputType.FILE);
		File dFile=new File("C:\\Users\\Nidhi Gupta\\Downloads\\Seleniumshots\\inputdetails.png");
		try {
			FileUtils.copyFile(cFile, dFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", pageObject.oSelectDay);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		js.executeScript("window.scrollTo(0, 0)");
		
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Select oSelectDayOfMonth=new Select(pageObject.oSelectDay);
		oSelectDayOfMonth.selectByIndex(2);
		
		Select oSelectMonthOfYear=new Select(pageObject.oSelectMonth);
		oSelectMonthOfYear.selectByValue("4");
		
		Select oSelectYearOfCentury=new Select(pageObject.oSelectYear);
		oSelectYearOfCentury.selectByVisibleText("2019");
		
		File cFileX=scrShot.getScreenshotAs(OutputType.FILE);
		File dFileX=new File("C:\\Users\\Nidhi Gupta\\Downloads\\Seleniumshots\\selectdetails.png");
		try {
			FileUtils.copyFile(cFileX, dFileX);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size=pageObject.radioGender.size();
		for(int i=0;i<size;i++)
		{
			WebElement option=pageObject.radioGender.get(i);
			String text=option.getText();
			if(text.equals("Male"))
			{
				if(!option.isSelected())
				option.click();
				break;
		    }
	    }
		
		File cFileY=scrShot.getScreenshotAs(OutputType.FILE);
		File dFileY=new File("C:\\Users\\Nidhi Gupta\\Downloads\\Seleniumshots\\radiodetails.png");
		try {
			FileUtils.copyFile(cFileY, dFileY);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pageObject.radioFemale.click();
	    //pageObject.btnSignUp.click();
		js.executeScript("arguments[0].click();", pageObject.btnSignUp);
		
		Actions act=new Actions(driver);
		act.moveToElement(pageObject.firstname).build().perform();
		pageObject.lastname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
	}
}
