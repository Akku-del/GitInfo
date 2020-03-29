package practest.Udemy;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnection
{
    static FileInputStream fs=null;
    static FileOutputStream fo=null;
	static XSSFWorkbook wsBook=null;
	static XSSFSheet wsheet=null;
	
	   static int initialrow=0;
	   static int finalrow=0;
	   static int firstcolumn=0;
	   static int lastcolumn=0;
	   static XSSFCell icell=null;
	   static CellType type = null;
	   static double iValue=0.0;
	   static Object iString=null;
	   
 public static void main(String[] args) throws Exception
 {
	
	 fs=new FileInputStream("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\resources\\Akku.xlsx");
	 wsBook=new XSSFWorkbook(fs);
	 wsheet=wsBook.getSheet("Detail");
	 initialrow=wsheet.getFirstRowNum();
	
	 finalrow=wsheet.getLastRowNum();
	 firstcolumn=wsheet.getRow(0).getFirstCellNum();
	 lastcolumn=wsheet.getRow(0).getLastCellNum();
	for(int i=initialrow;i<=finalrow;i++)
	{
		for(int j=firstcolumn;j<=lastcolumn;j++)
		{
			MissingCellPolicy policy=Row.MissingCellPolicy.RETURN_BLANK_AS_NULL;
			icell=wsheet.getRow(i).getCell(j,policy);
			
			if(icell!=null)
			 {
			   type=wsheet.getRow(i).getCell(j).getCellType();
			   if(type==CellType.NUMERIC)
			     {
				   if(DateUtil.isCellDateFormatted(icell))
				   {
					   iString=wsheet.getRow(i).getCell(j).getDateCellValue();
					   System.out.println("Numeric Cell Type:"+iString.toString());
				   }
				   else
				   {
				   iValue=wsheet.getRow(i).getCell(j).getNumericCellValue();
				   System.out.println("Numeric Cell Type:"+iValue);
				   }
			     }
			   else if(type==CellType.STRING)
			     {
				iString= wsheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("String Cell Type:"+iString.toString());
			     }
		}
			else if(icell==null)
			{
			CellType itype=CellType.STRING;
			wsheet.getRow(i).createCell(j).setCellValue("Akash");
			wsheet.getRow(i).getCell(j).getCellType().toString();
			}
		}
	}
	fo=new FileOutputStream("C:\\Users\\Nidhi Gupta\\git\\flash\\Udemy\\resources\\Akku.xlsx");
	wsBook.write(fo);
	fo.flush();
 }
 
}