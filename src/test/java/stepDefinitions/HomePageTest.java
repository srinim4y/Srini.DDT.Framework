package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageTest 
{
	
	WebDriver driver;
	String sourceProduct;
	
	@Given("I am in loggedin to the Application")
	public void i_am_in_loggedin_to_the_application() 
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@When("I add a product to the cart")
	public void i_add_a_product_to_the_cart() 
	{
		sourceProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
	    driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
	    driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	}
	
	@Then("validate the cart")
	public void validate_the_cart() 
	{
		String targetProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		System.out.println(sourceProduct);
		System.out.println(targetProduct);
		Assert.assertEquals(targetProduct, sourceProduct);
	    
	}

}
