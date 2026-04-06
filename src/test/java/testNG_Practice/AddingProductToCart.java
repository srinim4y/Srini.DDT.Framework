package testNG_Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.LoginPage;


public class AddingProductToCart 
{
	
	
	@Test (dataProvider = "getProductTest")
	public void addToCartTest(String PRODUCT) throws IOException
	{
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		
		FileUtility fu = new FileUtility();
		String USERNAME = fu.readDataFromPropertyFile("username");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		WebElement product = driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']"));
		product.click();
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getProductTest()
	{
		Object[][] productname = new Object[2][1];
		productname[0][0] = "Sauce Labs Backpack";
		productname[1][0] = "Sauce Labs Bike Light";
		
		return productname;
	}
	

}
