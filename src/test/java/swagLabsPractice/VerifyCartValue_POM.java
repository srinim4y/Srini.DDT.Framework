package swagLabsPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class VerifyCartValue_POM {

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
		
		wutil.getURL(driver, URL);		
		wutil.maximizeWindow(driver);
		wutil.pageToLoad(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		String PRODUCT = futil.readDataFromExcel("Products", 1, 2);
		String FN = futil.readDataFromExcel("Products", 1, 3);
		String LN = futil.readDataFromExcel("Products", 1, 4);
		String ADDRESS = futil.readDataFromExcel("Products", 1, 5);
		
		HomePage hp = new HomePage(driver);
		hp.selectProduct(PRODUCT, driver);
		
		hp.getAddToCartBtn().click();
		hp.getCartLinkBtn().click();
		
		hp.getCheckoutBtn().click();
		CartPage cp = new CartPage(driver);
		
		cp.customerDetailsAlone(FN, LN, ADDRESS);
		
		
		String amt = cp.getTotalSummaryAmt();
		System.out.println("The desired text is:" + amt);
		 
		if(!amt.equals("0"))
		{
			System.out.println("test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		driver.quit();
	}

}
