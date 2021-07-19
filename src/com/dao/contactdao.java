package com.dao;
import java.util.*;  
import java.sql.*;

import com.bean.contactbean;


public class contactdao { 
		 
		   public static Connection getConnection(){  
		        Connection con=null;  
		        try{  
		            Class.forName("oracle.jdbc.driver.OracleDriver");  
		            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
		        }catch(Exception e)
		        {System.out.println(e);}  
		        return con;  
		    }  
		    public static int save(contactbean c){  
		        int st=0;  
		        try{  
		            Connection con=contactdao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into contact(name,email,subject,txtphno) values (?,?,?,?)");     
		            ps.setString(1,c.getName());
		            ps.setString(2,c.getEmail());  
		            ps.setString(3,c.getsubject());  
		            ps.setString(4,c.gettxtphno());  		              
		            st=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        	}  
		          
		        return st;  
		    }  

	/*public static int update(cust_regdbean c){  
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
	}*/
	public static List< contactbean> getAllcontact(){  
	    List< contactbean> list=new ArrayList< contactbean >();  
	      
	    try{  
	        Connection con=contactdao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from contact");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	contactbean s=new contactbean ();  
	        	s.setName(rs.getString(1));
	            s.setEmail(rs.getString(2));  
	            s.setsubject(rs.getString(3));  
	            s.settxtphno(rs.getString(4));  
	           list.add(s);  
	        }  
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return list;  
	}
	
	}  



