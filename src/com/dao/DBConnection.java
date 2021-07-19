package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
 

public class DBConnection {
 
 public static Connection getConnection()
 {
 Connection con = null;
 String url = "oracle.jdbc.driver.OracleDriver"; //oracle URL followed by the database name
 String username = "system"; 
 String password = "password"; 
 
 try 
 {
 try 
 {
 Class.forName(url); //loading oracle drivers. This differs for database servers 
 } 
 catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 }
 
 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", username, password); //attempting to connect to oracle database
 System.out.println("Printing connection object "+con);
 } 
 catch (Exception e) 
 {
 e.printStackTrace();
 }
 
 return con; 
 }
}
