package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtility {

	Object object[][];
	FileInputStream fis;
	XSSFWorkbook workbook;
	public Object[][] getExcelData(String path,String sheetname) throws IOException {
		// TODO Auto-generated constructor stub
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int rowCount = sheet.getLastRowNum();
			System.out.println("Rowcount : "+rowCount);
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println("columncount : "+columnCount);
			object= new Object[rowCount][columnCount];
			for(int row =1; row<=rowCount; row++)
			{
				for(int column=0; column<columnCount;column++ )
				{
					
					object[row-1][column] = sheet.getRow(row).getCell(column).getStringCellValue();
				}
				
			}
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		  if(workbook !=null)
		  {workbook.close();}
		  if(fis!=null)
		  {fis.close();}
		  
		}
		
		return object;
	}
}
