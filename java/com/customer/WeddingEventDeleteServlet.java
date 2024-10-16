package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WeddingEventDeleteServlet")
public class WeddingEventDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the event ID from the request
        String eventIdStr = request.getParameter("eventId");

        try {
            int eventId = Integer.parseInt(eventIdStr); // Convert to int
            boolean isDeleted = WeddingDButil.deleteWeddingEvent(eventId);

            // Redirect based on deletion success
            if (isDeleted) {
                response.sendRedirect("WeddingViewServlet"); // Redirect back to event view page after deletion
            } else {
                response.sendRedirect("error.jsp"); // Redirect to error page if deletion fails
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Handle invalid event ID
        }
    }
}
