package com.realcoderz.busticket.bean;

import org.apache.log4j.Logger;

public class Passenger {
	static final Logger LOGGER = Logger.getLogger(Passenger.class);
	private int passengerid;
	private String passengername;
	private String username;
	private String password;
	private String passengeradd;
	private int mobileno;
	private String destination;
	public int getPassengerid() {
		LOGGER.info("Inside Passenger Bean Class");
		return passengerid;
	}
	public void setPassengerid(int passengerid) {
		this.passengerid = passengerid;
	}
	public String getPassengername() {
		return passengername;
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassengeradd() {
		return passengeradd;
	}
	public void setPassengeradd(String passengeradd) {
		this.passengeradd = passengeradd;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}