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
import org.testng.annotations.Test;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class DD_AddingToCart_POMusingTestng {

	@Test
	public void tc_AddingToCart() throws IOException 
	{
		// TODO Auto-generated method stub
		FileUtility futil = new FileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		
		// Read data from Property file methods which are in Utility
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		String PRODUCT = futil.readDataFromExcel("Products", 1, 2);
		String FN = futil.readDataFromExcel("Products", 1, 3);
		String LN = futil.readDataFromExcel("Products", 1, 4);
		String ADDRESS = futil.readDataFromExcel("Products", 1, 5);
		
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
		
		
		wutil.maximizeWindow(driver);
		//wutil.implicitWait(driver, 10);
		wutil.pageToLoad(driver);
		
		
		driver.get(URL);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		LoginPage lp = new LoginPage(driver);
		
		//lp.getUsernameTF().sendKeys(USERNAME);
		//lp.getPasswordTF().sendKeys(PASSWORD);
		//lp.getLoginBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		
		CartPage cp = new CartPage(driver);
		
		
		//driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']")).click();
		
		hp.selectProduct(PRODUCT, driver);
		
		hp.getAddToCartBtn().click();
		
		hp.getCartLinkBtn().click();
		
		hp.getCheckoutBtn().click();
		/*
		 * driver.findElement(By.id("first-name")).sendKeys(FN);
		 * driver.findElement(By.id("last-name")).sendKeys(LN);
		 * driver.findElement(By.id("postal-code")).sendKeys(ADDRESS);
		 * driver.findElement(By.id("continue")).click();
		 * driver.findElement(By.id("finish")).click();
		 */
		
		/*
		 * cp.getFirstNameTF().sendKeys(FN); cp.getLastNameTF().sendKeys(LN);
		 * cp.getPostCodeTF().sendKeys(ADDRESS); cp.getContinuewBtn().click();
		 * cp.getFinishBtn().click();
		 */
		
		cp.customerDetails(FN, LN, ADDRESS);
		
		/*
		 * String b =
		 * driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).
		 * getText(); System.out.println(b);
		 * 
		 * if (b.equals("Thank you for your order!")) { System.out.println("TC Passed");
		 * } else { System.out.println("TC Failed"); }
		 */
		
		String validatetext = cp.validateProductAddition(driver);
		
		if (validatetext.equals("Thank you for your order!")) 
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
