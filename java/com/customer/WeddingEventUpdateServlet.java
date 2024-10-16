package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WeddingEventUpdateServlet")
public class WeddingEventUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the updated wedding event details from the request
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String location = request.getParameter("location");
        String eventDate = request.getParameter("eventDate");
        String participants = request.getParameter("participants");
        String specialRequests = request.getParameter("specialRequests");

        // Call the method to update the wedding event in the database
        boolean isUpdated = WeddingDButil.updateWeddingEvent(eventId, name, email, phone, location, eventDate, participants, specialRequests);

        // Redirect based on the update result
        if (isUpdated) {
            response.sendRedirect("WeddingViewServlet"); // Redirect to event view page after update
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page if update fails
        }
    }
}
