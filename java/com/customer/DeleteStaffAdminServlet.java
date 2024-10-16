package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStaffAdminServlet")
public class DeleteStaffAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the service ID from the request
        String staffIdStr = request.getParameter("staffid");

        try {
            int staffid = Integer.parseInt(staffIdStr); // Convert to int
            boolean isDeleted = SupplierDBUtil.deletestaffadmin(staffid);
            
            if (isDeleted) {
                // Fetch updated support staff details after deletion
            	 List<Admin> adminDetails = AdminDBUtil.getAdminDetails(staffIdStr);
                 request.setAttribute("adminDetails", adminDetails);
                 RequestDispatcher dis = request.getRequestDispatcher("adminaccount.jsp");
                dis.forward(request, response); // Forward the response to the JSP
            } else {
                // Only redirect if deletion failed
                response.sendRedirect("error.jsp"); // Redirect to an error page if deletion fails
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page if ID is not valid
        }
    }
}
