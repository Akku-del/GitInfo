package practest.Udemy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends Base {

	public void captureSS()
	{
		TakesScreenshot scr= (TakesScreenshot) driver;
		File srcFile=scr.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sd=new SimpleDateFormat("yyyyMMddhhmmss");
		Date currentDate =new Date();
		String dest= "C:\\Users\\Nidhi Gupta\\Downloads\\Screenshots\\" + sd.format(currentDate) + ".png";
		File destFile =new File(dest);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
