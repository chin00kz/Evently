package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SupplierLoginServlet")
public class SupplierLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("suname"); // Ensure this matches your form input name
	    String password = request.getParameter("pass");

	    try {
	        List<Supplier> supDetails = SupplierDBUtil.validate(username, password);
	        request.setAttribute("supDetails", supDetails);

	        if (supDetails.isEmpty()) {
	            
	            response.sendRedirect("suplog.jsp?error=Invalid+Credentials");
	        } else {
	        	HttpSession session = request.getSession(true);
            	session.setAttribute("supUsername", username);
            	
            	// After validating admin credentials
            	session.setAttribute("supUsername", supDetails.get(0).getUsername());

	        	
	            // Valid login, forward to supplierdash.jsp
	            RequestDispatcher dis = request.getRequestDispatcher("supplierdash.jsp");
	            dis.forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
