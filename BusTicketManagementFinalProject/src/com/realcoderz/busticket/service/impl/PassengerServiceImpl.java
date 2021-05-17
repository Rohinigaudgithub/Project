package com.realcoderz.busticket.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.dao.impl.PassengerDAOImpl;
import com.realcoderz.busticket.service.PassengerService;

public class PassengerServiceImpl implements PassengerService {
	static final Logger LOGGER = Logger.getLogger(PassengerServiceImpl.class);
	PassengerDAOImpl passengerDao=new PassengerDAOImpl();
	@Override
	public int insertPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Insert Passenger Method from PassengerServiceImpl");
			return passengerDao.insertPassenger(passenger);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Insert PassengerServiceImpl");
			throw e;
		}
	

	}

	@Override
	public int updatePassenger(Passenger passenger)throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Update Passenger Method from PassengerServiceImpl");
			return passengerDao.updatePassenger(passenger);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Update PassengerServiceImpl");
			throw e;
		}

	}

	@Override
	public void showPassenger() throws ClassNotFoundException, SQLException {
		

	}

	@Override
	public int deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Delete Passenger Method from PassengerServiceImpl");
			return passengerDao.deletePassenger(passenger);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Delete PassengerServiceImpl");
			throw e;
		}

	}

}
