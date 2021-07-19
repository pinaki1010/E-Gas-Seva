package com.controller;


	import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import com.bean.cust_regdbean;
import com.dao.cust_regdDao;

	
	@WebServlet("/customerregdController") 
	public class customerregdController extends HttpServlet {  
	 
	   

		protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {     
	         {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        String no=request.getParameter("no");
	        String name=request.getParameter("fullname");  
	        String email=request.getParameter("email"); 
	        String password=request.getParameter("password");  
	        String address=request.getParameter("address");  
	        String phone=request.getParameter("phone");  
	        String pin=request.getParameter("pin"); 
	      
	         cust_regdbean c=new cust_regdbean();
	         c.setNo(no);
	        c.setFullname(name);
	        c.setEmail(email);  
	        c.setPassword(password);  
	        c.setAddress(address);  
	        c.setPhone(phone);  
	        c.setPin(pin);  
	       
	         
	          
	        int st=cust_regdDao.save(c);  
	        if( st>0){  
	            out.print("<p>Record saved successfully!</p>");  
	            request.getRequestDispatcher("customer_regd.html").forward(request, response);  
	        }else{ 
	            out.println("Sorry! unable to save record");  
	        }  
	    }
	}

		

}
