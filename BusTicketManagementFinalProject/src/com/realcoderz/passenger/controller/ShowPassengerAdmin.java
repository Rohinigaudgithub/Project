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
import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;

/**
 * Servlet implementation class ShowPassengerAdmin
 */
@WebServlet("/ShowPassengerAdmin")
public class ShowPassengerAdmin extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(PassengerServlet.class);
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		LOGGER.info("Passenger Show to Admin Servlet");
  		PassengerDAOImpl passengerDao=new PassengerDAOImpl();
		
		/*HttpSession session = request.getSession(false);
		if (session != null) {
			int passengerId = (Integer) session.getAttribute("id");
		
			//System.out.println(string);
			//int passengerId = Integer.parseInt(string);
		}*/
		
		// System.out.println("In showpassenger servlet");
		 ArrayList<Passenger> list=null;
		 try
		 {
				
		 list=passengerDao.showPassenger();
		 for (Passenger passenger : list) {
				passenger.getPassengerid();
			}

		 }
		 catch(ClassNotFoundException | SQLException e)
		 {
			 e.printStackTrace();
		 }
		// response.sendRedirect("PassengerFunction.html");
		 request.setAttribute("passengers", list);
		 request.getRequestDispatcher("AdminFunction.jsp").forward(request, response);
		 
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
