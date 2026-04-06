package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		//Create an object of driver --- database - mysql db
		
		Driver driverRef = new Driver(); // Driver is a class here
		
		//Step 1: Register the driver / database
		DriverManager.registerDriver(driverRef); //DriverManager is a class
		
		//Step 2: Get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute a query
		ResultSet result = state.executeQuery("select * from customerinfo");
		
		while(result.next())
		{
			System.out.println(result.getString(1));
		}
		
		//Step 5: CLose the database
		con.close();
		
		System.out.println("DB closed");
	}

}
