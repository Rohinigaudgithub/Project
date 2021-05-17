package com.realcoderz.busticket.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.realcoderz.busticket.bean.BookingStatus;
import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;

public interface BookingStatusDao {
	
	int bookingStatus(BookingStatus bookingstatus);
	ArrayList<BookingStatus> showPassenger(BookingStatus bookingstatus);	
}
