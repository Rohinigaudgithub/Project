package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;
import com.realcoderz.busticket.bean.Passenger;

@WebServlet("/PassengerLogin")
public class PassengerLogin extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(PassengerLogin.class);
	
	private static final long serialVersionUID = 1L;
       
  
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	LOGGER.info("Inside the Passenger Login Servlet");
 	PrintWriter out=response.getWriter();
 	String username=request.getParameter("uname");
	String password=request.getParameter("pwd");
	
	ArrayList<Passenger> list=new ArrayList<>();
	
	PassengerDAOImpl passengerDao=new PassengerDAOImpl();
	
	try{
		int count =0;
		list=passengerDao.showPassenger();
		for(Passenger passenger : list)
		{
			//System.out.println(passenger.getUsername());
		if(username.equals(passenger.getUsername()) && password.equals(passenger.getPassword()))
		{
			LOGGER.info("Passenger Login Successfully");
			HttpSession session = request.getSession();
		   // session.setAttribute("username", username);
		    session.setAttribute("passenger", passenger);
		   // System.out.println("PassengerLogin"+passenger.getPassengerid());
			RequestDispatcher dispatcher=request.getRequestDispatcher("PassengerLoginSuccess");
			dispatcher.include(request, response);
			count++;
		}
		}
		
		if(count ==0)
		{
				LOGGER.info("Passenger Login Failed");
				//out.println("Username and Password are incorrect try again....");
				//RequestDispatcher dispatcher=request.getRequestDispatcher("ErrorPage.html");
				//dispatcher.include(request, response);
		}
	}
	catch(ClassNotFoundException | SQLException e)
	{
		LOGGER.info("Passenger Login Successfully");
		e.printStackTrace();
		
	}
	
	}

}
