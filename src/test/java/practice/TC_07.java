package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_07 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Browser Launch
		WebDriver driver = new EdgeDriver();
		
		//Get the URL
		driver.get("https://www.saucedemo.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		
		//Login to the Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		//Sorting the products
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (low to high)");
		
		//Closing the browser
		driver.quit();
	}

}
