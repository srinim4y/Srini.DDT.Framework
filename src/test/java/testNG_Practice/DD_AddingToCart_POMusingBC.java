package testNG_Practice;

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

import swagLabs.BaseTest.BaseTest;
import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class DD_AddingToCart_POMusingBC extends BaseTest{

	@Test
	public void tc_AddingToCart() throws IOException 
	{
		// TODO Auto-generated method stub
		
		String PRODUCT = fUtil.readDataFromExcel("Products", 1, 2);
		String FN = fUtil.readDataFromExcel("Products", 1, 3);
		String LN = fUtil.readDataFromExcel("Products", 1, 4);
		String ADDRESS = fUtil.readDataFromExcel("Products", 1, 5);
		
				
		HomePage hp = new HomePage(driver);
		
		CartPage cp = new CartPage(driver);		
		
		
		hp.selectProduct(PRODUCT, driver);
		
		hp.getAddToCartBtn().click();
		
		hp.getCartLinkBtn().click();
		
		hp.getCheckoutBtn().click();
		
		cp.customerDetails(FN, LN, ADDRESS);
		
		
		String validatetext = cp.validateProductAddition(driver);
		
		if (validatetext.equals("Thank you for your order!")) 
		{
			System.out.println("TC Passed");
		 
		}
		else
		{
			System.out.println("TC Failed");
		}
		
		
	}

}
