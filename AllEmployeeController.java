package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_dao.emp_dao;
import student_bo.emp_bo;
/**
 * Servlet implementation class AllEmployeeController
 */
@WebServlet("/AllEmployeeController")
public class AllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   pw.print("<a href='home.html'>Back</a>");
		 //  pw.print("<form action=\"search\" method=\"get\"><label for=\"\">ID</label><input name=\"id1\" type=\"text\" placeholder=\"Enter ID\"><button type='submit'>Search</button></form>");
		   pw.print("<form action=\"searchname\" method=\"get\"><label for=\"\">Name </label><input name=\"name1\" type=\"text\" placeholder=\"Enter Name\"><button type='submit'>Search Name</button></form>");
		   //pw.print("<form action=\"searchall\" method=\"get\"><label for=\"\">ID</label><input name=\"name2\" type=\"text\" placeholder=\"Enter Name\"><button type='submit'>Search Name</button></form>");
		   
		     pw.print("<div>");
		   pw.print("<table border='1px' width='100%'> ");
		    pw.print("<tr style='background: linear-gradient(90deg,rgb(147, 255, 120),rgb(255, 150, 150),rgb(255, 144, 84))'> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone </th> <th> Date Of Joining</th> <th> Date Of Birth</th> <th> Adhar Details</th> <th>Update </th><th>Delete</th></tr>");
		  List<emp_bo> list= emp_dao.show();
		   
		  for(emp_bo eb:list) 
		  {
			  pw.print("<tr style='background: linear-gradient(90deg,rgb(209, 255, 197),rgb(229, 212, 212),rgb(255, 187, 150))'><td>"+eb.getId()+"</td><td>"+eb.getName()+"</td><td>"+eb.getEmail()+"</td><td>"+eb.getPhone()+"</td><td>"+eb.getDoj()+"</td><td>"+eb.getDob()+"</td><td>"+eb.getAdhar()+"</td><td>"+"<a href='EditServlet2?id="+eb.getId()+"'> edit </a> </td> <td><a href='DeleteServlet?id="+eb.getId()+"'>delete </a></td></tr>"); 
		  }
		
			      
		  pw.print("</table>");
		  pw.print("</div>");
		  pw.close();
	}

}
