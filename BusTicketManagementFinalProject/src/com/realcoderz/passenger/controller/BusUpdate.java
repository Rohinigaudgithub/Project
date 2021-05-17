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
import com.realcoderz.busticket.service.impl.BusServiceImpl;



/**
 * Servlet implementation class BusUpdate
 */
@WebServlet("/BusUpdate")
public class BusUpdate extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(BusUpdate.class);
	private static final long serialVersionUID = 1L;

	BusServiceImpl BusService=new BusServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Servlet for Bus Update");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		int busId=Integer.parseInt((String) session.getAttribute("id"));
		//System.out.println(busId);
		//String busNo=request.getParameter("busno");
		String busDestination=request.getParameter("busdestination");
		String busSource=request.getParameter("bussource");
		int busSeats=Integer.parseInt(request.getParameter("busseats"));
		int busPrice=Integer.parseInt(request.getParameter("busprice"));
		
		Bus bus=new Bus();
		
		bus.setBusId(busId);
		//bus.setBusNo(busNo);
		bus.setBusDestination(busDestination);
		bus.setBusSource(busSource);
		bus.setBusSeat(busSeats);
		bus.setPrice(busPrice);
		
		try {
			
			response.sendRedirect("BusUpdateSuccess.html");
			//pw.println("<h1>hello</h1>");
			BusService.updateBus(bus);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
   		
		
	}


}
