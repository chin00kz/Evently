package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SupplierAddServlet")
public class SupplierAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");	
		String user = request.getParameter("user");	
		String pass = request.getParameter("pass");	
		
		
		
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.addsupplier(name, email, user, pass);
		
		if(isTrue == true) {
			
			 List<Supplier> supplierDetails = SupplierDBUtil.getSupportStaffDetails();
			 
			 
			RequestDispatcher dis =request.getRequestDispatcher("adlog.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("supportstaffdetails.jsp");
			dis2.forward(request, response);
		}
		
		doGet(request, response);
	
	}

}
