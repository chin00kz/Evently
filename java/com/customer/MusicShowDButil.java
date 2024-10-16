package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MusicShowDButil {
    // Method to insert a new music show into the database
    public static boolean addMusicShow(int userId,String name, String email, String phone, String location, String eventDate, String participants, String special_requests) {
        String sql = "INSERT INTO music_events (user_id, name, email, phone, location, event_date, participants, special_requests) VALUES (?, ?, ?, ?, ?, ?,?,?)";
        
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            
        	pstmt.setInt(1, userId); // Set user ID
	        pstmt.setString(2, name);
	        pstmt.setString(3, email);
	        pstmt.setString(4, phone);
	        pstmt.setString(5, location);
	        pstmt.setString(6, eventDate);
	        pstmt.setInt(7, Integer.parseInt(participants));
	        pstmt.setString(8, special_requests);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
