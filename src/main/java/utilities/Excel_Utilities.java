package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utilities {
	
	private static File srcFile;
	private static  FileInputStream fis;
	private static Workbook wb;
	private static Sheet sh;
	
	
	public static void readExcelFile() throws IOException
	{
		srcFile  = new File("src/main/resources/TestData.xlsx");
		
		fis = new FileInputStream(srcFile);
		
		wb = new XSSFWorkbook(fis);
		
		fis.close();
			
	}
	
	/*public static String readDataFromSheets(String sheet, int row, int col)
	{
		sh= wb.getSheet(sheet);
		
		String data = sh.getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
	}*/
	
	public static boolean isTestCasePresent(String TestCaseName) throws IOException
	{
		srcFile  = new File("src/main/resources/TestData.xlsx");
		fis = new FileInputStream(srcFile);
		
		wb = new XSSFWorkbook(fis);
		sh= wb.getSheet("Modules");
		
		int totalRows = sh.getPhysicalNumberOfRows();
		int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(totalColumns);
		
		
		for(int i=1;i<totalRows;i++)
		{
			if(sh.getRow(i).getCell(0).getStringCellValue().equals(TestCaseName))
			{
				if(sh.getRow(i).getCell(1).getStringCellValue().equals("Y"))
				{
					return true;
					
				}
			}
		}
		return false;
		
		
	}
	
	public static Object[][] readDataFromSheets()
	{
		sh= wb.getSheet("LoginTest");
		
		int rows = sh.getPhysicalNumberOfRows();
		int cols = sh.getRow(0).getPhysicalNumberOfCells();
		
		Object arr[][] = new Object[rows-1][cols];
		
		for(int i=1; i<rows; i++)
		{
			for(int j=0;j<cols;j++)
			{
				arr[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println("array is: "+arr);
			}
			
		}
		return arr;
	}

}
