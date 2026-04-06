package practice;

import java.time.Duration;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import swagLabs.GenericUtilities.WebDriverUtility;

public class SimpleJavaPrograms {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		/**
		 * Learning Foreach loop
		 */
		
		//String[] num = {"Srini", "Vas", "QA"};
		
		
		/*
		 * for (String x: num)
		 * {
		 *   System.out.println(x);
		 * }
		 */
		
		/*
		 * for (int x = 0; x<num.length; x++) { System.out.println(num[x]); }
		 */
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		WebDriverUtility util = new WebDriverUtility(); //by using utility method
		util.maximizeWindow(driver);
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Store']"));
		
		//Actions act = new Actions(driver);
		//ele.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		//Or - try below - by using utility method
		
		util.RightClickAndOpenNewTab(driver, ele); // for opening in new tab
		//util.RightClickAndOpenNewWindow(driver, ele); - for opening in new window
		
		String parentID = driver.getWindowHandle();
		System.out.println(parentID);
		
		util.waitUntilWindowsToLoad(driver, 2);
		
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String id : windowIds)
		{
			if(!id.equals(parentID))
			{
				driver.switchTo().window(id);
				String title = driver.getTitle();
				System.out.println(title);
				
			}
						
		}
		
		driver.quit();
		
	}

}
