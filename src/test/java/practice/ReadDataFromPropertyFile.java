package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		//Open the document in Java read format
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\SecondPropertyFile.properties");
		
		// Create an object of Properties class (Here the properties is not the PROPERTY file we created, it is the class from the Util package to handle all property files created within the project)
		
		Properties p = new Properties();
		
		//Load the input stream into Properties
		p.load(fis);
		
		// Provide the key and capture the value
		String value = p.getProperty("url");
		//String un = p.getProperty("username");
		//String pw = p.getProperty("password");
		
		System.out.println(value);
		//System.out.println(un);
		//System.out.println(pw);
		
		
	}

}
