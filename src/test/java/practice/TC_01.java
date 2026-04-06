package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_01 {

	public static void main(String[] args) 
	
	{
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		
		  boolean tc = driver.findElement(By.id("checkout")).isDisplayed();
		  
		  if(tc) 
		  {
			  
			 System.out.println("Test case passed"); 
		  }
		  else 
		  {
			  
		  System.out.println("Test case failed"); 
		  
		 }
		  
		  driver.quit();
		 
	}

}
