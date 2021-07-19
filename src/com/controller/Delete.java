package com.controller;
 import java.io.*;
import java.sql.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.cust_regdbean;
import com.bean.customerloginbean;
import com.dao.cust_regdDao;
import com.dao.customerlogindao;


@WebServlet("/Delete") 
public class Delete extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		 PrintWriter out=res.getWriter();  

       String email = req.getParameter("email");
		try {
			
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","password");
				String sql = "DELETE FROM customer WHERE email=?";
				  //step3 create the statement object  
			        PreparedStatement st = con.prepareStatement(sql);
			        st.setString(1,email);
			        st.executeUpdate(); 
			        int rowsDeleted = st.executeUpdate();
			       
			        con.close();
			        req.getRequestDispatcher("/giveup1.html").forward(req, res);
				}
				catch(Exception e){ System.out.println(e);}  
			
		 
		 }

		
		
	}

