package com.controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

import com.bean.agencybean;
import com.dao.agencydao;
import com.dao.cust_regdDao;

@WebServlet("/agencyController")


public class agencyController extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String no=request.getParameter("no");
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String location=request.getParameter("location");
		String pin=request.getParameter("pin");
		
		agencybean a=new agencybean();
		a.setNo(no);
		a.setFullname(fullname);
		a.setEmail(email);
		a.setPassword(password);
		a.setAddress(address);
		a.setPhone(phone);
		a.setLocation(location);
		a.setPin(pin);
		
		int st=agencydao.save(a);  
        if( st>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("agency.html").include(request, response);  
        }else{ 
            out.println("Sorry! unable to save record");  
        }  
    }

	
}
}
