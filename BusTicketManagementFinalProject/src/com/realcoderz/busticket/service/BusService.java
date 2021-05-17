package com.realcoderz.busticket.service;

import java.sql.SQLException;

import com.realcoderz.busticket.bean.Bus;


public interface BusService {
	int insertBus(Bus bus)throws ClassNotFoundException, SQLException;
	int updateBus(Bus bus)throws ClassNotFoundException, SQLException;
	int deleteBus(Bus bus)throws ClassNotFoundException, SQLException;
	void showBus() throws ClassNotFoundException, SQLException;
}
