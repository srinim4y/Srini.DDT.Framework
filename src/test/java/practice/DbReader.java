package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DbReader {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		Statement s = con.createStatement();
		
		ResultSet  rs = s.executeQuery("select * from customerinfo");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		con.close();
		
		System.out.println("DB connection is closed");
		
	}

}
