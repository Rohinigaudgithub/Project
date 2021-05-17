package com.realcoderz.busticket.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.realcoderz.busticket.bean.Passenger;

public interface PassengerDao {

int insertPassenger(Passenger passenger)throws ClassNotFoundException, SQLException;
int updatePassenger(Passenger passenger) throws ClassNotFoundException;
int readPassenger()throws ClassNotFoundException, SQLException;
int deletePassenger(Passenger passenger)throws ClassNotFoundException, SQLException;
ArrayList<Passenger> showPassenger() throws ClassNotFoundException, SQLException;
//public Passenger showPassenger1(int id) throws ClassNotFoundException, SQLException;
}
