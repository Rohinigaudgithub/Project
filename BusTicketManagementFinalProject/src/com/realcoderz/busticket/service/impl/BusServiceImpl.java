package com.realcoderz.busticket.service.impl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BookingStatusDAOImpl;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;
import com.realcoderz.busticket.service.BusService;

public class BusServiceImpl implements BusService {
	static final Logger LOGGER = Logger.getLogger(BusServiceImpl.class);
	BusDAOImpl busdao=new BusDAOImpl();
	@Override
	public int insertBus(Bus bus) throws ClassNotFoundException, SQLException {
		
		try
		{
			LOGGER.info("Inside Insert Bus Method from BusServiceImpl");
			return busdao.insertBus(bus);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Insert BusServiceImpl");
			throw e;
		}
	}

	@Override
	public int updateBus(Bus bus) throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Update Bus Method from BusServiceImpl");
			return busdao.updateBus(bus);
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Update BusServiceImpl");
			throw e;
		}

	}

	@Override
	public int deleteBus(Bus bus) throws ClassNotFoundException, SQLException {
		try
		{
			LOGGER.info("Inside Delete Bus Method from BusServiceImpl");
			return busdao.deleteBus(bus);
			
		}
		catch(Exception e)
		{
			LOGGER.info("Error in Delete BusServiceImpl");
			throw e;
		}
		

	}

	@Override
	public void showBus() throws ClassNotFoundException, SQLException {
		

	}

}
