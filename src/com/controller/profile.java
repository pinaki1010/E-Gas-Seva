package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.cust_regdbean;
import com.dao.DBConnection;
import com.dao.cust_regdDao;
import com.dao.customerlogindao;
import com.bean.customerloginbean;

/**
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	

	
	protected  void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
 try
 {	
	 
	 String email =request.getParameter("id");  
	String fullname=request.getParameter("name"); 
	 String address=request.getParameter("address"); 
	 String phone=request.getParameter("phone");           
	 String pin = request.getParameter("pin");  
        out.print("<html>"
        		+ "<head>"
        		+ "<meta charset=\"utf-8\">\r\n" + 
        		"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
        		"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
        		"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n" + 
        		"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
        		"  <style>"
        		+ ".navbar {\r\n" + 
        		"    margin-bottom: 0;\r\n" + 
        		"    background-color: #2d2d30;\r\n" + 
        		"    border: 0;\r\n" + 
        		"    font-size: 10px !important;\r\n" + 
        		"    letter-spacing: 7px;\r\n" + 
        		"    opacity:5.9;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Add a gray color to all navbar links */\r\n" + 
        		".navbar li a, .navbar .navbar-brand { \r\n" + 
        		"    color: #d5d5d5 !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* On hover, the links will turn white */\r\n" + 
        		".navbar-nav li a:hover {\r\n" + 
        		"    color: #fff !important;\r\n" + 
        		"}\r\n" + 
        		"  .carousel-inner img {\r\n" + 
        		"      -webkit-filter: grayscale(70%);\r\n" + 
        		"      filter: grayscale(01%); /* make all photos black and white */ \r\n" + 
        		"      width: 70%; /* Set width to 100% */\r\n" + 
        		"      margin: auto;\r\n" + 
        		"  }\r\n" + 
        		"  .carousel-caption h3 {\r\n" + 
        		"      color: #fff !important;\r\n" + 
        		"  }\r\n" + 
        		"  @media (max-width: 600px) {\r\n" + 
        		"    .carousel-caption {\r\n" + 
        		"      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */\r\n" + 
        		"    }\r\n" + 
        		"  }\r\n" + 
        		"/* The active link */\r\n" + 
        		".navbar-nav li.active a {\r\n" + 
        		"    color: #fff !important;\r\n" + 
        		"    background-color:#29292c !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Remove border color from the collapsible button */\r\n" + 
        		".navbar-default .navbar-toggle {\r\n" + 
        		"    border-color: transparent;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Dropdown */\r\n" + 
        		".open .dropdown-toggle {\r\n" + 
        		"    color: #fff ;\r\n" + 
        		"    background-color: #555 !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Dropdown links */\r\n" + 
        		".dropdown-menu li a {\r\n" + 
        		"    color: #000 !important;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* On hover, the dropdown links will turn red */\r\n" + 
        		".dropdown-menu li a:hover {\r\n" + 
        		"    background-color: grey !important;\r\n" + 
        		"}\r\n" + 
        		"/* footer */\r\n" + 
        		"footer {\r\n" + 
        		"      background-color: #2d2d30;\r\n" + 
        		"      color: #f5f5f5;\r\n" + 
        		"      padding: 32px;\r\n" + 
        		"  }\r\n" + 
        		"  footer a {\r\n" + 
        		"      color: #f5f5f5;\r\n" + 
        		"  }\r\n" + 
        		"  footer a:hover {\r\n" + 
        		"      color: #777;\r\n" + 
        		"      text-decoration: none;\r\n" + 
        		"  } \r\n" + 
        		"  \r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"/* The Modal (background) */\r\n" + 
        		".modal {\r\n" + 
        		"    display: block; /* Hidden by default */\r\n" + 
        		"    position: fixed; /* Stay in place */\r\n" + 
        		"    z-index: 1; /* Sit on top */\r\n" + 
        		"    left: 0;\r\n" + 
        		"    top: 0;\r\n" + 
        		"    width: 100%; /* Full width */\r\n" + 
        		"    height: 100%; /* Full height */\r\n" + 
        		"    overflow: auto; /* Enable scroll if needed */\r\n" + 
        		"    background-color: #580000; /* Fallback color */\r\n" + 
        		"    background-color: #580000;; /* Black w/ opacity */\r\n" + 
        		"    padding-top: 60px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Modal Content/Box */\r\n" + 
        		".modal-content {\r\n" + 
        		"    background-color: #fefefe;\r\n" + 
        		"    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\r\n" + 
        		"    border: 3px solid #f1f1f1;\r\n" + 
        		"    width: 50%;\r\n" + 
        		"   /* Could be more or less, depending on screen size */\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* The Close Button (x) */\r\n" + 
        		".close {\r\n" + 
        		"    position: absolute;\r\n" + 
        		"    right: 25px;\r\n" + 
        		"    top: 0;\r\n" + 
        		"    color: #000;\r\n" + 
        		"    font-size: 35px;\r\n" + 
        		"    font-weight: bold;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".close:hover,\r\n" + 
        		".close:focus {\r\n" + 
        		"    color: red;\r\n" + 
        		"    cursor: pointer;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Add Zoom Animation */\r\n" + 
        		".animate {\r\n" + 
        		"    -webkit-animation: animatezoom 0.6s;\r\n" + 
        		"    animation: animatezoom 0.6s\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"@-webkit-keyframes animatezoom {\r\n" + 
        		"    from {-webkit-transform: scale(0)} \r\n" + 
        		"    to {-webkit-transform: scale(1)}\r\n" + 
        		"}\r\n" + 
        		"    \r\n" + 
        		"@keyframes animatezoom {\r\n" + 
        		"    from {transform: scale(0)} \r\n" + 
        		"    to {transform: scale(1)}\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Change styles for span and cancel button on extra small screens */\r\n" + 
        		"@media screen and (max-width: 300px) {\r\n" + 
        		"    span.psw {\r\n" + 
        		"       display: block;\r\n" + 
        		"       float: none;\r\n" + 
        		"    }\r\n" + 
        		"    .cancelbtn {\r\n" + 
        		"       width: 100%;\r\n" + 
        		"    }\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Set a style for all buttons */\r\n" + 
        		"button {\r\n" + 
        		"    background-color: #4CAF50;\r\n" + 
        		"    color: white;\r\n" + 
        		"    padding: 14px 20px;\r\n" + 
        		"    margin: 8px 0;\r\n" + 
        		"    border: none;\r\n" + 
        		"    cursor: pointer;\r\n" + 
        		"    width: 100%;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"button:hover {\r\n" + 
        		"    opacity: 0.8;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Extra styles for the cancel button */\r\n" + 
        		".cancelbtn {\r\n" + 
        		"    width: auto;\r\n" + 
        		"    padding: 10px 18px;\r\n" + 
        		"    background-color: #f44336;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"/* Center the image and position the close button */\r\n" + 
        		".imgcontainer {\r\n" + 
        		"    text-align: center;\r\n" + 
        		"    margin: 24px 0 12px 0;\r\n" + 
        		"    position: relative;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"img.avatar {\r\n" + 
        		"    width: 30%;\r\n" + 
        		"    border-radius: 50%;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		".container {\r\n" + 
        		"    padding: 100px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"span.psw {\r\n" + 
        		"    float: right;\r\n" + 
        		"    padding-top: 16px;\r\n" + 
        		"}\r\n" + 
        		"\r\n" + 
        		"</style>\r\n"
        		+ "<body>\r\n" + 
        		"<nav class=\"navbar navbar-default navbar-fixed-top\">\r\n" + 
        		"  <div class=\"container-fluid\">\r\n" + 
        		"    <div class=\"navbar-header\">\r\n" + 
        		"      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n" + 
        		"        <span class=\"icon-bar\"></span>\r\n" + 
        		"        <span class=\"icon-bar\"></span>\r\n" + 
        		"        <span class=\"icon-bar\"></span>                        \r\n" + 
        		"      </button>\r\n" + 
        		"     <img src=\"images/hands-with-gas-burner.jpg\" class=\"img-thumbnail\"  width=\"55\" height=\"30\">\r\n" + 
        		"     \r\n" + 
        		"    </div>\r\n" + 
        		"    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n" + 
        		"      <ul class=\"nav navbar-nav navbar-right\">\r\n" + 
        		"        <li><a href=\"index.html\">HOME</a></li>\r\n" + 
        		"         <LI><a href=\"KNOWKG.html\">KNOW TO BUY 5KG CYLINDER</a></LI>\r\n" + 
        		"             <li><a href=\"download.html\">DOWNLOAD SECTION</a></li>\r\n" + 
        		"        <li><a href=\"GasBooking.html\">GAS BOOKING</a></li>\r\n" + 
        		"           <li><a href=\"giveup1.html\">GIVE UP SUBSIDY</a></li>\r\n" + 
        		"        <li><a href=\"feedback.html\"></a>Feedback</li>\r\n" + 
        		"     \r\n" + 
        		"       \r\n" + 
        		"        <li class=\"dropdown\">\r\n" + 
        		"          <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">MORE\r\n" + 
        		"          <span class=\"caret\"></span></a>\r\n" + 
        		"          <ul class=\"dropdown-menu\">\r\n" + 
        		"            <li><a href=\"index.html\">Log out</a></li>\r\n" + 
        		"          </ul>\r\n" + 
        		"        </li>\r\n" + 
        		"        <li><a href=\"#\"><span class=\"glyphicon glyphicon-search\"></span></a></li>\r\n" + 
        		"      </ul>\r\n" + 
        		"    </div>\r\n" + 
        		"  </div>\r\n" + 
        		"</nav>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"<div id=\"id01\" class=\"modal\">\r\n" + 
        		"<form action=\"adminController\"  class=\"modal-content animate\" method=\"post\">	\r\n" + 
        		" \r\n" + 
        		"    <div class=\"imgcontainer\">\r\n" + 
        		"      <span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>\r\n" + 
        		"      <img src=\"images/avatar2.png\" class=\"avatar\">\r\n" + 
        		"    </div>\r\n" + 
        		"\r\n" + 
        		"    <div class=\"container\">\r\n"+ 
        		"<font face=\"copperplate gothic\" size=\"5\" color=\"solid-black\"><b>Profile Information<b></font>\r\n" + 
        		"<br>\r\n" + 
        		"<b>....................................................................</b>"+
        		"<br>\r\n" + 
        		
        		"   \r\n" + 
        		"      <label><b>EMAIL:</b></label>\r\n" + email+"</br>"+
        		      " <label><b>Full name:</br></b></label>\r\n" +fullname+"</br>"+
        		       " <label><b>Phone:</b></label>\r\n" +phone+"</br>"+
        		          " <label><b>Address:</b></label>\r\n" +address+"</br>"+
        		            " <label><b>Pin:</b></label>\r\n"+pin+"</br>"+
        		"\r\n" + 
        		"\r\n" + 
        		"        \r\n" + 
        		"      \r\n" + 
        		"    </div>\r\n" + 
        		"\r\n" + 
        		"   \r\n" + 
        		"</form>\r\n" + 
        		"</div>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"<script>\r\n" + 
        		"// Get the modal\r\n" + 
        		"\r\n" + 
        		"</script>\r\n" + 
        		"<footer >\r\n" + 
        		"  <a class=\"up-arrow\" href=\"#myPage\" data-toggle=\"tooltip\" title=\"TO TOP\">\r\n" + 
        		"    <span class=\"glyphicon glyphicon-chevron-up\"></span>\r\n" + 
        		"  </a><br><br>\r\n" + 
        		"  <p>Copyright &copy Pinaki Nandan  |  ALL right reserved |  <a href=\"3\" data-toggle=\"tooltip\" title=\"Visit about us\"></a> P.N college project </p> \r\n" + 
        		"</footer>"+ 
        		
        		"</body>"
        		+"</head>"
        		+ "</html>");
      
       
 }
		
 catch(Exception e)
 {
 e.printStackTrace();
 }
		
}

	

	

}
