package swagLabs.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //rule 1 - class name should ends with Page
{
	//Rule 2 // Access the webelement using @FindBy annotation and make them private
	@FindBy(xpath = "//input[@name='user-name']")
	private WebElement usernameTF; // Since the data type (returns) is webelement and usernameTF means firstname is a Textfield - for better understanding to use the naming convention like this
	
	@FindBy(id = "password")
	private WebElement passwordTF;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3 // Initialize the webelements using the constructor class
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 // provide getter methods to access the private variables
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5 = Busines library = for code optimization
	public void loginToApp(String username, String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
	}
	
}
