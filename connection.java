package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection 
{

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String user="root";
		String pass="Ravanaiah@2002";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded..");
			Connection con=DriverManager.getConnection(url,user,pass);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
