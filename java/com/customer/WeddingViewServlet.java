package com.customer;
import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WeddingViewServlet")
public class WeddingViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<WeddingEvent>wedlist = WeddingDButil.getWeddingDetials();
		request.setAttribute("wedlist", wedlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Eventview.jsp");
		dispatcher.forward(request, response);
		
	}

	
	

}
