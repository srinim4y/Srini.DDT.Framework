package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_04 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		
		boolean c = driver.findElement(By.id("back-to-products")).isDisplayed();
		
		System.out.println(c);
		
		if(c)
		{
			System.out.println("TC Passed");
		}
		
		else
		{
			System.out.println("TC Failed");
		}
		
		driver.close();
	}

}
