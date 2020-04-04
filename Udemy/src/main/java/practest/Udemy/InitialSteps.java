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
import practest.Udemy.InitialPage;
import practest.Udemy.Base;
import practest.Udemy.InitialWithoutPageFactory;

public class InitialSteps extends Base
{
	private static final Logger logger = LogManager.getLogger(InitialSteps.class.getName());
	
	InitialSteps()
	{
		System.out.println("Start Initial Steps::");
	}
	 
	public void SignUp() throws IOException
	{
		Base.initializeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		InitialWithoutPageFactory pagewithoutfactory=new InitialWithoutPageFactory();
		InitialPage pageObject=new InitialPage();
		logger.trace("Entering application.");
		pageObject.firstnamepf.sendKeys("test");
		pageObject.lastnamepf.sendKeys("bansal");
		pagewithoutfactory.email.sendKeys("noreply@test.com");
		pagewithoutfactory.password.sendKeys("akku");
		logger.info("Enter Info:");
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
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", pagewithoutfactory.oSelectDay);
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollTo(0, 0)");
		
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		//String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.xml";
		//DOMConfigurator.configure(log4jConfigFile);
		logger.debug("Debug:");
		Select oSelectDayOfMonth=new Select(pagewithoutfactory.oSelectDay);
		oSelectDayOfMonth.selectByIndex(2);
		
		Select oSelectMonthOfYear=new Select(pagewithoutfactory.oSelectMonth);
		oSelectMonthOfYear.selectByValue("4");
		logger.error("Error:");
		
		Select oSelectYearOfCentury=new Select(pagewithoutfactory.oSelectYear);
		oSelectYearOfCentury.selectByVisibleText("2019");
		logger.fatal("Fatal:");
		
		File cFileNext=scrShot.getScreenshotAs(OutputType.FILE);
		Calendar calsNext= Calendar.getInstance();
		//Date currentDate=new Date();
		//calsNext.setTime(currentDate);
		calsNext.add(Calendar.DATE, 1);
		Date calNext=calsNext.getTime();
		File dFileNext=new File("C:\\Users\\Nidhi Gupta\\Downloads\\Seleniumshots\\" + fs.format(calNext) +".png");
		try {
			FileUtils.copyFile(cFileNext, dFileNext);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size=pagewithoutfactory.radioGender.size();
		for(int i=0;i<size;i++)
		{
			WebElement option=pagewithoutfactory.radioGender.get(i);
			String text=option.getText();
			
			   if(!option.isSelected())
				{option.click();
				break;}
		    
	    }
		
		js.executeScript("arguments[0].click();", pagewithoutfactory.btnSignUp);
		
		Actions act=new Actions(driver);
		act.moveToElement(pagewithoutfactory.lastname).doubleClick().build().perform();
		pagewithoutfactory.lastname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
	}
}
