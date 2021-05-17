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
 * Servlet implementation class BusDelete
 */
@WebServlet("/BusDelete")
public class BusDelete extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(BusDelete.class);
	private static final long serialVersionUID = 1L;

	BusServiceImpl busService=new BusServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LOGGER.info("Bus Delete Successfully");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(false);
		//int busId=Integer.parseInt((String) session.getAttribute("id"));
		int busId = Integer.parseInt(request.getParameter("id").trim());
		
		Bus bus=new Bus();
		
		bus.setBusId(busId);
		
		try {
			busService.deleteBus(bus);
			response.sendRedirect("ShowBusServlet");
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
   		
		
	}

		
	

}
