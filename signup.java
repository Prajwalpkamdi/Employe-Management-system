package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.*;
import student_dao.*;

import student_bo.student_bo;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String pass=request.getParameter("pass");
		String con_pass=request.getParameter("con_pass");
		
		student_bo lb=new student_bo(name, mob, email, dob, pass, con_pass);
		
		int status=student_dao.signup(lb);
		
		if(status>0)
		{
			pw.print("data inserted sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("Somethomg went wrong plese try again<br>");
			RequestDispatcher rd=request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
	}

}
