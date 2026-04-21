package testNG_Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swagLabs.GenericUtilities.FileUtility;

public class DatProviderTest 
{
	
	
	@Test (dataProvider = "getProductDetails") // Or @Test (dataProvider = "Products")
	public void addProductTest(String name, int quantity, boolean availability)
	{
		System.out.println("Data is " +name+ "," +quantity+ "," + availability);
	}
	
	// Or @DataProvider (name = "Products")// - call this name in the above @test method instead of method name
	@DataProvider
	public Object[][] getProductDetails()
	{
		Object[] [] data = new Object[2] [3]; // 2 sets of data having 3 information each
		data[0][0] = "iPhone";
		data[0][1] = 10;
		data[0][2] = true;
		
		data[1][0] = "Samsung";
		data[1][1] = 5;
		data[1][2] = false;
		return data;
		
	}
	
	@Test(dataProvider = "SauceLabs Products")
	public void addProductToCartTest(String name)
	{                                    
		
		System.out.println("Data is - "+name);
	}
	
	@DataProvider(name = "SauceLabs Products")
	public Object[][] getProdNames() throws EncryptedDocumentException, IOException
	{
		FileUtility fUtil = new FileUtility();
		return fUtil.readMultipledata("MultipleProducts");
	}
	
}
