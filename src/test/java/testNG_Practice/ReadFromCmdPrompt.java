package testNG_Practice;

import org.testng.annotations.Test;

public class ReadFromCmdPrompt 
{
	@Test
	public void readFromCmdPrompt()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		String PW = System.getProperty("password");
		System.out.println(PW);
	}

}
