package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class transaction
{
	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("DataBase Connected....");
			
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
