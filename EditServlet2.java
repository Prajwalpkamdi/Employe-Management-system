package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.emp_bo;
import student_dao.emp_dao;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		 
	      String id=request.getParameter("id");
           
	      int eid= Integer.parseInt(id);
	    
	      emp_bo eb= emp_dao.getEmployeeById(eid);
	    
		 
		pw.print("<form  action='updatecontroller' method='get'> ");
	    
		pw.print("<table>");
		
		pw.print("<tr><td></td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name: </td> <td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
	   	pw.print("<tr><td>Email: </td> <td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
	   	pw.print("<tr><td>Phone:</td> <td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Joining : </td> <td><input type='text' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
	   	pw.print("<tr><td>Date of Birth: </td> <td><input type='text' name='dob' value='"+eb.getDob()+"'/></td></tr>");
	   	pw.print("<tr><td>Adhar Card: </td> <td><input type='text' name='adhar' value='"+eb.getAdhar()+"'/></td></tr>");
		
	    pw.print("<tr><td><input type='submit' value='Update'/></td></tr>"); 
	    
	   	pw.print("</table>");
		
		pw.print("</form>");
		
	}

}
