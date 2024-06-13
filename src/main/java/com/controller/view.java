package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.DbConfig;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out= response.getWriter();
			HttpSession s1=request.getSession();
			String empid= (String) s1.getAttribute("eid");
			DbConfig d= new DbConfig();
			Connection c= d.getCon();
			PreparedStatement ps=c.prepareStatement("select * from emp where empid=? ");
			ps.setString(1, empid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				out.println("<html><body>");
				out.println("<h1>Employee Details</h1>");
				out.println("<p>Employee ID: " + rs.getString("empid") + "</p>");
				out.println("<p>Name: " + rs.getString("ename") + "</p>");
				out.println("<p>Address: " + rs.getString("address") + "</p>");
				out.println("<p>Salary: " + rs.getString("salary") + "</p>");
				out.println("</body></html>");
			}
			else
				out.println("Record not found");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
