package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Statement
{
	private static Connection con;
	private static Statement stmt;
	//private static ResultSet result;

	public static void main(String[] args)
	{
		
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="INSERT INTO employe"+ "(EmpId,EmpName,EmpAge,EmpDept) VALUES "+"('7','VenkyAnna',28,'sas')";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			stmt=con.createStatement();
			int i=stmt.executeUpdate(sql);
			System.out.println(i);
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
//		finally
//		{
//			close(con, stmt, result);
//		}
//
//	}
//
//	public static void close(Connection con, Statement stmt, ResultSet result) {
//		try
//		{
//			if(result!=null) {
//			result.close();
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		try 
//		{
//			if(stmt!=null) {
//			stmt.close();
//			}
//		} 
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		try 
//		{
//			if(con!=null) {
//			con.close();
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
	}
}
