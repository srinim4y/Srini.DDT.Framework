package practice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


public class DDApproachWithJson {

	public static void main(String[] args) throws IOException, ParseException 
	{
		// TODO Auto-generated method stub
		
		FileReader fr =new FileReader(".\\src\\test\\resources\\CommonData.json");
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(fr);
		
		JSONObject jobj = (JSONObject) obj;
		
		String url = jobj.get("url").toString();
		String username = jobj.get("username").toString();
		String password = jobj.get("password").toString();
		
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet s = wb.getSheet("Products");
		
		Row rw = s.getRow(3);
		Cell c = rw.getCell(2);
		
		String value = c.getStringCellValue();
		
		System.out.println(value);
		
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("login-button")).click();
		
		WebElement ele = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		
		Select sel = new Select(ele);
		
		sel.selectByVisibleText(value);
		
		driver.quit();
		
		
	}

}
