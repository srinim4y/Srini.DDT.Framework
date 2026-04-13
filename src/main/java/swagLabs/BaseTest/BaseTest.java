package swagLabs.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.JavaUtilities;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of TestNG
 */
public class BaseTest 
{
	
	public JavaUtilities jUtil = new JavaUtilities();
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	
	//For Listeners - here in this case to capture screenehot
	public static WebDriver sDriver;
	
	@BeforeSuite (alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("====DB connection successful===");
	}
	//@BeforeTest // This is for parallel execution @Before class is for sequential execution
	@BeforeClass (alwaysRun = true)
	public void bcConfig() throws IOException
	{
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
			
			// Enable Incognito mode and avoid any google password alerts
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        options.addArguments("--disable-features=PasswordLeakDetection");

	        driver = new ChromeDriver(options);
	        
			
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		
		wUtil.maximizeWindow(driver);

		wUtil.pageToLoad(driver);
		
		driver.get(URL);
		
		System.out.println("Browser Launch is successful");
		
		// For Listeners - here in this case for capturing screenshot
		sDriver = driver;
		
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public void bmConfig() throws IOException
	{
		
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		
		System.out.println("Login to App is successful");
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void amConfig()
	{
		
		InventoryPage ip = new InventoryPage(driver);
		ip.getMenuBtn().click();
		ip.getLogoutBtn().click();
		
		System.out.println("Logout of App is successful");
	}
	
	//@AfterTest
	@AfterClass (alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser quit is successful");
	
	}
	@AfterSuite (alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====DB Closure successful===");
	
	}
}
