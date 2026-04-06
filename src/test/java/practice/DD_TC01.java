package practice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DD_TC01 {

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
		
		String PRODUCT = wb.getSheet("PRODUCTS").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
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
		driver.findElement(By.className("shopping_cart_link")).click();
		
		
		  boolean tc = driver.findElement(By.id("checkout")).isDisplayed();
		  
		  if(tc) 
		  {
			  
			 System.out.println("Test case passed"); 
		  }
		  else 
		  {
			  
		  System.out.println("Test case failed"); 
		  
		 }
		  
		  driver.quit();		
		
		
	}

}
