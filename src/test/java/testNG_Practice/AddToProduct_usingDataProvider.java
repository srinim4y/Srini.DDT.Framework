package testNG_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseTest;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.InventoryPage;

public class AddToProduct_usingDataProvider extends BaseTest
{
	@Test(dataProvider = "Product")
	public void tc_01_AddProductToCartTest(String PRODUCTNAME) throws IOException	
	{
		// Read all the required Data
		//String PRODUCT = fUtil.readDataFromExcel("Products", 1, 2);

		// Step 3: Click on product - ProductName from excel
				
		
		// Step 3: Click on product - ProductName from excel
		HomePage hp = new HomePage(driver);
		
		CartPage cp = new CartPage(driver);	
		
		
		hp.selectProduct(PRODUCTNAME, driver);
		
		hp.getAddToCartBtn().click();
		
		hp.getCartLinkBtn().click();
		
		hp.getCheckoutBtn().click();
		

		//Step 7 Validation
//		if(productAdded.equals(productInCart))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		
	
	

	}
	
	@DataProvider(name = "Product")
	public Object[][] getProduct() throws EncryptedDocumentException, IOException
	{
		return fUtil.readMultipledata("MultipleProducts");
	}

}
