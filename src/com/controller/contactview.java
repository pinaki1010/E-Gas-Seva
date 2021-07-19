package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.contactbean;
import com.dao.contactdao;



@WebServlet("/contactview") 
public class contactview extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 
        out.println("<h1>Contact List</h1>"); 
        List<contactbean>list=contactdao.getAllcontact(); 
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
        out.print("<tr><th>Name</th><th>Email</th><th>Subject</th><th>Phone</th><th>Delete</th></tr>"); 
        for(contactbean s:list){
        	out.print("<tr><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getsubject()+"</td><td>"+s.gettxtphno()+"</td><td><a href='Deletecontact?id=\"+s.getEmail()+\"'>Delete</a></td></tr>"); 
        }
        out.println("<a href='contact.html'>ADD NEW CONTACT</a>"); 
        out.println("<a href='index.html'></br>HOME</a>"); 
		
}
}
