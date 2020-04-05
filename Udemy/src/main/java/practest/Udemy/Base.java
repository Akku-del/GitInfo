package practest.Udemy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	public static WebDriver driver=null;
	
	public static WebDriver initializeDriver() throws IOException 
	{
		System.out.println("initializeDriver::");
     Properties prop=new Properties(); 
     FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\dataFile.properties");
     prop.load(fileInputStream);
     String browserprop=prop.getProperty("browser");
     String browser =System.getenv("browsertype");
     
     if(browser.equals("chrome"))
     {
    	 
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\Nidhi Gupta\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	 
    	 driver=new ChromeDriver();
    	 
     }
     else if(browser.equals("firefox"))
     {
    	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nidhi Gupta\\Downloads\\practicedrivers\\gecko.exe");
    	 driver=new FirefoxDriver();
     }
     else if(browser.equals("ie"))
     {
    	 System.setProperty("webdriver.ie.driver", "C:\\Users\\Nidhi Gupta\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
    	 driver=new InternetExplorerDriver();
     }
     else
     {
    	 System.out.println("Driver not supported");
     }
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     return driver;
    }
}