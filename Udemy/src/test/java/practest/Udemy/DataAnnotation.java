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
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="sampleuser1";
	data[0][1] = "abcdef";
	
	// 2nd row
		data[1][0] ="testuser2";
		data[1][1] = "zxcvb";
		
		// 3rd row
		data[2][0] ="guestuser3";
		data[2][1] = "pass123";

		return data;
		}
	/*
	@BeforeMethod
	 
	 public void beforeMethod() {
	 
	 System.out.println("This will execute before every Method");
	 
	 }
	 
	 @AfterMethod
	 
	 public void afterMethod() {
	 
	 System.out.println("This will execute after every Method");
	 
	 }
	 
	 @BeforeClass
	 
	 public void beforeClass() {
	 
	 System.out.println("This will execute before the Class");
	 
	 }
	 
	 @AfterClass
	 
	 public void afterClass() {
	 
	 System.out.println("This will execute after the Class");
	 
	 }
	 
	 @BeforeTest
	 
	 public void beforeTest() {
	 
	 System.out.println("This will execute before the Test");
	 
	 }
	 
	 @AfterTest
	 
	 public void afterTest() {
	 
	 System.out.println("This will execute after the Test");
	 
	 }
	 
	 @BeforeSuite
	 
	 public void beforeSuite() {
	 
	 System.out.println("This will execute before the Test Suite");
	 
	 }
	 
	 @AfterSuite
	 public void afterSuite() {
		 
		 System.out.println("This will execute after the Test Suite");
		 
		 }
		 */
	
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
				System.out.println("");
				}
			}
		}
		return data;
	}
}
