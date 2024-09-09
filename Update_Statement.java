package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Statement 
{

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="UPDATE employe SET EmpAge=EmpAge+2 WHERE EmpID=1";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate(sql);
			System.out.println(i);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
