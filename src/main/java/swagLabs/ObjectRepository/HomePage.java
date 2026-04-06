package swagLabs.ObjectRepository;

import java.security.PrivateKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Dynamic xpaths cannot be handled by POM class
	
	//@FindBy(xpath = "//div[text()='"+PRODUCT+"']")
	//private WebElement productName;
	
	@FindBy (id = "back-to-products")
	private WebElement backToProductBtn;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cartLinkBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id = "add-to-cart")
	private WebElement addToCartBtn;
	
	@FindBy (xpath = "//select[@class='product_sort_container']")
	private WebElement dropdownFld;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}


	public WebElement getCartLinkBtn() {
		return cartLinkBtn;
	}
	
	
	
	public WebElement getBackToProductBtn() {
		return backToProductBtn;
	}


	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}


	public WebElement getDropdownFld() {
		return dropdownFld;
	}


	public void selectProduct(String PRODUCT, WebDriver driver)
	{
		driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']")).click();
		
	}
	
	public String getProductText(String PRODUCT, WebDriver driver)
	{
		String productValue = driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']")).getText();
		return productValue;
		
	}
	
	public boolean isProductAvailable(String PRODUCT, WebDriver driver)
	{
		boolean b = driver.findElement(By.xpath("//div[text()='"+PRODUCT+"']")).isDisplayed();
		return b;
		
		
	}

}
