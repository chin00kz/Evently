package com.customer;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserDetailsServlet")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Customer>cuslist = CustomerDBUtil.getCustomerDetailsFA();
		
		request.setAttribute("cuslist", cuslist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("useraccounts.jsp");
		dispatcher.forward(request, response);
	}

}
