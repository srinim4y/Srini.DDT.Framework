package swagLabsPractice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.HomePage;
import swagLabs.ObjectRepository.LoginPage;

public class AddFromDropdown_POM {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		FileUtility futil = new FileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String BROWSER = futil.readDataFromPropertyFile("browser");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		String URL = futil.readDataFromPropertyFile("url");
		
		
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.get(URL);
		
		wutil.maximizeWindow(driver);
		wutil.pageToLoad(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);		
		
		HomePage hp = new HomePage(driver);
		hp.getDropdownFld().click();
		
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
				
		driver.quit();
	}

}
