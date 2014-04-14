package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception{
		
		// Accessing driver from the JAR file.
		Class.forName("com.mysql.jdbc.Driver");
		
		// Creating a variable for the connection called "con"
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hud_fixtures","root","");
		
		// Query
		PreparedStatement statement = con.prepareStatement("SELECT * "+
															"FROM team " +
															"WHERE id=2;");
		
		// Query executer
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			System.out.println("id: " + result.getString(1) + "\n" + 
								"contact: " + result.getString(2) + "\n" +
								"pitch: " + result.getString(3) + "\n" +
								"kit: " + result.getString(4)  + "\n"  + 
								"division" + result.getString(5) + "\n" + "\n"
								);
		}
	}
}
