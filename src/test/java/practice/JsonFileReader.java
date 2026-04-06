package practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader 
{

	public static void main(String[] args) throws IOException, ParseException 
	{
		// TODO Auto-generated method stub
		
		  FileReader fir = new FileReader(".\\src\\test\\resources\\CommonData.json");
		
		
		  JSONParser jpar = new JSONParser();
		  
		  Object obj = jpar.parse(fir);
		  
		  JSONObject jobj = (JSONObject) obj;
		  
		  //String value = jobj.get("url").toString();
		  
		  String val = (String) jobj.get("url");
		  
		  System.out.println(val);
		 
		
	}

}
