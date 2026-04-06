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

public class DD_TC2_AddingToCart {

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
		String FN = wb.getSheet("Products").getRow(1).getCell(3).getStringCellValue();
		String LN = wb.getSheet("Products").getRow(1).getCell(4).getStringCellValue();
		String ADDRESS = wb.getSheet("Products").getRow(1).getCell(5).getStringCellValue();
		
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		if (BROWSER.equalsIgnoreCase("edge"))
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
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys(FN);
		driver.findElement(By.id("last-name")).sendKeys(LN);
		driver.findElement(By.id("postal-code")).sendKeys(ADDRESS);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		String b = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		System.out.println(b);
		
		if (b.equals("Thank you for your order!"))
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Failed");
		}
		
		driver.quit();
		
	}

}
