package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone_number = request.getParameter("phone_number");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updatecustomer(id, username, name, password, phone_number, country, address);
		
		if(isTrue == true) {
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp;");
			dis.forward(request, response);
			
			
		}else {
			
			List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			RequestDispatcher dis =request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		
		doGet(request, response);
	}

}
