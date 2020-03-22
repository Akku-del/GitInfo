package practest.Udemy;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practest.Udemy.*;

public class InitialPage{
	
	WebDriver driver;
	
	InitialPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
@FindBy(xpath="//input[@name='firstname']")
WebElement firstnamepf;
WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
@FindBy(xpath="//input[@name='lastname']")
WebElement lastnamepf;
WebElement email=driver.findElement(By.xpath("//input[contains(@name,'reg_email')  and @aria-label='Mobile number or email address']"));
WebElement password=driver.findElement(By.xpath("//input[contains(@name,'reg_passwd')  and @aria-label='New password']"));

WebElement oSelectDay=driver.findElement(By.xpath("//select[@name='birthday_day']"));
WebElement oSelectMonth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
WebElement oSelectYear=driver.findElement(By.xpath("//select[@name='birthday_year']"));

List<WebElement> radioGender=driver.findElements(By.xpath("//input[@name='sex']"));
WebElement radioFemale=driver.findElement(By.xpath("//label[text()='Female']//..//input"));


WebElement btnSignUp=driver.findElement(By.xpath("//button[text()='Sign Up' and @type='submit']"));
}
