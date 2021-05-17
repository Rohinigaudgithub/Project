package com.realcoderz.busticket.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.realcoderz.busticket.bean.Passenger;


public interface PassengerService {
	int insertPassenger(Passenger passenger)throws ClassNotFoundException, SQLException;
	int updatePassenger(Passenger passenger)throws ClassNotFoundException, SQLException;
	void showPassenger()throws ClassNotFoundException, SQLException;
	int deletePassenger(Passenger passenger)throws ClassNotFoundException, SQLException;
}


