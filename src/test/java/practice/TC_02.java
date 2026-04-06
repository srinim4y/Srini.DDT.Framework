package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_02 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		
		
		
		driver.findElement(By.id("continue-shopping")).click();
		
		String a = driver.getCurrentUrl();
		
		System.out.println(a);
		
		if (a.equalsIgnoreCase("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("TC Passed");
		}
		else
		{
			System.out.println("TC Failed");
		}
		
	}

}
