package com.realcoderz.busticket.bean;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.service.impl.BookingStatusServiceImpl;

public class Bus {
	static final Logger LOGGER = Logger.getLogger(Bus.class);
	private int busId;
	private String busNo;
	private String busDestination;
	private String busSource;
	private int busSeat;
	private int price;
	
	
	public int getBusId() {
		LOGGER.info("Inside Bus Bean Class");
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	public String getBusDestination() {
		return busDestination;
	}
	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}
	public String getBusSource() {
		return busSource;
	}
	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}
	public int getBusSeat() {
		return busSeat;
	}
	public void setBusSeat(int busSeat) {
		this.busSeat = busSeat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
