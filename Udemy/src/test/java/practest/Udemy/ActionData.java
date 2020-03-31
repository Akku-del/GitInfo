package practest.Udemy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
//log4j properties not working
//git pull not taking updated code from remote branch to local branch repository
//difference between git fetch and git pull
//can we push code from develop local branch to master remote branch and vice versa
//sure-fire reports
//jenkins
//what are maven goals
//rerun scripsts after failure
public class ActionData extends Base{

	@Test
	public void info() throws IOException
	{
	Base.initializeDriver();
	Actions a=new Actions(driver);
	driver.get("https://demoqa.com/iframe-practice-page/");
	//String selectAll = Keys.chord(Keys.CONTROL, "a");
	//a.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
	WebElement frameElement = driver.findElement(By.id("IF1"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", frameElement);
	driver.switchTo().frame(frameElement);
	WebElement element=driver.findElement(By.xpath("//a[text()='Skip to content']"));
	element.click();
	/*String nameOrId=null;
	driver.switchTo().frame(nameOrId);
	int index=0;
	driver.switchTo().frame(index);
	driver.switchTo().defaultContent();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement element;
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
	element.click();
	DriverManager xl= DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	String url="jdbc:oracle:thin:@localhost:1521:serviceName";
	Connection conn=xl.getConnection(url, "root", "pass");
	Statement s=conn.createStatement();
	ResultSet r=s.executeQuery("Select * from table");
	while(r.next())
	{
		r.getString(1);
	}
	
	
	*/
	
	}
}
