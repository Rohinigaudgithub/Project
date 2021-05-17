package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;
import com.realcoderz.busticket.pdfgenerate.PdfGenerate;

import custom_exception.CustomException;


import com.realcoderz.busticket.dao.impl.BookingStatusDAOImpl;
import com.realcoderz.busticket.bean.Passenger;

public class BookTicket extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(BookTicket.class);
	
	private static final long serialVersionUID = 1L;
	BookingStatusDAOImpl busBookingDao=new BookingStatusDAOImpl();

	BusDAOImpl busDao=new BusDAOImpl();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		LOGGER.info("Ticket Book Successfully");
		//String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
		//response.getWriter().println(html);
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		BookingStatus bookstatus=new BookingStatus();
		HttpSession session = request.getSession(false);
		int noOfSeats = Integer.parseInt(request.getParameter("noOfSeat"));
		int busId = Integer.parseInt(request.getParameter("busId"));
		
		
		
		//----------------------------Ajax Implementation--------------
		
		//int a=Integer.parseInt(request.getParameter("g")+"%");
		
				
				
				
		//------------------AJax finished---------------------------
		
		

		if(session !=null)
		{

			Passenger passenger=(Passenger)session.getAttribute("passenger");
			//	System.out.println(passengerId);
			//String string=(String)session.getAttribute("id");
			//int busId=Integer.parseInt(string);
			Bus b=null;
			try {
				ArrayList<Bus> list=busDao.showBus();
				for(Bus bus:list)
				{
					if(bus.getBusId()==busId)
					{
						b=bus;
						break;
					}
				}

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}


			//int noOfSeats=Integer.parseInt(request.getParameter("seats"));
			int price=b.getPrice();
			java.util.Date date=new java.util.Date();		
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());


			//Passenger passenger=new Passenger();
			int totalPrice=0;
			int flag=0;
			if((b.getBusSeat()-noOfSeats) >= 0)
			{
				
				totalPrice=price*noOfSeats;
				pw.println("<center>"
						+ "<h2>Your Ticket Booking Status</h2>"
						+ "<link rel='stylesheet' type='text/css' href='./resources/css/ViewTicket.css'>"
						+ "<table border=1 class='content-table'>"
						+ "<tr>"
						+ "<th>Passenger Id</th>"
						+ "<th>Bus Id</th>"
						+ "<th>No of Seats</th>"
						+ "<th>Total Price</th>"
						+ "<th>Date</th>"
						+ "</tr>"
						+ "<tr>"
						+ "<td>"+passenger.getPassengerid()+"</td>"
						+ "<td>"+busId+"</td>"
						+ "<td>"+noOfSeats+"</td>"
						+ "<td>"+totalPrice+"</td>"
						+ "<td>"+sqlDate+"</td>"
						+ "</tr>"
						+ "</table>"
						+ "<p>Thank you for booking</p>"
						+ "<a href='ShowBusServletPassenger'>Back to Bus Details</a>"
						+ "</center>");
				//System.out.println("fsdfsaf");
				//PdfGenerate pdfGenerate=new PdfGenerate();
				//pdfGenerate.pdfGenerate(bookstatus);
				b.setBusSeat(b.getBusSeat()-noOfSeats);
				bookstatus.setNoOfSeats(noOfSeats);

			}
			else
			{
				
				pw.println("<h1>Invalid Input Please Check How Many Seats are Available</h1>");
				flag=1;
				totalPrice=price*b.getBusSeat();
				try {
					
		
					throw new CustomException("Invalid Input Please Check How Many Seats are Available");
				} catch (CustomException e) {

					pw.println(e);
					
				}
				
				//pw.println( "You Book only No of Seats"+b.getBusSeat());
				//	System.out.println("fhdgd");
				b.setBusSeat(0);
				bookstatus.setNoOfSeats(b.getBusSeat());	

			}
			if(flag==0)
			{

				bookstatus.setPassenger(passenger);
				bookstatus.setPrice(totalPrice);
				bookstatus.setBus(b);
				bookstatus.setDate(sqlDate);

				try {

					//response.sendRedirect("BookTicketSuccess.html");
					//System.out.println(b.getBusSeat());
					busDao.updateBusSeat(b);
					busBookingDao.bookTicket(bookstatus);

				} 
				catch (ClassNotFoundException | SQLException e) {

					e.printStackTrace();
				}
			}

		}
		else
		{
			System.out.println("Wrong ......");
		}


		





	}

}
