package testNG_Practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest 
{
	@Test (priority = 1) //Lower priority will execute first
	
	public void addProductTest()
	{
		System.out.println("Add");
	}
	
	@Test (invocationCount = 2, priority = 2)
	public void removeProductTest()
	{
		System.out.println("Remove");
	}
	
	@Test (priority = -2)
	public void updateProductTest()
	{
		System.out.println("Update");
	}

}
