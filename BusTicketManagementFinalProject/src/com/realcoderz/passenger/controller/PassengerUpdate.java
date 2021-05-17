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

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;

/**
 * Servlet implementation class PassengerUpdate
 */
@WebServlet("/PassengerUpdate")
public class PassengerUpdate extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(PassengerUpdate.class);
	private static final long serialVersionUID = 1L;
       
   		PassengerDAOImpl passengerDao=new PassengerDAOImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Passenger Update Servlet");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		
		
		
		int passengerId=Integer.parseInt(request.getParameter("id"));
		String passengerName=request.getParameter("pname");
		String passengerAddress=request.getParameter("padd");
		int mobileNo=Integer.parseInt(request.getParameter("mobno"));
		String destination=request.getParameter("destination");
		
		Passenger passenger= (Passenger)session.getAttribute("passenger");
		
		passenger.setPassengerid(passengerId);
		passenger.setPassengername(passengerName);
		passenger.setPassengeradd(passengerAddress);
		passenger.setMobileno(mobileNo);
		passenger.setDestination(destination);
		
		try {
			passengerDao.updatePassenger(passenger);
			
			response.sendRedirect("PassengerUpdateSuccess.html");
			//pw.println("<h1>hello</h1>");
						
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
   		
	}

}
