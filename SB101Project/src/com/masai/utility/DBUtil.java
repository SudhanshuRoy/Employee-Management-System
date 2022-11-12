package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
public static Connection provideConnection() {
	Connection connection =null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	String url="jdbc:mysql://localhost:3306/lastfruit";
	
     try {
    	 
	   connection = DriverManager.getConnection(url,"root","*#Mysql09");
	   
       } catch (SQLException e) {
	
	     e.printStackTrace();
     }
	
	return connection;
   }
}
