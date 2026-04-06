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

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;

public class DD_TC01_UsingUtility {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		FileUtility futil = new FileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		
		// Read data from Property file methods which are in Utility
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		// Read data from Excel file methods which are in Utility
		
		
		String PRODUCT = futil.readDataFromExcel("Products", 1, 2);
		
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
		
		wutil.maximizeWindow(driver);
		//wutil.implicitWait(driver, 10);
		wutil.pageToLoad(driver);
		
		
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
