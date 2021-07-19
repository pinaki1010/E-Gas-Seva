package com.dao;
	import java.util.*;  
import java.sql.*;  

import com.bean.cust_regdbean;

public class cust_regdDao { 
		 
		   public static Connection getConnection(){  
		        Connection con=null;  
		        try{  
		            Class.forName("oracle.jdbc.driver.OracleDriver");  
		            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
		        }catch(Exception e)
		        {System.out.println(e);}  
		        return con;  
		    }  
		    public static int save(cust_regdbean c){  
		        int st=0;  
		        try{  
		        	
		        	
		            Connection con=cust_regdDao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into customer(no,fullname,email,password,address,phone,pin) values (?,?,?,?,?,?,?)");     
		            ps.setString(1,c.getNo());
		            ps.setString(2,c.getFullname());
		            ps.setString(3,c.getEmail());  
		            ps.setString(4,c.getPassword());  
		            ps.setString(5,c.getAddress());  
		            ps.setString(6,c.getPhone()); 
		            ps.setString(7,c.getPin()); 
		            st=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        	}  
		          
		        return st;  
		    }  

	public static int update(cust_regdbean c){  
	    int st=0;  
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	         
	        		 "update customer set no='"+c.getNo()+"',fullname='"+c.getFullname()+"',email='"+c.getEmail()+"',password='"+c.getPassword()+"',address='"+c.getAddress()+"',phone='"+c.getPhone()+"',pin='"+c.getPin()+"' where no=?");  
	        ps.setString(1,c.getNo());
	        ps.setString(2,c.getFullname());
	        ps.setString(3,c.getEmail());  
	        ps.setString(4,c.getPassword());  
	        ps.setString(5,c.getAddress());  
	        ps.setString(6,c.getPhone());  
	        ps.setString(7,c.getPin()); 
	         

	          
	        st=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception ex){ex.printStackTrace();}  
	      
	    return st;  
	}
	public static int delete(String email){  
	    int st=0;  
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from customer where email=?");  
	        ps.setString(3,email);  
	        st=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return st;  
	}  
	
	public static cust_regdbean getStudentByEmail(){  
		cust_regdbean s=new cust_regdbean(); 
		
	      
	    try{ 
	    	
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from customer where email=?");  
	        ps.setString(3,s.getEmail());  
	        ResultSet rs=ps.executeQuery();  
	        if(rs.next()){ 
	        	s.setNo(rs.getString(1));
	            s.setFullname(rs.getString(2));  
	         s.setEmail(rs.getString(3));  
	            s.setPassword(rs.getString(4));  
	            s.setAddress(rs.getString(5));  
	            s.setPhone(rs.getString(6));
	            s.setPin(rs.getString(7));
	           
	            
	            
	        }  
	        con.close();  
	    }catch(Exception ex){ex.printStackTrace();}  
	      
	    return s;  
	}
	public static List< cust_regdbean> getAllCustomers(){  
	    List< cust_regdbean> list=new ArrayList< cust_regdbean >();  
	      
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from customer");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	cust_regdbean s=new cust_regdbean ();  
	        	s.setNo(rs.getString(1));
	            s.setFullname(rs.getString(2));  
	            s.setEmail(rs.getString(3));  
	            s.setPassword(rs.getString(4));  
	            s.setAddress(rs.getString(5));  
	            s.setPhone(rs.getString(6));  
	            s.setPin(rs.getString(7));  
	           
	           list.add(s);  
	        }  
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return list;  
	}
	
	}  



