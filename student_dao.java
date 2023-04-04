package student_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import student_bo.*;
import student_dao.*;

public class student_dao
{
	public static Connection input()
	{
		Connection cn=null;
		String url=("jdbc:mysql://localhost:3306/server");
		String un="root";
		String pss="Prajwal@123";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,un,pss);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return cn;
	}
	public static int signup(student_bo lb)
	{
		int status=0;
		try 
		{
			Connection cn=student_dao.input();
			PreparedStatement ps=cn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			ps.setString(1,lb.getUser_name());
			ps.setString(2,lb.getMob());
			ps.setString(3,lb.getEmail());
			ps.setString(4,lb.getDob());
			ps.setString(5,lb.getPass());
			ps.setString(6,lb.getCon_pass());
			status =ps.executeUpdate();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static boolean login(String user,String pass)
	{
		boolean status=false;
		try 
		{
			Connection cn=student_dao.input();
			PreparedStatement ps=cn.prepareStatement("select * from student where NAME=? and password=?");
			ps.setString(1,user);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
}
