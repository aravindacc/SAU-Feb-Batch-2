package com.au.sonarqube.Codequality.CRUDjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersManager {

public static void main(String[] args)
{
	String dbURL = "jdbc:mysql://localhost:3306/sampledb";
	String username = "root";
	String password = "root";
	 
	try 
	{ 
	    Connection conn = DriverManager.getConnection(dbURL, username, password);
	    
	    //INSERT
	    String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
	    
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, "sush");
	    statement.setString(2, "sush");
	    statement.setString(3, "sushrutha");
	    statement.setString(4, "sushruthasugur@gmail.com");
	     
	    int rowsInserted = statement.executeUpdate();
	    if (rowsInserted > 0) 
	    {
	        System.out.println("A new user was inserted successfully!");
	    }
	    
	    //SELECT
	    String sql1 = "SELECT * FROM Users";
	    
	    Statement statement1 = conn.createStatement();
	    ResultSet result = statement1.executeQuery(sql1);
	     
	    int count = 0;
	     
	    while (result.next())
	    {
	        String name = result.getString(2);
	        String pass = result.getString(3);
	        String fullname = result.getString("fullname");
	        String email = result.getString("email");
	     
	        String output = "User #%d: %s - %s - %s - %s";
	        System.out.println(String.format(output, ++count, name, pass, fullname, email));
	    }
	    
	    
	    //UPDATE
	    String sql2 = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
	    
	    PreparedStatement statement2 = conn.prepareStatement(sql2);
	    statement2.setString(1, "123456");
	    statement2.setString(2, "Bill Gates");
	    statement2.setString(3, "bill.gates@microsoft.com");
	    statement2.setString(4, "bill");
	     
	    int rowsUpdated = statement2.executeUpdate();
	    if (rowsUpdated > 0) {
	        System.out.println("An existing user was updated successfully!");
	    }
	    
	    //DELETE
	    String sql3 = "DELETE FROM Users WHERE username=?";
	    
	    PreparedStatement statement3 = conn.prepareStatement(sql3);
	    statement3.setString(1, "hey");
	     
	    int rowsDeleted = statement3.executeUpdate();
	    if (rowsDeleted > 0) 
	    {
	        System.out.println("A user was deleted successfully!");
	    }
	    
	}
	catch (SQLException ex) 
	{
	    ex.printStackTrace();
	}
}
}

