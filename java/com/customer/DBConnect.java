package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    
    private static String url = "jdbc:mysql://localhost:3306/evently";
    private static String user = "root";
    private static String pass = "123456";
    private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error in getConnection method:");
            e.printStackTrace();
        }
        
        return con;
    }

    // Adding a method to close the connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error closing connection:");
                e.printStackTrace();
            }
        }
    }
}