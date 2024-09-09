package com.Vtalent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Batch_Processing_Prepared_Statement
{
	private final static Scanner sc=new Scanner(System.in);
	public static void printing()
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="select * from employe";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password) ;
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			System.out.println("------------------------------");
			while(result.next())
			{
				System.out.printf("|%-2d |%-10s |%-2d |%-8s|\n",result.getInt(1),result.getString(2),result.getInt(3),result.getString(4));
			}
			System.out.println("------------------------------");
		
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
	public static void BatchStatements()
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="INSERT INTO employe (EmpID,EmpName,EmpAge,EmpDept) values (?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password) ;
			PreparedStatement pstmt=con.prepareStatement(sql);
			String choice=null;
			do {
				System.out.println("Enter ID:");
				pstmt.setInt(1, sc.nextInt());
				System.out.println("Enter EmpName:");
				pstmt.setString(2, sc.next());
				System.out.println("Enter Employee age:");
				pstmt.setInt(3,sc.nextInt());
				System.out.println("Enter Emp Dept:");
				pstmt.setString(4, sc.next());
				pstmt.addBatch();
				System.out.println("Please enter if you want to enter new Employe details (yes/no)");
				 choice=sc.next();
				
				
				
			}while(choice.equals("yes"));
			pstmt.executeBatch();
			System.out.println("New Employe added Succesfully..");
			
		
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

	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="select * from employe";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password) ;
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(sql);
			System.out.println("------------------------------");
			while(result.next())
			{
				System.out.printf("|%-2d |%-10s |%-2d |%-8s|\n",result.getInt(1),result.getString(2),result.getInt(3),result.getString(4));
			}
			System.out.println("------------------------------");
			BatchStatements();
			printing();
		
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
