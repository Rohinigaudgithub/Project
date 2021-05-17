package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;

import util.DBUtility;

/**
 * Servlet implementation class ShowPassengerServlet
 */
@WebServlet("/ShowPassengerServlet")
public class ShowPassengerServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ShowPassengerServlet.class);
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Show Passenger Servlet");
		PassengerDAOImpl passengerDao=new PassengerDAOImpl();
		Passenger passenger = null;
		HttpSession session = request.getSession(false);
		if (session == null) {
			
			response.sendRedirect("PassengerLogin.html");

		}
		
		
		passenger = (Passenger)session.getAttribute("passenger");
		
		
		 request.setAttribute("passengers", passenger);
		 request.getRequestDispatcher("PassengerFunction.jsp").forward(request, response);
		 

		
		
	}
	
	

}
