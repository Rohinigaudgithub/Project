package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;


@WebServlet("/PassengerLoginSuccess")
public class PassengerLoginSuccess extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(BookTicket.class);
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Passenger Login Successfully");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		//session.setAttribute("username", session.getAttribute("passengerId"));
		
		//System.out.println("PassengerLoginSuccess"+session.getAttribute("passengerId"));
		response.setContentType("text/html");

		out.println("<h1><center>Welcome to Passenger Dashboard</center></h1>");
		out.println("<center>"
				
				+ "<a href=\"ShowBusServletPassenger\">See the Bus Details</a><br><br>"
				+ "<a href=\"ShowPassengerServlet\">View your Details</a><br><br><br>"
				
				//+ "<a href=\"ViewTicket\">View your Bill</a><br><br><br>"
				+ "<a href=\"PassengerLogout\">Logout</a>"
				+ "</center>");
		
	}

}
