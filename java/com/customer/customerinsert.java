package com.customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customerinsert")
public class customerinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");	
		String pass = request.getParameter("pass");	
		String name = request.getParameter("name");	
		String phone_number = request.getParameter("phone_number");	
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.insertcustomer(user, pass, name, phone_number, country, address, gender);
		
		if(isTrue == true) {
			RequestDispatcher dis =request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		doGet(request, response);
	}

}
