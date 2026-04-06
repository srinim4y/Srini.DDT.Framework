package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TC_05 {

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
		
		driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		
		String s = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		System.out.println("The desired text is:" + s);
		 
		if(!s.equals("0"))
		{
			System.out.println("test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		
		driver.quit();
	}

}
