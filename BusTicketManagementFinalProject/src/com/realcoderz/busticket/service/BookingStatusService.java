package com.realcoderz.busticket.service;

import java.sql.SQLException;

import com.realcoderz.busticket.bean.BookingStatus;

public interface BookingStatusService {
	public int bookTicket(BookingStatus bookingstatus) throws ClassNotFoundException, SQLException;
}
