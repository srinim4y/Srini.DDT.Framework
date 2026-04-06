package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet("Products");
		
		int rowcount = s.getLastRowNum();
		
		
		for (int i=0; i<=rowcount; i++)
		{
			Row r = s.getRow(i);
			
			int columncount = r.getLastCellNum();
			for(int j=0; j<columncount; j++)
			{
				Cell c = r.getCell(j);
				
				String value = c.getStringCellValue();
				System.out.print(value + " ");
			}
			System.out.println();
			
		}
		
	}

}
