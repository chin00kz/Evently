package com.customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WeddingDButil {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
    
    // Method to insert a new wedding event into the database
	public static boolean addWedding(String name, String email, String phone, String location, String eventDate, String participants, String special_requests) {
	    String sql = "INSERT INTO wedding_events (name, email, phone, location, event_date, participants, special_requests) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection con = DBConnect.getConnection(); 
	         PreparedStatement pstmt = con.prepareStatement(sql)) {
	        
	        
	        pstmt.setString(1, name);
	        pstmt.setString(2, email);
	        pstmt.setString(3, phone);
	        pstmt.setString(4, location);
	        pstmt.setString(5, eventDate);
	        pstmt.setInt(6, Integer.parseInt(participants));
	        pstmt.setString(7, special_requests);
	        
	        
	        return pstmt.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
       
    public static List<WeddingEvent> getWeddingDetials() {
	    ArrayList<WeddingEvent> wedlist = new ArrayList<>();

	    try {
	        // database connection
	    	con = DBConnect.getConnection();
			stmt = con.createStatement();

	       
	        String sql = "SELECT * FROM wedding_events;"; 

	        rs = stmt.executeQuery(sql);

	        // Loop through each record and add it to the staffList
	        while (rs.next()) {
	            int id = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String phone = rs.getString(4);
	            String location = rs.getString(5);
	            String eventDate = rs.getString(6);
	            String participants = rs.getString(7);
	            String special_request = rs.getString(8);
	            

	            WeddingEvent wed = new WeddingEvent(id, name, email, phone, location,eventDate,participants,special_request);
	            wedlist.add(wed);
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

	    return wedlist;
	}
    
    
 

    

        // Method to delete a wedding event by ID
      public static boolean deleteWeddingEvent(int id) {
            String sql = "DELETE FROM wedding_events WHERE wid = ?";

            try (Connection con = DBConnect.getConnection(); 
                 PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                return pstmt.executeUpdate() > 0; // Return true if row was deleted
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

      
      public static List<WeddingEvent> getWeddingEventDetails(String eventId) {
    	    List<WeddingEvent> weddingEvents = new ArrayList<>();
    	    Connection con = null;
    	    PreparedStatement pstmt = null;
    	    ResultSet rs = null;

    	    try {
    	        // Parse the eventId as an integer
    	        int convertedID = Integer.parseInt(eventId);  // Handle potential NumberFormatException

    	        // Establish a database connection
    	        con = DBConnect.getConnection();

    	        // Prepare SQL query with parameterized input to avoid SQL injection
    	        String sql = "SELECT * FROM wedding_events WHERE wid = ?";
    	        pstmt = con.prepareStatement(sql);
    	        pstmt.setInt(1, convertedID);

    	        // Execute the query
    	        rs = pstmt.executeQuery();

    	        // Loop through the result set and populate the list of WeddingEvent objects
    	        while (rs.next()) {
    	            int id = rs.getInt("wid");
    	            String name = rs.getString("name");
    	            String email = rs.getString("email");
    	            String phone = rs.getString("phone");
    	            String location = rs.getString("location");
    	            String eventDate = rs.getString("event_date");
    	            String participants = rs.getString("participants");
    	            String specialRequests = rs.getString("special_requests");

    	            // Create a new WeddingEvent object and add it to the list
    	            WeddingEvent weddingEvent = new WeddingEvent(id, name, email, phone, location, eventDate, participants, specialRequests);
    	            weddingEvents.add(weddingEvent);
    	        }
    	    } catch (NumberFormatException e) {
    	        // Handle invalid format for eventId
    	        e.printStackTrace();
    	    } catch (Exception e) {
    	        // Handle other exceptions like SQL or connection issues
    	        e.printStackTrace();
    	    } finally {
    	        // Close resources
    	        try {
    	            if (rs != null) rs.close();
    	            if (pstmt != null) pstmt.close();
    	            if (con != null) con.close();
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	    }

    	    return weddingEvents;
    	}

      
      
      // Method to update a wedding event
      public static boolean updateWeddingEvent(int id, String name, String email, String phone, String location, String eventDate, String participants, String specialRequests) {
          String sql = "UPDATE wedding_events SET name = ?, email = ?, phone = ?, location = ?, event_date = ?, participants = ?, special_requests = ? WHERE wid = ?";

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

              return pstmt.executeUpdate() > 0; // Return true if update succeeds
          } catch (Exception e) {
              e.printStackTrace();
              return false;
          }
      }
       
    }

	
	

