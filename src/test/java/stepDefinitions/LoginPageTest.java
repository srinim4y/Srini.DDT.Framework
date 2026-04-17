package stepDefinitions;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest 
{
	WebDriver driver;
	
	//Fetch the methods from feature file - using dryRUN = true
	
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() 
	{
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("enter the URL")
	public void enter_the_url() 
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	@When("Login page is displayed enter username and password")
	public void login_page_is_displayed_enter_username_and_password() 
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	@When("click on login button")
	public void click_on_login_button() 
	{
		driver.findElement(By.id("login-button")).click();
	}
	
	@Then("validate the homepage")
	public void validate_the_homepage() 
	{
		
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(actualURL.contains("inventory"));
		System.out.println("Success");
		
	    // the below line of code is auto generated after the methods generated from runner class with dryRun='false'
	    //throw new io.cucumber.java.PendingException();
	}

}
