package testNG_Practice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TstngPracticeTest 
{
	@Test 
	
	public void addProductTest()
	{
		Assert.fail(); //Force failing the test
		System.out.println("Add");
	}
	
	@Test (dependsOnMethods = "addProductTest")
	public void removeProductTest()
	{
		System.out.println("Remove");
	}
	
	@Test (enabled = false)
	public void updateProductTest()
	{
		System.out.println("Update");
	}

}
