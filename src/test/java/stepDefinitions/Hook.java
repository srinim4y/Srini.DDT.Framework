package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import swagLabs.BaseTest.BaseBDD;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;

public class Hook 
{
	//fetch driver from BaseBDD class
	//Dependency Injection - Cucumber Pico container
	
	private BaseBDD base;
	
	//capture the driver from BaseBDD class
	
	public Hook(BaseBDD base)
	{
		this.base = base;
	}
	
	//Create Objects of Utilities
	
	FileUtility fUtil = new FileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	@Before
	public void SetUp() throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Launch the browser
		base.driver = new EdgeDriver();
		
		wUtil.maximizeWindow(base.driver);
		wUtil.pageToLoad(base.driver);
		
		base.driver.get(URL);
		
		System.out.println("Browser launched");
		//Login to Application
		
		LoginPage lp = new LoginPage(base.driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("Logged into app");
		
		
	}
	
	@After
    public void tearDown(Scenario scenario ) throws IOException
    {
    	if(scenario.isFailed())
    	{
    		//Capture the Screenshot in Byte[] format
    		TakesScreenshot ts = (TakesScreenshot) base.driver;
    		byte[] screensht = ts.getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screensht, "image/png", scenario.getName());
    		
    		//Store it in folder
    		wUtil.captureScreenshot(base.driver, scenario.getName());
    	}
    	
    	
    	//logout of application
    	base.driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
    	base.driver.findElement(By.id("logout_sidebar_link")).click();
  
    	System.out.println("Logout successful");
    	
    	//Close browser
    	base.driver.quit();
    	
    	System.out.println("browser closed");
    }

}
