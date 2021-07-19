package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.gasbookingbean;
import com.dao.gasbookingdao;

@WebServlet("/gasbookController")
public class gasbookController extends HttpServlet
{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
        String address=request.getParameter("address");
        String dat=request.getParameter("dat");
        
		gasbookingbean a=new gasbookingbean();
	    a.setFullname(fullname);
		a.setEmail(email);
		a.setAddress(address);
		a.setDat(dat);
		
		
		int st=gasbookingdao.save(a);  
        if( st>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("GasBooking.html").include(request, response);  
        }else{ 
            out.println("Sorry! unable to save record");  
        }  
    }
			

	
}
}
