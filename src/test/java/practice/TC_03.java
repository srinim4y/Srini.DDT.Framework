package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_03 {

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
		
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Srini");
		driver.findElement(By.id("last-name")).sendKeys("Vas");
		driver.findElement(By.id("postal-code")).sendKeys("600089");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		String b = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		System.out.println(b);
		
		if (b.equals("Thank you for your order!"))
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
