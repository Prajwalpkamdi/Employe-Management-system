package student_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_bo.emp_bo;



public class emp_dao 
{
	public static Connection cont()
	{
		Connection cn=null;
		String url="jdbc:mysql://localhost:3306/server";
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
	public static int insert(emp_bo eb)
	{
		int status=0;
		try
		{
			Connection cn=emp_dao.cont();
			PreparedStatement ps=cn.prepareStatement("insert into employee(id,name,email,phone,doj,dob,adhar) values(?,?,?,?,?,?,?)");
			ps.setInt(1,eb.getId());
			ps.setString(2,eb.getName());
			ps.setString(3,eb.getEmail() );
			ps.setString(4,eb.getPhone() );
			ps.setString(5, eb.getDoj());
			ps.setString(6,eb.getDob());
			ps.setString(7,eb.getAdhar());
			status = ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static List<emp_bo> show() 
	{
		   
        List<emp_bo> list= new ArrayList<emp_bo>();
  try {
	    Connection con=emp_dao.cont();
        PreparedStatement ps=con.prepareStatement("select *from employee");
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()) {
        	emp_bo eb=new emp_bo();
        	eb.setId(rs.getInt(1));
        	eb.setName(rs.getString(2));
        	eb.setEmail(rs.getString(3));
        	eb.setPhone(rs.getString(4));
        	eb.setDoj(rs.getString(5));
        	eb.setDob(rs.getString(6));
        	eb.setAdhar(rs.getString(7));
            list.add(eb);
        	
        }
	  
  		} catch (Exception e)
  		{
  			System.out.println(e);
  		}
   
   return list;
   
	}
public static int delete(int id) {
		
		int status=0;
		  try {
		
			  Connection con=emp_dao.cont();
			  String query="Delete from employee where id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setInt(1, id);
			  status=ps.executeUpdate();
			  
		} catch (Exception e) {
		
			   System.out.println(e);
		}
		
		return status;
		
	}
public static emp_bo getEmployeeById(int id) {
	 
	 emp_bo eb= new emp_bo();
	 
	   try {
	   	
		   Connection con=emp_dao.cont();
		   String query="select *from employee where id=?";
		   
		   PreparedStatement ps=con.prepareStatement(query);
		   ps.setInt(1, id);

		   ResultSet rs=ps.executeQuery();
		   
		   if(rs.next()) {
			   
			   eb.setId(rs.getInt(1));
			   eb.setName(rs.getString(2));
			   eb.setEmail(rs.getString(3));
			   eb.setPhone(rs.getString(4));
			   eb.setDoj(rs.getString(5));
			   eb.setDob(rs.getString(6));
			   eb.setAdhar(rs.getString(7));
			   
		   }
		   
		   
		   
	} catch (Exception e) {
	
		System.out.println(e);
		
	}
	  
	  
	  return eb;
}
public static int Update(emp_bo eb) {
	 int status=0;
	 
	 try {
		
		 Connection con=emp_dao.cont();
		 
		 String query="update employee set name=?,Email=?,Phone=?, doj=?,dob=?,adhar=? where id=?";
		 PreparedStatement ps=con.prepareStatement(query);
		 ps.setString(1, eb.getName());
		 ps.setString(2, eb.getEmail());
        ps.setString(3, eb.getPhone());
        ps.setString(4, eb.getDoj());
        ps.setString(5, eb.getDob());
        ps.setString(6, eb.getAdhar());
        ps.setInt(7, eb.getId());
		 
        status=ps.executeUpdate();
        
        
        
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
	 
	 
	 return status;
}
public static List search(int id) {
    List<emp_bo> list = new ArrayList<>();

    try {
    		Connection con = emp_dao.cont();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id=?") ;
        		 
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            emp_bo eb = new emp_bo();
            eb.setId(rs.getInt(1));
            eb.setName(rs.getString(2));
            eb.setEmail(rs.getString(3));
            eb.setPhone(rs.getString(4));
            eb.setDoj(rs.getString(5));
            eb.setDob(rs.getString(6));
            eb.setAdhar(rs.getString(7));
            list.add(eb);
        }
    } catch (Exception e) {
        System.out.println(e);
    }

    return list;
}
public static List searchname(String name) {
    List<emp_bo> list = new ArrayList();

    try {
    		Connection con = emp_dao.cont();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE name=?") ;
        		 
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            emp_bo eb = new emp_bo();
            eb.setId(rs.getInt(1));
            eb.setName(rs.getString(2));
            eb.setEmail(rs.getString(3));
            eb.setPhone(rs.getString(4));
            eb.setDoj(rs.getString(5));
            eb.setDob(rs.getString(6));
            eb.setAdhar(rs.getString(7));
            list.add(eb);
        }
    } catch (Exception e) {
        System.out.println(e);
    }

    return list;
}
//public static List searchall(String name) {
//    List<emp_bo> list = new ArrayList();
//
//    try {
//    		Connection con = emp_dao.cont();
//         PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE  name=?") ;
//        		 
//       // ps.setInt(1,id);
//        ps.setString(2,name);
//        //ps.setString(3,email);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next())
//        {
//            emp_bo eb = new emp_bo();
//            eb.setId(rs.getInt(1));
//            eb.setName(rs.getString(2));
//            eb.setEmail(rs.getString(3));
//            eb.setPhone(rs.getString(4));
//            eb.setDoj(rs.getString(5));
//            eb.setDob(rs.getString(6));
//            eb.setAdhar(rs.getString(7));
//            list.add(eb);
//        }
//    } catch (Exception e) {
//        System.out.println(e);
//    }
//
//    return list;
//}
}

