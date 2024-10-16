package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierServiceDBUtil {

    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

   
    
   

  

        // Method to insert a new supplier service into the database
    public static boolean addSupplierService(String supplierName, String companyName, String email, String phoneNumber, String country, String serviceType, String serviceDescription) {
        boolean isSuccess = false;
        Connection con = null; // Declare Connection here
        Statement stmt = null; // Declare Statement here

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "INSERT INTO supplier_services (supplier_name, company_name, email, phone_number, country, service_type, service_description) " +
                         "VALUES ('" + supplierName + "', '" + companyName + "', '" + email + "', '" + phoneNumber + "', '" + country + "', '" + serviceType + "', '" + serviceDescription + "')";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close(); // Close Statement
                if (con != null) con.close();   // Close Connection
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return isSuccess;
    }
    

   
    // Get supplier services details for staff view
    public static List<SupplierService> getSupplierServiceDetails() {
        ArrayList<SupplierService> serviceList = new ArrayList<>();
        
        try {
            // Establish database connection
            con = DBConnect.getConnection();
            stmt = con.createStatement();

            // Query to retrieve all supplier services
            String sql = "SELECT * FROM supplier_services";
            rs = stmt.executeQuery(sql);

            // Loop through each record and add it to the servicesList
            while (rs.next()) {
                int id = rs.getInt(1);
                String supplierName = rs.getString(2);
                String companyName = rs.getString(3);
                String email = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String country = rs.getString(6);
                String serviceType = rs.getString(7);
                String serviceDescription = rs.getString(8);
                

                SupplierService service = new SupplierService(id,supplierName, companyName, email, phoneNumber, country, serviceType, serviceDescription);
                serviceList.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return serviceList;
    }
    
    
    public static boolean deleteSupplierService(int serviceId) {
        String sql = "DELETE FROM supplier_services WHERE id = ?";
        
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
             
            pstmt.setInt(1, serviceId);
            return pstmt.executeUpdate() > 0; // Returns true if a row was deleted
        } catch (Exception e) {
            e.printStackTrace();
            return false;
 
        }
        }
}
