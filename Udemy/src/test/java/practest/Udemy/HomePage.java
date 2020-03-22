package practest.Udemy;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import practest.Udemy.*;

public class HomePage extends Base{
	
	@Test
	public static void main(String[] args) throws IOException {
		
		InitialSteps iSteps=new InitialSteps(driver);
	    driver.get("http://www.facebook.com");
	    driver.manage().window().maximize();
	    iSteps.SignUp();
		       	       
	}
	
	
}
