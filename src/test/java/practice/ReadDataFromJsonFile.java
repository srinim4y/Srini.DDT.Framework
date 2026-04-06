package practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException 
	{
		// TODO Auto-generated method stub
		
		//Open doc in Java read format
		FileReader fr = new FileReader(".\\src\\test\\resources\\CommonData.json");
		
		//Create object of Json Parser
		
		JSONParser jparser = new JSONParser();
		
		
		//Parse the Json file to object
		Object obj = jparser.parse(fr);
		JSONObject jobj = (JSONObject) obj;
		
		//Provide the key to fetch the Value
		
		String value = jobj.get("browser").toString();
		String url = (String) jobj.get("url");
		
		System.out.println(value);
		System.out.println(url);
		
		
	}

}
