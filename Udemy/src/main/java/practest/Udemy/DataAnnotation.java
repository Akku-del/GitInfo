package practest.Udemy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataAnnotation {
	
	@Test
	public void priorityOne()
	{
		System.out.println("Priority is set to 1");
	}

	@Test(enabled=true, priority=0)
	public void gestDisabled()
	{
		System.out.println("test case is disabled");
	}

	@Test(dependsOnMethods= {"grouping"})
	public void priorityReset()
	{
		System.out.println("Priority is set to 0");
	}
	
	@Test(groups = {"Cars","Sedan"})
	public void grouping()
	{
		System.out.println("Batch Sedan Car - Test sedan 1");
	}
	
	@Test(dataProvider="getExcelData")
	public void setData(String username, String password)
	{
		System.out.println("you have provided username as::"+username);
		System.out.println("you have provided password as::"+password);
	}

	@DataProvider
	public Object[][] getExcelData() throws IOException {
		FileInputStream fs=new FileInputStream("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\resources\\Akku.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet ws=wb.getSheetAt(0);
		XSSFRow wr;
		XSSFCell wc;
		
		int trows= ws.getLastRowNum();
		System.out.println(""+trows);
		
		Object[][] data = new Object[trows+1][2];
		
		for(int i=0;i<=trows;i++)
		{
			for (int j=0;j<=1;j++)
			{ 
				wc=ws.getRow(i).getCell(j);
				CellType type=ws.getRow(i).getCell(j).getCellType();
				if (CellType.STRING == type )
				{
					System.out.println("CellType:" + type.toString());
				data[i][j]=ws.getRow(i).getCell(j).getStringCellValue();
				}
				else if (CellType.NUMERIC == type )
				{
					if(DateUtil.isCellDateFormatted(wc))
					{
						System.out.println("CellType:" + type.toString());
						SimpleDateFormat ft= new SimpleDateFormat("yyyyMMdd");
						Date d=ws.getRow(i).getCell(j).getDateCellValue();
						System.out.println("Display:");
						data[i][j]=ft.format(d);
					    break;
					}
				data[i][j]=ws.getRow(i).getCell(j).getNumericCellValue();
				System.out.println("CellType:" + type.toString());
				System.out.println("tester");
				System.out.println("tester:1");
				}
			}
		}
		return data;
	}
}
