package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BirthdayDButil {
    // Method to insert a new birthday event into the database
    public static boolean addBirthdayEvent(String username, String name, String email, String phone, String location, String eventDate, String participants, String specialRequests) {
        String sql = "INSERT INTO birthday_events (username, name, email, phone, location, event_date, participants, special_requests) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
           
        	pstmt.setString(1, username); // Store the user's username with the event
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, location);
            pstmt.setString(6, eventDate);
            pstmt.setInt(7, Integer.parseInt(participants)); // Convert to int
            pstmt.setString(8, specialRequests);
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Other methods...



    // Method to retrieve birthday event details by name
    public static List<BirthdayEvent> getBirthdayEventDetails(String name) {
        List<BirthdayEvent> birthdayList = new ArrayList<>();
        String sql = "SELECT * FROM birthday_events WHERE name = ?";
        
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String eventName = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String location = rs.getString("location");
                String eventDate = rs.getString("event_date");
                String participants = rs.getString("participants");
                String specialRequests = rs.getString("special_requests");

                BirthdayEvent birthdayEvent = new BirthdayEvent(id, eventName, email, phone, location, eventDate, participants, specialRequests);
                birthdayList.add(birthdayEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return birthdayList;
    }

    // Method to update birthday event details
    public static boolean updateBirthdayEvent(int id, String name, String email, String phone, String location, String eventDate, String participants, String specialRequests) {
        String sql = "UPDATE birthday_events SET name = ?, email = ?, phone = ?, location = ?, event_date = ?, participants = ?, special_requests = ? WHERE id = ?";
        
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, location);
            pstmt.setString(5, eventDate);
            pstmt.setString(6, participants);
            pstmt.setString(7, specialRequests);
            pstmt.setInt(8, id);
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a birthday event by ID
    public static boolean deleteBirthdayEvent(int id) {
        String sql = "DELETE FROM birthday_events WHERE id = ?";
        
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
