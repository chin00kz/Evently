package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteService")
public class DeleteServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the service ID from the request
        String serviceIdStr = request.getParameter("serviceId");

        try {
            int serviceId = Integer.parseInt(serviceIdStr); // Convert to int
            boolean isDeleted = SupplierServiceDBUtil.deleteSupplierService(serviceId);
            
            if (isDeleted) {
                response.sendRedirect("serviceview.jsp"); // Redirect to the service view page
            } else {
                response.sendRedirect("error.jsp"); // Redirect to an error page if deletion fails
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page if ID is not valid
        }
    }
}
