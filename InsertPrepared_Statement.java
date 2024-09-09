package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertPrepared_Statement
{
	final private static Scanner sc=new Scanner(System.in);
	public static void printing()
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="select * from employe";
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println(con);
		Statement stmt=con.createStatement();
		ResultSet result=stmt.executeQuery(sql);
		while(result.next())
		{
			System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4));
		}
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

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="INSERT into employe (EmpID,EmpName,EmpAge,EmpDept) values (?,?,?,?)";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println(con);
			PreparedStatement pstmt=con.prepareStatement(sql);
			System.out.println("Enter the ID:");
			pstmt.setInt(1,sc.nextInt());
			System.out.println("Enter Employe Name:");
			pstmt.setString(2, sc.next());
			System.out.println("Enter Employee Age:");
			pstmt.setInt(3, sc.nextInt());
			System.out.println("Enter Employee Department");
			pstmt.setString(4, sc.next());
			int result=pstmt.executeUpdate();
			System.out.println(result);
//			while(result.next())
//			{
//				System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4));
//			}
			printing();
			System.out.println();
			System.out.println();
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
