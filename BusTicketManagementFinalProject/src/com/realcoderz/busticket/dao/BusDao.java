package com.realcoderz.busticket.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.bean.Passenger;

public interface BusDao {
	int insertBus(Bus bus)throws ClassNotFoundException, SQLException;
	int updateBus(Bus bus) throws ClassNotFoundException;
	int deleteBus(Bus bus)throws ClassNotFoundException, SQLException;
	int updateBusSeat(Bus bus)throws ClassNotFoundException, SQLException;
	ArrayList<Bus> showBus() throws ClassNotFoundException, SQLException;
	//Bus showBus1(int busid) throws ClassNotFoundException, SQLException;
}
