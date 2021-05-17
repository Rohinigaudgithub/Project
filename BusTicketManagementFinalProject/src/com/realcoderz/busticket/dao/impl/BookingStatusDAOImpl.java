package com.realcoderz.busticket.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;

import util.DBUtility;

public class BookingStatusDAOImpl {
	static final Logger LOGGER = Logger.getLogger(BookingStatusDAOImpl.class);
	DBUtility db=new DBUtility();


	
	public int bookTicket(BookingStatus bookingstatus) throws ClassNotFoundException, SQLException
	{
		LOGGER.info("Inside Book Ticket Method from BookingStatusDAOImpl");
		int rowUpdateCount=0;	
		int passengerId=bookingstatus.getPassenger().getPassengerid();
		int busId=bookingstatus.getBus().getBusId();
		int noOfSeats=bookingstatus.getNoOfSeats();
		int price=bookingstatus.getPrice();
		Date date=bookingstatus.getDate();
		
		try
		{
			Connection connection=db.getDBConnection();
			Statement stmt = connection.createStatement();
			LOGGER.info("Connection Established for Book Ticket");
			rowUpdateCount=stmt.executeUpdate("insert into bookingstatus(passengerid,busid,noofseats,price,date) values "
					+ "("+passengerId+","+busId+","+noOfSeats+","+price+",'"+date+"')");
			

			if(rowUpdateCount>0)
			{
			LOGGER.info("Book Ticket Successfully");
			//System.out.println(" Book Ticket Successfully ");
			}
			else
			{
				LOGGER.info("Ticket do not Book Successfully");
				//System.out.println("***********Book do not book properly **************");
			}
			
		}
		
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while ticket booking");
			throw e;
		}
		finally
		{
		return rowUpdateCount;
		}
	}
	
	/*public ArrayList<BookingStatus> showBookTicket(int passengerid) throws SQLException {
		ArrayList<BookingStatus> list=new ArrayList<BookingStatus>();

		
		
		try {
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			
	String updateData="select * from bookingstatus where passengerid="+passengerid+";";
	ResultSet rs=statement.executeQuery(updateData);
	PassengerDAOImpl passengerDAO=new PassengerDAOImpl();
	BusDAOImpl busDaoImpl=new BusDAOImpl();
	//Passenger passenger=passengerDAO.showPassenger1(passengerid);
	//Bus bus=busDaoImpl.showBus1(0);
	
	while(rs.next())
	{
		BookingStatus bookingStatus=new BookingStatus();
		
		
		bookingStatus.setBookingId(rs.getInt(1));
		bookingStatus.setPassenger(passenger);
		//bookingStatus.setBus(bus);
		
		
		list.add(bookingStatus);
	     }
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			DBUtility.getDBConnectionClose();
		}
	
		return list; 
	
	}*/
	
}
