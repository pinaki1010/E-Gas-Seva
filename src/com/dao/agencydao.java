package com.dao;
	import java.util.*;  
import java.sql.*;  

import com.bean.agencybean;


public class agencydao { 
		 
		   public static Connection getConnection(){  
		        Connection con=null;  
		        try{  
		            Class.forName("oracle.jdbc.driver.OracleDriver");  
		            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
		        }catch(Exception e)
		        {System.out.println(e);}  
		        return con;  
		    }  
		    public static int save( agencybean a){  
		        int st=0;  
		        try{  
		            Connection con=agencydao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into agency(no,fullname,email,password,address,phone,location,pin) values (?,?,?,?,?,?,?,?)");     
		            ps.setString(1,a.getNo());
		            ps.setString(2,a.getFullname());
		            ps.setString(3,a.getEmail());  
		            ps.setString(4,a.getPassword());  
		            ps.setString(5,a.getAddress());  
		            ps.setString(6,a.getPhone()); 
		            ps.setString(7,a.getLocation()); 
		            ps.setString(8,a.getPin()); 
		            		              
		            st=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        	}  
		          
		        return st;  
		    }  

	public static int update(agencybean a){  
	    int st=0;  
	    try{  
	        Connection con=agencydao.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	         
	        		 "update agency set no='"+a.getNo()+"',fullname='"+a.getFullname()+"',email='"+a.getEmail()+"',password='"+a.getPassword()+"',address='"+a.getAddress()+"',phone='"+a.getPhone()+"',location='"+a.getLocation()+"',pin='"+a.getPin()+"' where email=?");  
	        ps.setString(1,a.getNo());
	        ps.setString(2,a.getFullname());
	        ps.setString(3,a.getEmail());  
	        ps.setString(4,a.getPassword());  
	        ps.setString(5,a.getAddress());  
	        ps.setString(6,a.getPhone()); 
	        ps.setString(7,a.getLocation()); 
	        ps.setString(8,a.getPin()); 
	         

	          
	        st=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception ex){ex.printStackTrace();}  
	      
	    return st;  
	}
	public static int delete(String email){  
	    int st=0;  
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from agency where email=?");  
	        ps.setString(3,email);  
	        st=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return st;  
	}  
	public static agencybean getAgencyByEmail(String email){  
		agencybean a=new agencybean();  
	      
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from agency where email=?");  
	        ps.setString(3,email);  
	        ResultSet rs=ps.executeQuery();  
	        if(rs.next()){ 
	        	a.setNo(rs.getString(1));
	            a.setFullname(rs.getString(2));  
	            a.setEmail(rs.getString(3));  
	            a.setPassword(rs.getString(4));  
	            a.setAddress(rs.getString(5));  
	            a.setPhone(rs.getString(6));
	            a.setLocation(rs.getString(7));
	            a.setPin(rs.getString(8));
	            
	            
	            
	        }  
	        con.close();  
	    }catch(Exception ex)
	    {
	    	ex.printStackTrace();}  
	      
	    return a;  
	}
	public static List<agencybean> getAllAgency(){  
	    List< agencybean> list=new ArrayList< agencybean >();  
	      
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from agency");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	agencybean s=new agencybean ();  
	        	s.setNo(rs.getString(1));
	            s.setFullname(rs.getString(2));  
	            s.setEmail(rs.getString(3));  
	            s.setPassword(rs.getString(4));  
	            s.setAddress(rs.getString(5));  
	            s.setPhone(rs.getString(6));  
	            s.setLocation(rs.getString(7));
	            s.setPin(rs.getString(8));  
	            
	           list.add(s);  
	        }  
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return list;  
	}  
	}  



