/**
 * 
 */
package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class ConnectionProvider {
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
		if(con==null) {
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "root");
			
			
			
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();		}
		
		return con;
		
	}
}
