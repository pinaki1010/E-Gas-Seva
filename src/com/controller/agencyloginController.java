package com.controller;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.agencyloginbean;
import com.dao.agencylogindao;


import java.sql.*;

@WebServlet("/agencyloginController") 
public class agencyloginController extends HttpServlet {
 
public agencyloginController() {
 }
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
response.setContentType("text/html");
String email = request.getParameter("email");
 String password = request.getParameter("password");
 
 agencyloginbean bean = new agencyloginbean(); 
 
bean.setEmail(email); 
bean.setPassword(password);
 
agencylogindao dao = new agencylogindao (); 
 


String agencyValidate = dao.authenticateAgencies(bean);
 
if(agencyValidate.equals("SUCCESS")) 
 {
 request.setAttribute("email", email); 
 request.getRequestDispatcher("/agencydashboard.html").forward(request, response);
 }
 else
 {
	 System.out.println("invalid credential");
 }
 }
 
}
