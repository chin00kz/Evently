package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/insertWedding") // URL pattern matches the form action
public class WeddingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        String eventDate = request.getParameter("eventDate");
        String participants = request.getParameter("participants");
        String special_requests = request.getParameter("special_requests");
        

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userUsername") == null) {
            // Redirect to login if user is not logged in
            response.sendRedirect("universallogin.jsp");
            return;
        }
        
        String username = (String) session.getAttribute("userUsername");
        Integer userId = (Integer) session.getAttribute("userId");

        // Call the method to add the wedding details to the database
        boolean isSuccess = WeddingDButil.addWedding(name, email, phone, location, eventDate, participants, special_requests);
        
        // Redirect or forward based on the result
        if (isSuccess) {
        	
        	List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(userId.toString()); // Convert ID to string if needed
            request.setAttribute("cusDetails", cusDetails);
            response.sendRedirect("index.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }

   
}
