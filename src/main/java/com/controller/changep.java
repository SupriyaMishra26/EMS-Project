package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.DbConfig;

/**
 * Servlet implementation class changep
 */
@WebServlet("/changep")
public class changep extends HttpServlet {
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			HttpSession s1=request.getSession();
		String empid= (String)s1.getAttribute("eid");
		String pass= request.getParameter("npass");
		
		DbConfig d= new DbConfig();
		Connection c= d.getCon();
		
		PreparedStatement ps=c.prepareStatement("update emp set pass=? where empid=?");
		ps.setString(1, pass);
		ps.setString(2,empid);
		int count=ps.executeUpdate();
		if(count>0)
			{
			RequestDispatcher rd= request.getRequestDispatcher("empprofile.html");//url/html/jsp
			rd.forward(request, response);
			
			}
		else
			out.println("record not updated");
		
		
		}catch(Exception e) {}
		
	}

}
