package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.feedbackbean;
import com.dao.feedbackdao;





@WebServlet("/feedbackController")
public class feedbackController extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String consumerno =request.getParameter("consumerno");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String distribution=request.getParameter("distribution");	
		String email=request.getParameter("email");
        String psw=request.getParameter("psw");
        String subject=request.getParameter("subject");
        
        feedbackbean a=new feedbackbean();
	    a.setconsumerno(consumerno);
	    a.setstate(state);
		a.setcity(city);
		a.setdistribution(distribution);
		a.setEmail(email);
		a.set(psw);
		a.setsubject(subject);
		
		
		int st=feedbackdao.save(a);  
        if( st>0){  
            out.print("<p>Record saved successfully!</p>");
            
            request.getRequestDispatcher("customerdashboard.html").include(request, response);  
        }else{ 
            out.println("Sorry! unable to save record");  
        }  
    }

	
}
}

