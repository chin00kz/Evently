package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BirthdayServlet")
public class BirthdayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        String eventDate = request.getParameter("eventDate");
        String participants = request.getParameter("participants"); // Ensure it's handled as a number if needed
        String specialRequests = request.getParameter("specialRequests");

        // Fetch the logged-in user's username from the session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userUsername") == null) {
            // Redirect to login if user is not logged in
            response.sendRedirect("universallogin.jsp");
            return;
        }
        
        String username = (String) session.getAttribute("userUsername");
        // Assuming userId is stored as Integer
        Integer userId = (Integer) session.getAttribute("userId");

        // Call the method to add the birthday event to the database
        boolean isSuccess = BirthdayDButil.addBirthdayEvent(username, name, email, phone, location, eventDate, participants, specialRequests);

        // Redirect or forward based on the result
        if (isSuccess) {
            List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(userId.toString()); // Convert ID to string if needed
            request.setAttribute("cusDetails", cusDetails);
            request.getRequestDispatcher("useraccount.jsp").forward(request, response); // Forwarding to preserve request attributes
        } else {
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
