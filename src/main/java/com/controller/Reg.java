package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DBConnection.DbConfig;
/**
 * Servlet implementation class Reg
 */
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
	

String empid=request.getParameter("empid");
	String ename=request.getParameter("ename");
	String address=request.getParameter("address");
	String salary=request.getParameter("salary");
	 String pass = request.getParameter("pass"); // Added password field
	DbConfig db=new DbConfig();
	Connection con=db.getCon();
	PreparedStatement p=con.prepareStatement("INSERT INTO emp (empid, ename, address, salary, pass) VALUES (?, ?, ?, ?, ?)");
    p.setString(1, empid);
	p.setString(1,empid);
	p.setString(2,ename);
	p.setString(3,address);
	p.setString(4,salary);
	p.setString(5, pass); 
   p.executeUpdate();
   PrintWriter out1 =response.getWriter();
   out1.println("Registration successful of this account");   
   out1.println(empid);
   out1.println(ename);
	out1.println(address);
out1.println(salary);
	}
	catch(Exception r) {
		System.out.println(r);
	}
	}

	
}
