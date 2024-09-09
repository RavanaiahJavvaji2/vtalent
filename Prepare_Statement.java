package com.Vtalent;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Prepare_Statement
{
	final private static Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		String url="jdbc:mysql://localhost:3306/ravanaiahdb";
		String username="root";
		String password="Ravanaiah@2002";
		String sql="select * from employe where EmpAge>?";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println(con);
			PreparedStatement pstmt=con.prepareStatement(sql);
			System.out.println("Enter the Age:");
			pstmt.setInt(1,sc.nextInt());
			ResultSet result=pstmt.executeQuery();
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

}
