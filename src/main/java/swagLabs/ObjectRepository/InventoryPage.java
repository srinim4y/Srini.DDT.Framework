package swagLabs.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage 
{
	
	@FindBy (xpath = "//button[text()='Open Menu']")
	private WebElement menuBtn;
	
	@FindBy (id = "logout_sidebar_link")
	private WebElement logoutBtn;

	
	public InventoryPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getMenuBtn() {
		return menuBtn;
	}


	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	
	
}
