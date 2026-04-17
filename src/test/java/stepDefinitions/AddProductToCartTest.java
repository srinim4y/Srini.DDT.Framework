package stepDefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swagLabs.BaseTest.BaseBDD;

public class AddProductToCartTest 
{
	private BaseBDD base;
	public AddProductToCartTest(BaseBDD base)
	{
		this.base=base;
	}
	
	
	//Scenario 1
	@When("Click on product {string}")
	public void click_on_product(String string) {
		
		base.driver.findElement(By.xpath("//div[.='"+string+"']")).click();
	   
	}
	@When("click on add to cart button")
	public void click_on_add_to_cart_button() {
	   
		base.driver.findElement(By.name("add-to-cart")).click();
	}
	@Then("I validate product {string} in cart page")
	public void i_validate_product_in_cart_page(String string) {
	    
		System.out.println("Product Added To cart");
	}
	
	//Scenario 2
	@When("Click on the product {string}")
	public void click_on_the_product(String string) {
	    
	}
	@When("click on the add to cart button")
	public void click_on_the_add_to_cart_button() {
	   
	}
	@When("Navigate to Cart Page")
	public void navigate_to_cart_page() {
	   
	}
	@Then("Click on Checkout")
	public void click_on_checkout() {
	    
	}

}
