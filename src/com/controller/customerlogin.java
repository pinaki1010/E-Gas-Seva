package com.controller;
import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.customerloginbean;
import com.dao.customerlogindao;
import com.controller.profile;
import java.sql.*;

@WebServlet("/customerlogin") 
public class customerlogin extends HttpServlet {
 
public customerlogin() {
 }
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 

String email = request.getParameter("email");
 String password = request.getParameter("password");
 



customerloginbean bean = new customerloginbean(); 
 
bean.setEmail(email); 
bean.setPassword(password);

customerlogindao dao = new customerlogindao (); 
 
String customerValidate = dao.authenticateCustomer(bean);

if(customerValidate.equals("SUCCESS")) 
 {
 request.setAttribute("email", email); 
 request.getRequestDispatcher("/customerdashboard.html").forward(request, response);
 }
 else
 {
 
  System.out.println("invalid credential");
 }
 }
 
}
