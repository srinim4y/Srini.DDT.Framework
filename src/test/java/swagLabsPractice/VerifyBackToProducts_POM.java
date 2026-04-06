package swagLabsPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class VerifyBackToProducts_POM {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		FileUtility futil = new FileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		
		
		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else
		{
			driver = new EdgeDriver();
		}
		
		wutil.maximizeWindow(driver);
		wutil.pageToLoad(driver);
		
		driver.get(URL);
		
		String PRODUCT = futil.readDataFromExcel("Products", 1, 2);
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		
		hp.selectProduct(PRODUCT, driver);
		
		
		boolean c = hp.getBackToProductBtn().isDisplayed();
		
		System.out.println(c);
		
		if(c)
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
