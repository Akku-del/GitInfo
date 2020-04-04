package practest.Udemy;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practest.Udemy.*;

public class InitialPageWithPageFactory extends Base
{
public InitialPageWithPageFactory() throws IOException
{
	
	System.out.println("PageFactory Object is initialized");
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@name='firstname']")
WebElement firstnamepf;
@FindBy(xpath="//input[@name='lastname']")
WebElement lastnamepf;
}
