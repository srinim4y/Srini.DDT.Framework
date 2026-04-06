package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteIntoTable {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		Driver driverRef = new Driver(); // Driver is a class here
		
		//Step 1: Register the driver / database
		DriverManager.registerDriver(driverRef); //DriverManager is a class
		
		//Step 2: Get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute a query - Write into into table
		String query = "insert into customerinfo(name,id,address) values('Srinivas',1234,'Tirupati')";
		
		int res = state.executeUpdate(query);
		
		if (res ==1)
			
		{
			
			System.out.println("Data insertion affected");
		}
		else
		{
			System.out.println("Data insertion failed");
		}
		//Step 5: CLose the database
		con.close();
		
		System.out.println("DB closed");
	}

}
