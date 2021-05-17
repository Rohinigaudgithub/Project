package com.realcoderz.passenger.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class PassengerLogout
 */
@WebServlet("/PassengerLogout")
public class PassengerLogout extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(BookTicket.class);
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		LOGGER.info("Passenger Logout Successfully");
   		HttpSession session=request.getSession();
   		session.removeAttribute("passenger");
   		session.invalidate();
   		System.out.println("Logout");
   		response.sendRedirect("Index.html");
	}

	
}
