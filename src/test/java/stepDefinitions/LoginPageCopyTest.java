package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageCopyTest 
{
	WebDriver driver;
	@Given("I want to launch the browserApp")
	public void i_want_to_launch_the_browser_app() 
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Given("enter the URL as {string}")
	public void enter_the_url_as(String url) 
	{
	 
		driver.get(url);
	}
	
	@When("Login page is displayed enter username as {string}")
	public void login_page_is_displayed_enter_username_as(String username) 
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
	}
	
	@When("enter the password as {string}")
	public void enter_the_password_as(String password) 
	{
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	@When("click on login button field")
	public void click_on_login_button_field() 
	{
		driver.findElement(By.id("login-button")).click();
	}
	
	@Then("validate the homepageApp")
	public void validate_the_homepage_app() 
	{
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(actualURL.contains("inventory"));
		System.out.println("Success");
	}	
	
	
	//Login with multiple data sets
	
	
	@When("Login page is displayed provide username as {string}")
	public void login_page_is_displayed_provide_username_as(String Username) {
		driver.findElement(By.id("user-name")).sendKeys(Username);
	}

	@When("provide password as {string}")
	public void provide_password_as(String Password) {
		driver.findElement(By.id("password")).sendKeys(Password);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("I validate for the Home Page")
	public void i_validate_for_the_home_page() {
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(actualURL.contains("inventory"));
		System.out.println("Success");
	}
	
}
