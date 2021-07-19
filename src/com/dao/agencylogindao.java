package com.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.agencyloginbean;


 
 public class agencylogindao {
 public String authenticateAgencies(agencyloginbean bean)  
 {
 
String email = bean.getEmail(); 
 String password = bean.getPassword();
 
Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String userNameDB="";
 String passwordDB="";
try
 {
	con = DBConnection.getConnection(); 
	 statement = con.createStatement(); 
	 resultSet = statement.executeQuery("select  email,password from agency");

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

 return "SS";// Just returning appropriate message otherwise
 }
 }
 
 


 
 

