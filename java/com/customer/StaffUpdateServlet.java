package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StaffUpdateServlet")
public class StaffUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(id == null || id.isEmpty()) {
            // Handle the case where id is missing
            response.sendRedirect("suplog.jsp?error=Invalid+Admin+ID");
            return;
        }

        boolean isTrue;

        // Proceed with the update
        isTrue = SupplierDBUtil.updatestaff(id, name,email, username, password);

        if(isTrue) {
            // Fetch the updated admin details
            List<Supplier> supDetails = SupplierDBUtil.getSupplierDetailsFS(id);
            request.setAttribute("supDetails", supDetails);
            // Forward to the admin account page
            RequestDispatcher dis = request.getRequestDispatcher("supplierdash.jsp");
            dis.forward(request, response);
        } else {
            // If the update failed, still retrieve the details to show error
            List<Supplier> supDetails = SupplierDBUtil.getSupplierDetailsFS(id);
            request.setAttribute("supDetails", supDetails);
            RequestDispatcher dis = request.getRequestDispatcher("supplierdash.jsp");
            dis.forward(request, response);
        }
		
	}

}
