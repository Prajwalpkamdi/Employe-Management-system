package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_bo.emp_bo;
import student_dao.emp_dao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id =Integer.parseInt(request.getParameter("id1"));
		pw.print("<a href='home.html'>Back</a>");
		pw.print("<table border='1px' width='100%'>");
		pw.print("<tr style='background: linear-gradient(90deg,rgb(147, 255, 120),rgb(255, 150, 150),rgb(255, 144, 84))'><th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Date Of Joining</th><th>Date Of Birth</th><th>Adhar Details</th><th>Update</th><th>Delete</th></tr>");
		
		List<emp_bo> list = emp_dao.search(id);
		
		for (emp_bo eb : list) {
			pw.print("<tr style='background: linear-gradient(90deg,rgb(209, 255, 197),rgb(229, 212, 212),rgb(255, 187, 150))'>");
			pw.print("<td>" + eb.getId() + "</td>");
			pw.print("<td>" + eb.getName() + "</td>");
			pw.print("<td>" + eb.getEmail() + "</td>");
			pw.print("<td>" + eb.getPhone() + "</td>");
			pw.print("<td>" + eb.getDoj() + "</td>");
			pw.print("<td>" + eb.getDob() + "</td>");
			pw.print("<td>" + eb.getAdhar() + "</td>");
			pw.print("<td><a href='EditServlet2?id=" + eb.getId() + "'>Edit</a></td>");
			pw.print("<td><a href='DeleteServlet?id=" + eb.getId() + "'>Delete</a></td>");
			pw.print("</tr>");
		}
		
		pw.print("</table>");
		pw.close();
	}

}