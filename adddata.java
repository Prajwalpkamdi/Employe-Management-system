package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import student_bo.emp_bo;
import student_bo.student_bo;
import student_dao.student_dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.emp_bo;
import student_dao.emp_dao;

/**
 * Servlet implementation class adddata
 */
@WebServlet("/adddata")
public class adddata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adddata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		 String name=request.getParameter("name");
	     String email=request.getParameter("email");
	     String phone=request.getParameter("phone");
	     String doj=request.getParameter("doj");
	     String dob=request.getParameter("dob");
	     String adhar=request.getParameter("adhar");
	     emp_bo eb=new emp_bo(id,name, email, phone, doj, dob, adhar);
	     int status=emp_dao.insert(eb);
	     if(status>0) 
	     {
		    	
	    	 RequestDispatcher rd=request.getRequestDispatcher("AllEmployeeController");
	    	 rd.forward(request, response);
	    	
	    }else {
	    	pw.print("Something went wrong!!!");
	    	RequestDispatcher rd=request.getRequestDispatcher("insert.html");
	    	 rd.include(request, response);
	    }
		
	}

}
