package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_Connection
{

	public static void main(String[] args)
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet result=null;
		
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			stmt=con.createStatement();
			result = displayEmployees(stmt);
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			close(con, stmt, result);
		}

	}

	public static ResultSet displayEmployees(Statement stmt) throws SQLException {
		ResultSet result;
		result=stmt.executeQuery("select * from employe"); 
		while(result.next())
		{
			System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4));
		}
		return result;
	}

	public static void close(Connection con, Statement stmt, ResultSet result) {
		try
		{
			if(result!=null) {
			result.close();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try 
		{
			if(stmt!=null) {
			stmt.close();
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try 
		{
			if(con!=null) {
			con.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
