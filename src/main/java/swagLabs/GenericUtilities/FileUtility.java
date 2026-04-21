package swagLabs.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * This class consists of generic methods of File operations
 * @author srini
 * 
 */
public class FileUtility 
{
	
	/**
	 * This method reads data from properties file and returns to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This method reads data from Json file and returns to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String readDataFromJsonFile(Object key) throws IOException, ParseException
	{
		FileReader fr = new FileReader(".\\src\\test\\resources\\CommonData.json");
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(fr);
		
		JSONObject jobj = (JSONObject) obj;
		
		String value = jobj.get(key).toString();
		return value;
	}
	
	/**
	 * This method will read data from Excel file using row and cell indexing and returns the value
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}

	/**
	 * This method will read multiple data from Excel and provide it to dataprovider
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipledata(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    
	    int lastRow = wb.getSheet(sheetname).getLastRowNum();
	    int lastcell = wb.getSheet(sheetname).getRow(0).getLastCellNum();
	  
	    Object[][] data = new Object[lastRow][lastcell];
	    
		for(int i=0; i<lastRow ;i++)
	    {
	    	for(int j=0;j<lastcell;j++)
	    	{
	    		data[i][j] = wb.getSheet(sheetname).getRow(i+1).getCell(j).getStringCellValue();
	    	}
	    }
	    
	    return data;
	}
	
}
