package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteSupplierAccount")
public class DeleteSupplierAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");  // Change this to "id"

		boolean isTrue;
		
		isTrue = SupplierDBUtil.deleteSupplier(id);
		
		if(isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("suplog.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("supplierdash.jsp");
			dispatcher.forward(request, response);
		}
	}

}
