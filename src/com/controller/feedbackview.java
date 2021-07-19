package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.feedbackbean;
import com.dao.feedbackdao;



@WebServlet("/feedbackview") 
public class feedbackview extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
        out.println("<h1>Feedback List</h1>"); 
        List<feedbackbean>list=feedbackdao.getAllFeedback();  
        
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
        out.print("<tr><th>Consumerno</th><th>Email</th><th>State</th><th>City</th><th>Distribution</th><th>Password</th><th>Subject</th><th>Delete</th></tr>"); 
        for(feedbackbean s:list){
        	out.print("<tr><td>"+s.getconsumerno()+"</td><td>"+s.getEmail()+"</td><td>"+s.getstate()+"</td><td>"+s.getcity()+"</td><td>"+s.getdistribution()+"</td><td>"+s.getpsw()+"</td><td>"+s.getsubject()+"</td><td><a href='Deletefeedback?id=\"+s.getEmail()+\"'>Delete</a></td></tr>");     
        }
        
		
}
}
