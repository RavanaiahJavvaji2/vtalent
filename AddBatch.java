package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBatch 
{
	public static ResultSet displayEmployees(Statement stmt) throws SQLException
	{
		ResultSet result;
		result=stmt.executeQuery("select * from employe"); 
		while(result.next())
		{
			System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4));
		}
		return result;
	}

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			stmt.addBatch("INSERT into employe values (14,'suresh',29,'ECE')");
			stmt.addBatch("INSERT into employe values (15,'naidu',25,'civil')");
			stmt.executeBatch();
			displayEmployees(stmt);
			
		}
		 catch(ClassNotFoundException e)
		{
			 e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
