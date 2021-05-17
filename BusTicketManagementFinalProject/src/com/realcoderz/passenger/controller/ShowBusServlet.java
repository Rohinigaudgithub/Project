package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;
import com.realcoderz.busticket.bean.Passenger;

/**
 * Servlet implementation class ShowBusServlet
 */
@WebServlet("/ShowBusServlet")
public class ShowBusServlet extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(ShowBusServlet.class);
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("Show Bus Servlet");
		BusDAOImpl busDao = new BusDAOImpl();

		//HttpSession session = request.getSession(false);
		
		/*if (session != null) {
			String string =(String) session.getAttribute("id");
			System.out.println(string);
			int busId = Integer.parseInt(string);
	
		}*/
		ArrayList<Bus> list = null;
		try {

			list = busDao.showBus();
			for (Bus bus : list) {
				bus.getBusId();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("bus", list);
		request.getRequestDispatcher("BusFunction.jsp").forward(request, response);

	}

	
}


