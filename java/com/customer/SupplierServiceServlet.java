package com.customer;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupplierServiceServlet")
public class SupplierServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve support staff details from the database
        List<SupplierService> serviceList = SupplierServiceDBUtil.getSupplierServiceDetails();

        // Set staffList as a request attribute to pass it to the JSP
        request.setAttribute("serviceList", serviceList);

        // Forward the request to supportstaff.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("serviceview.jsp");
        dispatcher.forward(request, response);
    }
}
