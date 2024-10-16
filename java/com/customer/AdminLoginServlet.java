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

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("auname");
        String password = request.getParameter("pass");
        try {
            List<Admin> adminDetails = AdminDBUtil.validate(username, password);
            request.setAttribute("adminDetails", adminDetails);
            if (adminDetails.isEmpty()) {
                response.sendRedirect("adlog.jsp?error=Invalid+Credentials");
            } else {
            	
            	HttpSession session = request.getSession(true);
            	session.setAttribute("adminUsername", username);
            	
            	// After validating admin credentials
            	session.setAttribute("adminUsername", adminDetails.get(0).getUsername());

            	
                RequestDispatcher dis = request.getRequestDispatcher("adminaccount.jsp");
                dis.forward(request, response);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}