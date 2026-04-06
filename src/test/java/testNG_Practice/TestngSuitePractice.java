package testNG_Practice;

import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseTest;

public class TestngSuitePractice extends BaseTest
{
	@Test (groups = "SmokeSuite") // In this case, only the some suite method will execute, if we use exclude in xml file for this method, in the base class we should use always helper to make sure the base class run on every time irrespective of Test methods we exclude or not we are running
	public void addProductTest()
	{
		System.out.println("Add");
	}
	
	@Test (groups = "RegressionSuite")
	public void swapProductTest()
	{
		System.out.println("Swap");
	}
	
	@Test (groups = "RegressionSuite")
	public void MultipleProductTest()
	{
		System.out.println("Multiple");
	}
	
	
}
