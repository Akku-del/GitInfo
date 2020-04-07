package practest.info.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import practest.Udemy.Base;
import practest.Udemy.InitialSteps;
import practest.info.tests.*;
import practest.Udemy.*;
public class HomePage extends Base{
	
	@Test(groups= {"TC_01","regression"})
	public void maindata() throws IOException {
		
		InitialSteps iSteps=new InitialSteps();
		iSteps.SignUp();
		driver.quit();
		
	}
	
	
}
