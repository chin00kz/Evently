package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminUpdateServlet")
public class AdminUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Fetch the parameters
        String id = request.getParameter("id"); // Make sure this matches with adminupdate.jsp
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if id is null or empty
        if(id == null || id.isEmpty()) {
            // Handle the case where id is missing
            response.sendRedirect("adlog.jsp?error=Invalid+Admin+ID");
            return;
        }

        boolean isTrue;

        // Proceed with the update
        isTrue = AdminDBUtil.updateadmin(id, name, username, password);

        if(isTrue) {
            // Fetch the updated admin details
            List<Admin> adminDetails = AdminDBUtil.getAdminDetails(id);
            request.setAttribute("adminDetails", adminDetails);
            // Forward to the admin account page
            RequestDispatcher dis = request.getRequestDispatcher("adminaccount.jsp");
            dis.forward(request, response);
        } else {
            // If the update failed, still retrieve the details to show error
            List<Admin> adminDetails = AdminDBUtil.getAdminDetails(id);
            request.setAttribute("adminDetails", adminDetails);
            RequestDispatcher dis = request.getRequestDispatcher("adminaccount.jsp");
            dis.forward(request, response);
        }
    }
}
