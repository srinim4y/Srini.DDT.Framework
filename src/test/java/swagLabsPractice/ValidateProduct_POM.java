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

public class ValidateProduct_POM {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		FileUtility futil = new FileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL = futil.readDataFromPropertyFile("url");

		String PRODUCT = futil.readDataFromExcel("Products", 1, 2);
		
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.pageToLoad(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		String con1 = hp.getProductText(PRODUCT, driver);
		System.out.println(con1);
		
		
		hp.selectProduct(PRODUCT, driver);
		
		hp.getAddToCartBtn().click();
		
		hp.getCartLinkBtn().click();
		
		boolean wb = hp.isProductAvailable(PRODUCT, driver);
		System.out.println(wb);
		
		String con2 = hp.getProductText(PRODUCT, driver);
		System.out.println(con2);
		
		if(con1.equals(con2))
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
