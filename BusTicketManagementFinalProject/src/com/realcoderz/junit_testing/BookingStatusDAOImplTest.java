package com.realcoderz.junit_testing;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.service.impl.BookingStatusServiceImpl;
import com.realcoderz.busticket.service.impl.PassengerServiceImpl;




public class BookingStatusDAOImplTest {

	BookingStatusServiceImpl bookingStatusService=new BookingStatusServiceImpl();
	public static BookingStatus bookingStatus=new BookingStatus();
	public static Bus bus=new Bus();
	public static Passenger passenger=new Passenger();
	
	@Test
	public void Test1() throws ClassNotFoundException, SQLException 
	{
		java.util.Date date=new java.util.Date();		
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		
		passenger.setPassengerid(104);
		bus.setBusId(105);
		bookingStatus.setPassenger(passenger);
		bookingStatus.setBus(bus);
		bookingStatus.setNoOfSeats(6);
		bookingStatus.setPrice(20);
		bookingStatus.setDate(sqlDate);
	
		int count= bookingStatusService.bookTicket(bookingStatus);
		assertEquals(1,count);
	}
	
/*	@Test
	public void Test2() throws ClassNotFoundException, SQLException 
	{
		int count= bookingStatusService.bookTicket(bookingStatus);
		assertEquals(0,count);
	}*/
	
}
