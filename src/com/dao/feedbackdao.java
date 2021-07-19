package com.dao;
	import java.util.*;  
import java.sql.*;  

import com.bean.agencybean;
import com.bean.feedbackbean;


public class feedbackdao { 
		 
		   public static Connection getConnection(){  
		        Connection con=null;  
		        try{  
		            Class.forName("oracle.jdbc.driver.OracleDriver");  
		            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
		        }catch(Exception e)
		        {System.out.println(e);}  
		        return con;  
		    }  
		    public static int save( feedbackbean a){  
		        int st=0;  
		        try{  
		            Connection con=agencydao.getConnection();  
		            PreparedStatement ps=con.prepareStatement( "insert into feedback(consumerno,state,city,distribution,email,psw,subject) values (?,?,?,?,?,?,?)");     
		            
		            ps.setString(1,a.getconsumerno());
		            ps.setString(2,a.getstate());               
		            ps.setString(3,a.getcity());  
		            ps.setString(4,a.getdistribution()); 
		            ps.setString(5,a.getEmail()); 
		            ps.setString(6,a.getpsw());  
		            ps.setString(7,a.getsubject());   
		       
		            		              
		            st=ps.executeUpdate();  
		              
		            con.close();  
		        }catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        	}  
		          
		        return st;  
		    }  

	/*public static int update(feedbackbean a){  
	    int st=0;  
	    try{  
	        Connection con=feedbackdao.getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	         
	        		 "update feedback  set fullname='"+a.getFullname()+"',email='"+a.getEmail()+"',address='"+a.getAddress()+"',describe='"+a.getDescribe()+"' where email=?");  
	        
	        ps.setString(1,a.getFullname());
	        ps.setString(3,a.getEmail());   
	        ps.setString(5,a.getAddress());  
	        ps.setString(6,a.getDescribe()); 
	         
	         
	         

	          
	        st=ps.executeUpdate();  
	          
	        con.close();  
	    }catch(Exception ex){ex.printStackTrace();}  
	      
	    return st;  
	}
	public static int delete(String email){  
	    int st=0;  
	    try{  
	        Connection con=cust_regdDao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from feedback where email=?");  
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
	        PreparedStatement ps=con.prepareStatement("select * feedback where email=?");  
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
	*/
	public static List<feedbackbean>getAllFeedback(){  
	    List< feedbackbean> list=new ArrayList<feedbackbean >();  
	      
	    try{  
	        Connection con=feedbackdao.getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from feedback");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	feedbackbean s=new feedbackbean ();  
	      
	           s.setconsumerno (rs.getString(1));  
	           s.setstate(rs.getString(2));  
	           
	           s.setcity(rs.getString(3));  
	              
	      
	            s.setdistribution(rs.getString(4)); 
	            s.setEmail(rs.getString(5)); 
	            s.set(rs.getString(6));
	            s.setsubject(rs.getString(7));
	            
	           list.add(s);  
	        }  
	        con.close();  
	    }catch(Exception e){e.printStackTrace();}  
	      
	    return list;  
	}  
}


