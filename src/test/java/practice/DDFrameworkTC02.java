package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

public class DDFrameworkTC02 {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
	
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		
		String PRODUCT = wb.getSheet("Products").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']")).click();
		
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		String actResult = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		System.out.println(PRODUCT);
		System.out.println(actResult);
		
		Assert.assertTrue(actResult.equalsIgnoreCase(PRODUCT));
		
		if(actResult == PRODUCT)
		{
			System.out.println("TC Passed");
		}
		else 
		{
			System.out.println("TC Failed");
		}
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		driver.quit();
		
	}

}
