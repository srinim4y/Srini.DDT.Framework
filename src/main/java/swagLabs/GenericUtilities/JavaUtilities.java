package swagLabs.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of reusable methods related to Java
 */
public class JavaUtilities 
{
	/**
	 * This method will capture the current system date and format it and return
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String currentdate = sd.format(d);
		return currentdate;
	}

}
