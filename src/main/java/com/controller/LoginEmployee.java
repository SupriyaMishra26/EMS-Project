package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.DbConfig;

 //page navigation 
@WebServlet("/log")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		try {
		String empid= request.getParameter("empid");
		String pass= request.getParameter("pass");
		
		DbConfig d= new DbConfig();
		Connection c= d.getCon();
		
		PreparedStatement ps=c.prepareStatement("select * from emp where empid=? and pass=?");
		ps.setString(1,empid);
		ps.setString(2, pass);
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			HttpSession s1=request.getSession();
			s1.setAttribute("eid", empid);
			s1.setAttribute("pass", pass);
			RequestDispatcher rd= request.getRequestDispatcher("empprofile.html");//url/html/jsp
			rd.forward(request, response);
			//rd.include(request, response);
		}
		else
			response.sendRedirect("login.html");//update client url 
		
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
