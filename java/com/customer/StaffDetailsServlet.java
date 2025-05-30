package com.customer;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SupportStaffServlet")
public class StaffDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve support staff details from the database
        List<Supplier> staffList = SupplierDBUtil.getSupportStaffDetails();

        // Set staffList as a request attribute to pass it to the JSP
        request.setAttribute("staffList", staffList);

        // Forward the request to supportstaff.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("supportstaffdetails.jsp");
        dispatcher.forward(request, response);
    }
}
