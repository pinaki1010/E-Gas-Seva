package com.dao;
import java.util.*;  
import java.sql.*;  

import com.bean.gasbookingbean;


public class gasbookingdao { 
	 
	   public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");  
	        }catch(Exception e)
	        {System.out.println(e);}  
	        return con;  
	    }  
	    public static int save( gasbookingbean a){  
	        int st=0;  
	        try{  
	            Connection con=gasbookingdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement( "insert into gasbooking(fullname,email,address,dat) values (?,?,?,?)");     
	          
	            ps.setString(1,a.getFullname());
	            ps.setString(2,a.getEmail());  
	            ps.setString(3,a.getAddress());  
	            ps.setString(4,a.getDat());
	            		              
	            st=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {
	        	ex.printStackTrace();
	        	}  
	          
	        return st;  
	    }  

public static int update( gasbookingbean a){  
    int st=0;  
    try{  
        Connection con=agencydao.getConnection();  
        PreparedStatement ps=con.prepareStatement(  
         
        		 "update gasbooking set fullname='"+a.getFullname()+"',email='"+a.getEmail()+"',address='"+a.getAddress()+"',dat='"+a.getDat()+"' where email=?");  
     
        ps.setString(1,a.getFullname());
        ps.setString(2,a.getEmail());  
        ps.setString(3,a.getAddress());  
        ps.setString(4,a.getDat());
        
       

          
        st=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception ex){ex.printStackTrace();}  
      
    return st;  
}
public static int dete(String email){  
    int st=0;  
    try{  
        Connection con=cust_regdDao.getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from gasbooking where email=?");  
        ps.setString(2,email);  
        st=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return st;  
}  
public static gasbookingbean getAgencyByEmail(String email){  
	gasbookingbean a=new gasbookingbean();  
      
    try{  
        Connection con=cust_regdDao.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from gasbooking where email=?");  
        ps.setString(3,email);  
        ResultSet rs=ps.executeQuery();  
        if(rs.next()){ 
        	
            a.setFullname(rs.getString(1));  
            a.setEmail(rs.getString(2));  
             
            a.setAddress(rs.getString(3));  
            a.setAddress(rs.getString(4)); 
            
            
        }  
        con.close();  
    }catch(Exception ex)
    {
    	ex.printStackTrace();}  
      
    return a;  
}
public static List<gasbookingbean> getAllAgency(){  
    List< gasbookingbean> list=new ArrayList< gasbookingbean >();  
      
    try{  
        Connection con=gasbookingdao.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from gasbooking");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	gasbookingbean s=new gasbookingbean ();  
        	
            s.setFullname(rs.getString(1));  
            s.setEmail(rs.getString(2));  
       
            s.setAddress(rs.getString(3));  
            s.setDat(rs.getString(4));  
            
            
           list.add(s);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
}  
}  



