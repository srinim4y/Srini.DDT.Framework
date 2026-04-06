package testNG_Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest 
{
	@Test
	public void sample()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("first method");
		System.out.println("Second method");
		System.out.println("Third method");
		
		//Assert.assertEquals(0,1); // when u comparing two values // Hard Assert - Recommended
		
		sa.assertEquals(0, 1); // Soft Assert - Not recommended // Line no. 11 as well
		
		System.out.println("Fourth method");
		System.out.println("Fifth method");
		
		sa.assertAll(); // log all the failures
	}
}
