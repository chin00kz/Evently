package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/serviceinsert")
public class AddSupplierServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String supplier_name = request.getParameter("supplier_name");	
		String company_name = request.getParameter("company_name");	
		String email = request.getParameter("email");	
		String phone_number = request.getParameter("phone_number");	
		String country = request.getParameter("country");
		String service_type = request.getParameter("service_type");
		String service_description = request.getParameter("service_description");
		
		boolean isTrue;
		
		isTrue = SupplierServiceDBUtil.addSupplierService(supplier_name, company_name, email, phone_number, country, service_type, service_description);
		
		if(isTrue == true) {
			
			List<SupplierService> serviceList = SupplierServiceDBUtil.getSupplierServiceDetails();
            request.setAttribute("serviceList", serviceList);
            
			RequestDispatcher dis =request.getRequestDispatcher("serviceview.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		doGet(request, response);
	}

}
