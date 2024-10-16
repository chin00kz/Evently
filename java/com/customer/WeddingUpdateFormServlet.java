package com.customer;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WeddingUpdateFormServlet")
public class WeddingUpdateFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventId = request.getParameter("eventId");

        // Fetch wedding event details based on eventId
        List<WeddingEvent> weddingEvents = WeddingDButil.getWeddingEventDetails(eventId); // You may need to modify this method
        if (weddingEvents != null && !weddingEvents.isEmpty()) {
            request.setAttribute("weddingEvent", weddingEvents.get(0)); // Assuming the event is found
            RequestDispatcher dispatcher = request.getRequestDispatcher("weddingUpdateForm.jsp"); // Your update form JSP
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page if not found
        }
    }
}
