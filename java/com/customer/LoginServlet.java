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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		try {
		List<Customer>cusDetails =CustomerDBUtil.validate(username, password);
		request.setAttribute("cusDetails", cusDetails);
		
		if (cusDetails.isEmpty()) {            
            response.sendRedirect("index.jsp?error=Invalid+Credentials");
            
        } else {
        	HttpSession session = request.getSession(true);
        	session.setAttribute("userUsername", username);
        	
        	session.setAttribute("userUsername", cusDetails.get(0).getUsername());
        	session.setAttribute("userId", cusDetails.get(0).getId());
        	// When retrieving the ID, make sure to cast it correctly
        	Integer userId = (Integer) session.getAttribute("userId");
        	// If you need it as a String for some reason, convert it
        	String userIdString = userId.toString(); // Convert
           
        	request.setAttribute("cusDetails", cusDetails);
            RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
            dis.forward(request, response);
        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
		//dis.forward(request, response);
	}

}
