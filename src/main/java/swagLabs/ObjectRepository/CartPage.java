package swagLabs.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	@FindBy(id = "first-name")
	private WebElement firstNameTF;
	
	@FindBy(id = "last-name")
	private WebElement lastNameTF;
	
	@FindBy(id = "postal-code")
	private WebElement postCodeTF;
	
	@FindBy(id = "continue")
	private WebElement continuewBtn;
	
	@FindBy(id = "finish")
	private WebElement finishBtn;
	
	@FindBy (xpath = "//div[@class='summary_total_label']")
	private WebElement totalSummaryFld;

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getFirstNameTF() {
		return firstNameTF;
	}



	public WebElement getLastNameTF() {
		return lastNameTF;
	}



	public WebElement getPostCodeTF() {
		return postCodeTF;
	}



	public WebElement getContinuewBtn() {
		return continuewBtn;
	}



	public WebElement getFinishBtn() {
		return finishBtn;
	}

	
	
	public WebElement getTotalSummaryFld() {
		return totalSummaryFld;
	}


	public void customerDetails(String FN, String LN, String ADDRESS)
	{
		firstNameTF.sendKeys(FN);
		lastNameTF.sendKeys(LN);
		postCodeTF.sendKeys(ADDRESS);
		continuewBtn.click();
		finishBtn.click();
	}
	
	public void customerDetailsAlone(String FN, String LN, String ADDRESS)
	{
		firstNameTF.sendKeys(FN);
		lastNameTF.sendKeys(LN);
		postCodeTF.sendKeys(ADDRESS);
		continuewBtn.click();
	}
	
	public String getTotalSummaryAmt()
	{
		String totalAmt = totalSummaryFld.getText();
		return totalAmt;
	}
	// or we can return the string as return type and have the if block in the other class where we are calling
	public String validateProductAddition(WebDriver driver)
	{
		String b = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']")).getText();
		
		
		return b;
	}
	
}
