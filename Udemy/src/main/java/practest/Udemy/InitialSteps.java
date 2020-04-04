package practest.Udemy;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import practest.Udemy.InitialPageWithPageFactory;
import practest.Udemy.Base;
import practest.Udemy.InitialPageWithoutPageFactory;

public class InitialSteps extends Base
{
	private static final Logger logger = LogManager.getLogger(InitialSteps.class.getName());
	
	public InitialSteps()
	{
		System.out.println("Open Application");
	}
	 
	public void SignUp() throws IOException
	{
		Base.initializeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		//PageFactory
		InitialPageWithoutPageFactory pageObjectWithoutPageFactory=new InitialPageWithoutPageFactory();
		//WithoutPageFactory
		InitialPageWithPageFactory pageObjectWithPageFactory=new InitialPageWithPageFactory();
		
		//Perform logging
		logger.trace("Facebook Application is opened");
		logger.info("Enter Info:");
		pageObjectWithPageFactory.firstnamepf.sendKeys("test");
		pageObjectWithPageFactory.lastnamepf.sendKeys("tester");
		pageObjectWithoutPageFactory.email.sendKeys("noreply@test.com");
		pageObjectWithoutPageFactory.password.sendKeys("root");
		
		//captureSS
		Screenshot scr=new Screenshot();
		scr.captureSS();
		
		//Java Script Executor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", pageObjectWithoutPageFactory.oSelectDay);
		
		/*js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
		//String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.xml";
		//DOMConfigurator.configure(log4jConfigFile);
		
		logger.debug("Debug:");
		Select oSelectDayOfMonth=new Select(pageObjectWithoutPageFactory.oSelectDay);
		oSelectDayOfMonth.selectByIndex(2);
		Select oSelectMonthOfYear=new Select(pageObjectWithoutPageFactory.oSelectMonth);
		oSelectMonthOfYear.selectByValue("4");
		Select oSelectYearOfCentury=new Select(pageObjectWithoutPageFactory.oSelectYear);
		oSelectYearOfCentury.selectByVisibleText("2019");
		scr.captureSS();
		int size=pageObjectWithoutPageFactory.radioGender.size();
		for(int i=0;i<size;i++)
		{
			WebElement option=pageObjectWithoutPageFactory.radioGender.get(i);
			String text=option.getText();
			
			   if(!option.isSelected())
				{option.click();
				break;}
		    
	    }
		
		js.executeScript("arguments[0].click();", pageObjectWithoutPageFactory.btnSignUp);
		logger.error("Error:");
		logger.fatal("Fatal:");
		
		js.executeScript("window.scrollTo(0, 0)");
		Actions act=new Actions(driver);
		act.moveToElement(pageObjectWithPageFactory.lastnamepf).click().build().perform();
		act.keyDown(pageObjectWithPageFactory.lastnamepf,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); 
	    act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
	    act.keyDown(pageObjectWithPageFactory.firstnamepf,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		scr.captureSS();
	}
}
