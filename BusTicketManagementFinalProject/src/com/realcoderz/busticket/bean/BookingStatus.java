package com.realcoderz.busticket.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;

public class BookingStatus {
	static final Logger LOGGER = Logger.getLogger(BookingStatus.class);
	private int bookingId;
	private Date date;
	private int noOfSeats;
	private int price;
	private Bus bus;
	private Passenger passenger;
	public int getBookingId() {
		LOGGER.info("Inside Booking Status Bean Class");
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
}