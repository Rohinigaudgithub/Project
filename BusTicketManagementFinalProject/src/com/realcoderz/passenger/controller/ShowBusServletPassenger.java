package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;

/**
 * Servlet implementation class ShowBusServletPassenger
 */
@WebServlet("/ShowBusServletPassenger")
public class ShowBusServletPassenger extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ShowBusServletPassenger.class);
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOGGER.info("Show Bus to Passenger Servlet");
    	BusDAOImpl busDao=new BusDAOImpl();
		 
		
		 ArrayList<Bus> list=null;
		 try
		 {
				
		 list=busDao.showBus();
		  
		 }
		 catch(ClassNotFoundException | SQLException e)
		 {
			 e.printStackTrace();
		 }
		
		 request.setAttribute("bus", list);
		 request.getRequestDispatcher("BusFunctionPassenger.jsp").forward(request, response);
		
	}

}
