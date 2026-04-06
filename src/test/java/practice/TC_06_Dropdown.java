package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_06_Dropdown {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		//WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		//Select select = new Select(dropdown);
		//select.selectByVisibleText("Price (low to high)");  --- approach1
		//select.selectByIndex(1); --- approach2
		//select.selectByValue("lohi"); --- approach3
		
		
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//select[@class='product_sort_container']//option"));
		
		for(WebElement wb: ele)
		{
			if(wb.getText().equals("Price (low to high)"))
			{
				System.out.println(wb.getText());
				wb.click();
				//break;
			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.close();
	}

}
