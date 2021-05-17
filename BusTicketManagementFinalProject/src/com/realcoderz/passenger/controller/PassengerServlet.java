package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.service.impl.PassengerServiceImpl;

import custom_exception.CustomException;



public class PassengerServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(PassengerServlet.class);
	private static final long serialVersionUID = 1L;
    PassengerServiceImpl passengerService=new PassengerServiceImpl();
	
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		LOGGER.info("Passenger Register Successfully");
  		PrintWriter pw=response.getWriter();
 
	int Id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("pname");
	String username=request.getParameter("puname");
	String password=request.getParameter("ppwd");
	String add=request.getParameter("padd");
	int mobno=Integer.parseInt(request.getParameter("mobno"));
	String destination=request.getParameter("destination");
	
	Passenger passenger=new Passenger();
	
	passenger.setPassengerid(Id);
	passenger.setPassengername(name);
	passenger.setUsername(username);
	passenger.setPassword(password);
	passenger.setPassengeradd(add);
	passenger.setMobileno(mobno);
	passenger.setDestination(destination);
	
	
	try{
		throw new CustomException("ID Already exits in the database please enter unique ID");
	}
	catch (CustomException s) {
		pw.println(s);
		
	}
	
	try {
		passengerService.insertPassenger(passenger);
		response.sendRedirect("PassengerDetails.html");
		
		//pw.println("Resigered Successfully your username "+username+" and your Password is "+password+"");
		
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}

	}

}
