package com.controller;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.bean.contactbean;

import com.dao.contactdao;


	
	@WebServlet("/contactcontroller") 
	public class contactcontroller extends HttpServlet {  
	 
	   

		protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {     
	         {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	       
	        String name=request.getParameter("name");  
	        String email=request.getParameter("email"); 
	     
	      
	        String subject=request.getParameter("subject");  
	        String txtphno=request.getParameter("txtphno"); 
	 
	        contactbean c=new contactbean();
	        
	        c.setName(name);
	        c.setEmail(email);    
	        c.settxtphno(txtphno);  
	        c.setsubject(subject);  
	         
	         
	          
	        int st=contactdao.save(c);  
	        if( st>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("index.html").forward(request, response);  
	        }else{ 
	            out.println("Sorry! unable to save record");  
	        }  
	    }
	}

		

}
