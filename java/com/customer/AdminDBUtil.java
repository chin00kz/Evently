package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDBUtil {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    
    public static List<Admin> validate(String username, String password) {
        ArrayList<Admin> admin = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM admin WHERE username='" + username + "' AND password='" + password + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String auname = rs.getString(3);
                String passU = rs.getString(4);
                Admin a = new Admin(id, name, auname, passU);
                admin.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
    
    public static List<Admin> getAdminDetails(String id) {
        List<Admin> admin = new ArrayList<>();
        
        try {
            // Check if the ID is null or empty before converting it
            if (id == null || id.isEmpty()) {
                System.out.println("Admin ID is null or empty.");
                return admin; // Return an empty list if ID is not valid
            }
            
            int convertedID = Integer.parseInt(id);  // This can throw NumberFormatException
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            
            String sql = "SELECT * FROM admin WHERE aid = " + convertedID;
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
            	int aid = rs.getInt(1);
                String name = rs.getString(2);
                String username = rs.getString(3);
                String password = rs.getString(4);
                Admin a = new Admin(aid, name, username, password);
                admin.add(a);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error converting admin ID: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return admin;
    }

    
    public static boolean updateadmin(String id, String name, String username, String password) {
        boolean isSuccess = false;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "UPDATE admin SET username = '" + username + "', name = '" + name + "', password = '" + password + "' WHERE aid = " + id;
            int rs = stmt.executeUpdate(sql);
            if(rs > 0) {
                isSuccess = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}