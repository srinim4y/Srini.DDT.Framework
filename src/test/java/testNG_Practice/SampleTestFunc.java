package testNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseTest;

@Listeners (swagLabs.Listeners.ListenersImplementation.class)
public class SampleTestFunc extends BaseTest
{
@Test
	
	public void addProductTest()
	{
		Assert.fail();
		System.out.println("Add");
	}
	
	@Test
	public void removeProductTest()
	{
		System.out.println("Remove");
		
	}
	
	@Test
	public void updateProductTest()
	{
		System.out.println("Update");
	}

}
