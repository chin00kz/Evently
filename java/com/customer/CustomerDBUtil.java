package com.customer;
import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public static List<Customer> validate(String username, String password){
		
		ArrayList<Customer> cus = new ArrayList<>();
					
		//validate for customer
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();					
			String sql = "select * from customer where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String userU = rs.getString(2);
				String name = rs.getString(3);
				String passU = rs.getString(4);
				String phone_number= rs.getString(5);
				String country = rs.getString(6);
				String address = rs.getString(7);
				String gender = rs.getString(8);
				
				Customer c = new Customer(id,userU,name,passU,phone_number,country,address,gender);
				cus.add(c);
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return cus;
	}
	
	public static boolean insertcustomer(String username,String password,String name,String phone_number,String country, String address, String gender ) {
		
		boolean isSuccess = false;
		
		
		
		try {
            
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql ="INSERT INTO customer (username, name, password, phone_number, country, address, gender) VALUES ('"+username+"','"+name+"','"+password+"','"+phone_number+"','"+country+"','"+address+"','"+gender+"')";

			int rs =stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	//update customer data
	public static boolean updatecustomer(String id, String username, String name, String password, String phone_number, String country, String address) {
	    
	    boolean isSuccess = false;  // Declare the variable here
	    
	    try {
	        // Establish connection
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        
	        // Correct SQL Update Query
	        String sql = "UPDATE customer SET username = '"+username+"', name = '"+name+"', password = '"+password+"', phone_number = '"+phone_number+"', country = '"+country+"', address = '"+address+"' WHERE id = "+id;
	        
	        // Execute the update
	        int rs = stmt.executeUpdate(sql);
	        
	        // If update is successful, set isSuccess to true
	        if(rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    return isSuccess;
	}
	
	//get customer details for show user side
	public static List<Customer> getCustomerDetails(String id){
		
		int convertedID = Integer.parseInt(id);
		ArrayList<Customer> cus = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM customer WHERE id = " + convertedID;

			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cid = rs.getInt(1);
				String username = rs.getString(2);
				String name = rs.getString(3);
				String password = rs.getString(4);
				String phone_number= rs.getString(5);
				String country = rs.getString(6);
				String address = rs.getString(7);
				String gender = rs.getString(8);
				
				Customer c = new Customer(cid,username,name,password,phone_number,country,address,gender);
				cus.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}
	
	// delete data from customer
	public static boolean deleteCustomer(String id) {
		boolean isSuccess = false;
		
		
		int convertedID = Integer.parseInt(id);
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql ="delete from customer where id='"+convertedID+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				isSuccess = true;
				
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	//get user  detials for show admin
	public static List<Customer> getCustomerDetailsFA() {
	    ArrayList<Customer> cuslist = new ArrayList<>();

	    try {
	        // Establish database connection
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();

	        // Query to get all suppliers (support staff)
	        String sql = "SELECT * FROM customer"; // No WHERE clause needed

	        rs = stmt.executeQuery(sql);

	        // Loop through each record and add it to the staffList
	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String username = rs.getString(2);
	            String name = rs.getString(3);
	            String password = rs.getString(4);
	            String phone_number = rs.getString(5);
	            String country = rs.getString(6);
	            String address = rs.getString(7);
	            String gender = rs.getString(8);
	            

	            Customer cus = new Customer(id, username, name, password, phone_number,country,address,gender);
	            cuslist.add(cus);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close database resources
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return cuslist;
	}
	
	
	   
	
}

