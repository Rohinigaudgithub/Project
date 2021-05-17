package com.realcoderz.busticket.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.dao.impl.BookingStatusDAOImpl;
import com.realcoderz.busticket.service.BookingStatusService;

public class BookingStatusServiceImpl implements BookingStatusService{
	static final Logger LOGGER = Logger.getLogger(BookingStatusServiceImpl.class);
	BookingStatusDAOImpl bookingStatusDao=new BookingStatusDAOImpl();
	@Override
	public int bookTicket(BookingStatus bookingstatus) throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Book Ticket Method from BookingStatusServiceImpl");
			return bookingStatusDao.bookTicket(bookingstatus);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Book Ticket PassengerServiceImpl");
			throw e;
		}
		
		
	}


}
