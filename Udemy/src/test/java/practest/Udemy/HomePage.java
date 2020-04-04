package practest.Udemy;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import practest.Udemy.*;

public class HomePage extends Base{
	
	@Test
	public void maindata() throws IOException {
		
		InitialSteps iSteps=new InitialSteps();
		iSteps.SignUp();
		System.out.println("Function");
		driver.quit();
		
	}
	
	
}
