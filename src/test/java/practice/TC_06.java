package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_06 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub


		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		String con1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
		System.out.println(con1);
		
		
		driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).click();
		
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		boolean d = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).isDisplayed();
		System.out.println(d);
		
		String con2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']")).getText();
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
