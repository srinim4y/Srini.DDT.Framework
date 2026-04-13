package testNG_Practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseTest;
import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class ValidateProduct_POMusingBC extends BaseTest{

	@Test
	public void validateProduct() throws IOException 
	{
		// TODO Auto-generated method stub

		
		String PRODUCT = fUtil.readDataFromExcel("Products", 1, 2);
		
		
		
		HomePage hp = new HomePage(driver);
		String con1 = hp.getProductText(PRODUCT, driver);
		System.out.println(con1);
		
		
		hp.selectProduct(PRODUCT, driver);
		
		hp.getAddToCartBtn().click();
		
		hp.getCartLinkBtn().click();
		
		boolean wb = hp.isProductAvailable(PRODUCT, driver);
		//System.out.println(wb);
		
		String con2 = hp.getProductText(PRODUCT, driver);
		//System.out.println(con2);
		
		/*
		 * if(con1.equals(con2)) { System.out.println("TC Passed"); } else {
		 * System.out.println("TC Failed"); }
		 */
		
		assertEquals(con2, con1);
		 //or
		//assertTrue(con1.equals(con2));
		
		
	}

}
