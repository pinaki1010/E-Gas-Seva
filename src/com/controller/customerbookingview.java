package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.agencybean;
import com.bean.gasbookingbean;
import com.dao.agencydao;
import com.dao.gasbookingdao;



@WebServlet("/customerbookingview") 
public class customerbookingview extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		  
        out.println("<h1>Gas booking List</h1>"); 
        List<gasbookingbean>list=gasbookingdao.getAllAgency();  
        
        out.print("<table border='1' width='100%'");
        out.print("<html><head><style>\r\n" + 
        		"table {\r\n" + 
        		"    border-collapse: collapse;\r\n" + 
        		"    width: 100%;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"th, td {\r\n" + 
        		"    text-align: left;\r\n" + 
        		"    padding: 8px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"tr:nth-child(even){background-color: #f2f2f2}\r\n" + 
        		"\r\n" + 
        		"th {\r\n" + 
        		"    background-color: #4CAF50;\r\n" + 
        		"    color: white;\r\n" + 
        		"}\r\n" + 
        		"</style></head><body></body>");
        out.print("<tr><th>Fullname</th><th>Email</th><th>Address</th><th>Date</th><th>Delete</th></tr>"); 
        for(gasbookingbean s:list){
        	out.print("<tr><td>"+s.getFullname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getAddress()+"</td><td>"+s.getDat()+"</td><td><a href='Deletebooking?id="+s.getEmail()+"'>Delete</a></td></tr>");     
        }
        
		
}
}


