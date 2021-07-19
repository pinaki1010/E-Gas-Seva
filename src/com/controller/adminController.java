package com.controller;
 import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
@WebServlet("/adminController") 
public class adminController extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");

        AdminBean a=new AdminBean();
		a.setName(name);

	    a.setPassword(password);
	
		req.setAttribute("bean", a);
		
		boolean sts=a.validate();
		
		if(sts)
		{
			RequestDispatcher rs=req.getRequestDispatcher("admindashboard.html");
			rs.forward(req,res);
			
		}
		else{
			System.out.println("Oops invalid Credentials");
			RequestDispatcher rs=req.getRequestDispatcher("admin.html");
			rs.forward(req,res);
			
		}
	}
		@Override
		protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			doPost(req,res);
}
	
}
