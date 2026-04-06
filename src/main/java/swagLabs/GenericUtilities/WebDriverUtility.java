package swagLabs.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v143.page.model.Screenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		
		driver.manage().window().maximize();		
		
	}
	
	/**
	 * This method will get the URL load
	 * @param driver
	 * @param URL
	 * @return
	 */
	public String getURL(WebDriver driver, String URL)
	{
		driver.get(URL);
		return URL;
	}
	
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This method will enlarge the screen
	 * @param driver
	 */
	public void fullScreen(WebDriver driver)
	{
		
		driver.manage().window().fullscreen();
		
	}
	
	/**
	 * This method will make the driver wait for sometime frame before throw exception and it applies for all the elements in the webpage
	 * @param driver
	 * @param seconds
	 */
	public void implicitWait(WebDriver driver, int seconds)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	/*// or the above
	 * public void implicitWait(WebDriver driver) 
	 * {
	 * 
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * }
	 */
	
	public void pageToLoad(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will make the driver wait for sometime until element is visible before throw exception
	 * @param driver
	 * @param seconds
	 */
	public void explicitWaitElementTobeVisible(WebDriver driver, WebElement locator)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(locator));
		
	}
	//or the below
	/*
	 * public WebElement explicitWaitVisibilityOfElement(WebDriver driver, By
	 * locator, int seconds) {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	 * 
	 * return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 * 
	 * }
	 */
	
	/**
	 * This method will make the driver wait for sometime until element is clickable before throw exception
	 * @param driver
	 * @param seconds
	 */
	public WebElement explicitWaitOfClickableElement(WebDriver driver, By locator, int seconds)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	/**
	 * This method will make the driver wait for sometime until element is located before throw exception
	 * @param driver
	 * @param seconds
	 */
	public WebElement explicitWaitOfElementPresence(WebDriver driver, By locator, int seconds)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	/**
	 * This method is used to handle drowndown and capture the value by index
	 * @param ele
	 * @param index
	 */
	public void handlingDropdown(WebElement ele, int index)
	{
		
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle drowndown by visible text
	 * @param ele
	 * @param index
	 */
	public void handlingDropdown(WebElement ele, String text)
	{
		
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to handle drowndown by value
	 * @param ele
	 * @param index
	 */
	public void handlingDropdownByValue(WebElement ele, String text)
	{
		
		Select sel = new Select(ele);
		sel.selectByValue(text);
	}
	
	//Or
	/*
	 * public void handlingDropdown(String text, WebElement ele) {
	 * 
	 * Select sel = new Select(ele); sel.selectByValue(text); }
	 */
	
	/**
	 * This method is used to perform the double click operation on an element
	 * @param ele
	 * @param index
	 */
	public void actionMethodDoubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	
	/**
	 * This method is used to perform the click operation on an element
	 * @param ele
	 * @param index
	 */
	public void actionMethodClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
		
	}
	/**
	 * Click operation Without Web element or This method will perform click action where the mouse cursor is pointing
	 * @param driver
	 */
	public void actionMethodClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
		
	}
	
	/**
	 * This method is used to perform the drag and drop operation
	 * @param ele
	 * @param index
	 */
	public void actionMethodDragAndDrop(WebDriver driver, WebElement srcele, WebElement destele)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcele, destele).perform();
		
	}
	
	/**
	 * This method is used to perform the Click And Hold
	 * @param ele
	 * @param index
	 */
	public void actionMethodClickAndHold(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
		
	}
	
	/**
	 * This method is used to perform the clickContext on an element
	 * @param ele
	 * @param index
	 */
	public void actionMethodContextClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	/**
	 * This method will perform right click on an element and open in new tab
	 * @param driver
	 * @param element
	 */
	public void RightClickAndOpenNewTab(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		element.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	}
	
	/**
	 * This method will perform right click on an element and open in new window
	 * @param driver
	 * @param element
	 */
	public void RightClickAndOpenNewWindow(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		element.sendKeys(Keys.chord(Keys.SHIFT,Keys.ENTER));
	}
	
	/**
	 * This method is used to move the cursor to an element
	 * @param ele
	 * @param index
	 */
	public void actionMethodMoveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action TAB
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysTab(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action Backspace
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysBackspace(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action ArrowDown
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysArrowDown(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action ArrowUp
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysArrowUp(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_UP).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action ArrowLeft
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysArrowLeft(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_LEFT).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action ArrowRight
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysArrowRight(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_RIGHT).perform();
		
	}
	
	/**
	 * This method is used to perform the keyboard action Clear
	 * @param ele
	 * @param index
	 */
	public void actionMethodSendKeysClear(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CLEAR).perform();
		
	}
	
	//iFrames
	/**
	 * This method will switch the driver control to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index) ;
	}
	
	/**
	 * This method will switch the driver control to frame based on name or ID
	 * @param driver
	 * @param name or ID
	 */
	public void switchToframe(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId) ;
	}
	
	/**
	 * This method will switch the driver control to frame based on Web element
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the driver control from frame to immediate parent
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the driver control from frame to main window
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	//Alerts
	
	/**
	 * This method will click OK in the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will click CANCEL in the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text from the alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will enter text into the alert popup
	 * @param driver
	 * @param data
	 */
	public void enterDataToAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will scroll upto particular webelement
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will scroll by a random coordinate value
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(x,y).perform();
	}
	
	//Scrollup with javascritpt executor
	/**
	 * This method will scroll down the page by 500 pixels
	 * @param driver
	 */
	public void scrollDownUsingJavascript(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
		
	}
	
	/**
	 * This method will scroll up the page by 500 pixels
	 * @param driver
	 */
	public void scrollUpUsingJavascript(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)");
		
	}
	
	/**
	 * This method will scroll to the bottom of the page
	 * @param driver
	 */
	public void scrollToBottomUsingJavascript(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	/**
	 * This method will scroll the page to the specific element
	 * @param driver
	 * @param element
	 */
	public void scrollToSpecificElementUsingJavascript(WebDriver driver, WebElement element)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	/**
	 * This method will scroll the page horizontally by 500 pixels
	 * @param driver
	 */
	public void scrollHorizontallyUsingJavascript(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)");
		
	}
	
	/**
	 * This method will switch the driver from one window to another window
	 * @param driver
	 * @param WindowName
	 */
	public void switchToWindow(WebDriver driver, String WindowName)
	{
		driver.switchTo().window(WindowName);
	}
	
	/**
	 * This method will make the driver wait until all the windows / tabs loaded in window handle concept
	 * @param driver
	 * @param noOfIds
	 */
	public void waitUntilWindowsToLoad(WebDriver driver, int noOfIds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(noOfIds));
	}
	
	/**
	 * This method will get the title of the window
	 * @param driver
	 */
	public String getWindowTitle(WebDriver driver)
	{
		String title = driver.getTitle();
		return title;
	}
	/**
	 * This method will return parent window ID
	 * @param driver
	 * @return
	 */
	public String getParentWindow(WebDriver driver)
	{
		return driver.getWindowHandle();
	}
	
	/**
	 * This method will switch the driver to child window
	 * @param driver
	 * @param parentID
	 */
	public void switchToChildWindow(WebDriver driver, String parentID)
	{
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String id : windowIds)
		{
			if(!id.equals(parentID))
			{
				driver.switchTo().window(id);
				
			}
						
		}
	}
	
	public void switchToWindowCommonMethod(WebDriver driver, String requiredTitle)
	{
		//capture all windowID's
		Set<String> allWindIDs = driver.getWindowHandles();
		
		//Navigate to each window and get the window title
		for (String win: allWindIDs)
		{
			//switch the control to window and get the title
			String actualTitle = driver.switchTo().window(win).getTitle();
			
			//compare the title with required title
			if (actualTitle.equals(requiredTitle))
			{
				break;
			}
		}
		
		
		
	}
	
	/**
	 * This method will take screenshot and return the path it is stored
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\" + screenshotName +".png");
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath(); // For Extent Reports
	}
	
	/**
	 * This method will switch the driver to Parent window
	 * @param driver
	 * @param parentID
	 */
	public void switchBackToParentWindow(WebDriver driver, String parentID)
	{
		driver.switchTo().window(parentID);
	}
	
	
}
