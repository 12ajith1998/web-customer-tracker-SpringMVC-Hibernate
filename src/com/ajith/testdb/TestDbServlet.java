package com.ajith.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user="springstudent";
		String pass="springstudent";
		
		String url="jdbc:mysql://localhost:3306/web_customer_tracker?useSSl=false";
		
		String driver="com.mysql.cj.jdbc.Driver";
		
		try{
			
			PrintWriter out=response.getWriter();
			out.println("connecting to database: "+url);
			
			Class.forName(driver);
			
			Connection con=DriverManager.getConnection(url,user,pass);
			
			out.print("SUCCESS !!!");
			con.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	
	}

}
