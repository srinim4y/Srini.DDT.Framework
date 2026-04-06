package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// TODO Auto-generated method stub
		
		
		//Open the document in Java read format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Create a Virtual workbook using WorkbookFactory (Class)
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to required Sheet
		Sheet sh = wb.getSheet("Products");
		
		//Navigate to required row
		Row rw = sh.getRow(1);
		
		//Navigate to required cell
		Cell c = rw.getCell(2);
		
		//Capture the data and print
		
		String value = c.getStringCellValue();
		System.out.println(value);
	}

}
