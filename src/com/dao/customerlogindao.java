package com.dao;
 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.bean.cust_regdbean;
import com.bean.customerloginbean;

 
 public class customerlogindao {
	 public String authenticateCustomer(customerloginbean bean)
	 {
	 
	String email = bean.getEmail(); 
	 String password = bean.getPassword();

	Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	String userNameDB = "";
	 String passwordDB = "";

	 
	try
	 {
	 con = DBConnection.getConnection(); 
	 statement = con.createStatement(); 
	 resultSet = statement.executeQuery("select email,password from customer"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
	 
	while(resultSet.next())
	 {
	  userNameDB = resultSet.getString("email"); 
	  passwordDB = resultSet.getString("password");

	 
	   if(email.equals(userNameDB) && password.equals(passwordDB))
	   {
	      return "SUCCESS"; 
	   }
	 }
	 } catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Invalid user credentials"; // Just returning appropriate message otherwise
	 }
	 
	 
	 
	


 }


