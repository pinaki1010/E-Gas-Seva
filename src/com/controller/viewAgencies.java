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
import com.dao.agencydao;



@WebServlet("/viewAgencies") 
public class viewAgencies extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
        out.println("<h1>Agency List</h1>"); 
        List<agencybean>list=agencydao.getAllAgency();  
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
        out.print("<tr><th>No</th><th>Fullname</th><th>Email</th><th>Password</th><th>Address</th><th>Phone</th><th>Pin</th><th>View</th><th>Delete</th></tr>"); 
        for(agencybean s:list){
        	out.print("<tr><td>"+s.getNo()+"</td><td>"+s.getFullname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getPassword()+"</td><td>"+s.getAddress()+"</td><td>"+s.getPhone()+"</td><td>"+s.getPin()+"</td><td><a href='profile?id="+s.getEmail()+"&name="+s.getFullname()+"&phone="+s.getPhone()+"&pin="+s.getPin()+"&address="+s.getAddress()+"'>View</a></td><td><a href='Deleteagency?id="+s.getEmail()+"'>Delete</a></td></tr>");     
        }
        out.println("<a href='agency.html'>Add New Agency</a>");            
	}
       		
}





