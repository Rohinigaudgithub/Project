package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.service.impl.PassengerServiceImpl;


/**
 * Servlet implementation class PassengerDeleteAdmin
 */
@WebServlet("/PassengerDeleteAdmin")
public class PassengerDeleteAdmin extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(PassengerDeleteAdmin.class);
	private static final long serialVersionUID = 1L;
   
	PassengerServiceImpl passengerService=new PassengerServiceImpl();
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		LOGGER.info("Inside the Passenger Delete by Admin");
   		PrintWriter pw=response.getWriter();
   		HttpSession session=request.getSession(false);
   		
		int passengerId=Integer.parseInt(request.getParameter("id").trim());
		
		Passenger passenger=new Passenger();
		
		passenger.setPassengerid(passengerId);
		
		try {
			
			passengerService.deletePassenger(passenger);
			response.sendRedirect("ShowPassengerAdmin");
			//response.sendRedirect("ErrorPage.html");
			//pw.println("<h1>hello</h1>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			
			e.printStackTrace();
		} 
   		
	}

}
