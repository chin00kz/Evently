package com.customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierDBUtil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	
	public static List<Supplier> validate(String username, String password) {
	    ArrayList<Supplier> sup = new ArrayList<>();

	    // Validate for supplier
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "SELECT * FROM supplier WHERE username='" + username + "' AND password='" + password + "'";

	        rs = stmt.executeQuery(sql);

	        if (rs.next()) {
	            int id = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String suname = rs.getString(4);
	            String passU = rs.getString(5);
	            
	            Supplier s = new Supplier(id, name, email, suname, passU);
	            sup.add(s);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sup;
	}

	//get supplier staff detials 
	public static List<Supplier> getSupportStaffDetails() {
	    ArrayList<Supplier> staffList = new ArrayList<>();

	    try {
	        // Establish database connection
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();

	        // Query to get all suppliers (support staff)
	        String sql = "SELECT * FROM supplier"; // No WHERE clause needed

	        rs = stmt.executeQuery(sql);

	        // Loop through each record and add it to the staffList
	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String username = rs.getString(4);
	            String password = rs.getString(5);

	            Supplier staff = new Supplier(id, name, email, username, password);
	            staffList.add(staff);
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

	    return staffList;
	}
	
	//admin add supplier 
	
public static boolean addsupplier(String name,String email,String username,String password ) {
		
		boolean isSuccess = false;
		
		
		
		try {
            
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql ="INSERT INTO supplier (name, email, username, password) VALUES ('"+name+"','"+email+"','"+username+"','"+password+"')";

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


// for update sense 
public static List<Supplier> getSupplierDetailsFS(String id) {
    List<Supplier> sup = new ArrayList<>();
    
    try {
        // Check if the ID is null or empty before converting it
        if (id == null || id.isEmpty()) {
            System.out.println("sup ID is null or empty.");
            return sup; // Return an empty list if ID is not valid
        }
        
        int convertedID = Integer.parseInt(id);  // This can throw NumberFormatException
        con = DBConnect.getConnection();
        stmt = con.createStatement();
        
        String sql = "SELECT * FROM supplier WHERE sid = " + convertedID;
        rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
        	int sid = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String username = rs.getString(4);
            String password = rs.getString(5);
            Supplier s = new Supplier(sid, name,email, username, password);
            sup.add(s);
        }
    } catch (NumberFormatException e) {
        System.out.println("Error converting sup ID: " + e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return sup;
}

public static boolean updatestaff(String id, String name,String email, String username, String password) {
    boolean isSuccess = false;
    try {
        con = DBConnect.getConnection();
        stmt = con.createStatement();
        String sql = "UPDATE supplier SET name = '" + name + "', email = '" + email + "',username='"+username+"', password = '" + password + "' WHERE sid = " + id;
        int rs = stmt.executeUpdate(sql);
        if(rs > 0) {
            isSuccess = true;
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
    return isSuccess;
}

 //delete supplier account
public static boolean deleteSupplier(String id) {
	boolean isSuccess = false;
	
	
	int convertedID = Integer.parseInt(id);
	
	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql ="delete from supplier where sid='"+convertedID+"'";
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


//delete from admin side

public static boolean deletestaffadmin(int staffid) {
    String sql = "DELETE FROM supplier WHERE sid = ?";
    
    try (Connection con = DBConnect.getConnection(); 
         PreparedStatement pstmt = con.prepareStatement(sql)) {
         
        pstmt.setInt(1, staffid);
        return pstmt.executeUpdate() > 0; // Returns true if a row was deleted
    } catch (Exception e) {
        e.printStackTrace();
        return false;

    }
    }


}
