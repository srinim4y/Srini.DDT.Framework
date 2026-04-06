package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class ApplyingDataDrivenApproach {

	public static void main(String[] args) throws SQLException, IOException 
	{
			
		FileInputStream fis = new FileInputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String url = p.getProperty("testurl");
		
		String un = p.getProperty("usernm");
		String pw = p.getProperty("pwd");
		
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Create a Virtual workbook using WorkbookFactory (Class)
		Workbook wb = WorkbookFactory.create(fs);
		
		//Navigate to required Sheet
		Sheet sh = wb.getSheet("Products");
		
		//Navigate to required row
		Row rw = sh.getRow(3);
		
		//Navigate to required cell
		Cell c = rw.getCell(2);
		
		//Capture the data and print
		
		String val = c.getStringCellValue();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(pw);
		
		driver.findElement(By.id("login-button")).click();
		
		//WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		//Select select = new Select(dropdown);
		//select.selectByVisibleText("Price (low to high)");  --- approach1
		//select.selectByIndex(1); --- approach2
		//select.selectByValue("lohi"); --- approach3
		
		
		WebElement w = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		
		
		Select dropdown = new Select(w);
		dropdown.selectByVisibleText(val);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Test");
		driver.findElement(By.id("last-name")).sendKeys("Test");
		driver.findElement(By.id("postal-code")).sendKeys("Test");
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("finish")).click();
		
		
		
		
		/*
		 * List<WebElement> ele = driver.findElements(By.xpath(
		 * "//select[@class='product_sort_container']//option"));
		 * 
		 * for(WebElement wb1: ele) { if(wb1.getText().equals(val)) {
		 * System.out.println(wb1.getText()); wb1.click(); //break; } }
		 */
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
