package com.realcoderz.busticket.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.BusDao;
import com.realcoderz.passenger.controller.BookTicket;

import util.DBUtility;

public class BusDAOImpl implements BusDao {
	static final Logger LOGGER = Logger.getLogger(BusDAOImpl.class);

	DBUtility db=new DBUtility();
	public int insertBus(Bus bus) throws ClassNotFoundException, SQLException {

		LOGGER.info("Inside InsertBus Method from BusDAOImpl ");

		int rowUpdateCount=0;
		try
		{
			int busId=bus.getBusId();
			String busNo=bus.getBusNo();
			String busDestination=bus.getBusDestination();
			String busSource=bus.getBusSource();
			int busSeat=bus.getBusSeat();
			int price=bus.getPrice();
			//System.out.println(busId);

			Connection connection=db.getDBConnection();
			Statement stmt = connection.createStatement();
			LOGGER.info("Connection Established for Add Bus");
			//System.out.println(stmt);
			rowUpdateCount=stmt.executeUpdate("INSERT INTO busdetails (busid,busno,busdestination,source,seats,price) values"
					+ "("+busId+",'"+busNo+"','"+busDestination+"','"+busSource+"',"+busSeat+","+price+")");
			if(rowUpdateCount==1)
			{
				LOGGER.info("Bus Add Successfully");
				//System.out.println(" Bus Add Successfully ");
			}
			else
			{
				LOGGER.info("Ticket do not book Successfully");
				//System.out.println("***********Bus do not add properly **************");
			}
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while inserting the bus data");
			throw e;
		}
		finally
		{
			return rowUpdateCount;
		}

	}
	@Override
	public int updateBus(Bus bus) throws ClassNotFoundException {
		LOGGER.info("Inside UpdateBus Method from BusDAOImpl ");
		int flag = 0;
		try
		{
			int busId=bus.getBusId();
			String busNo=bus.getBusNo();
			String busDestination=bus.getBusDestination();
			String busSource=bus.getBusSource();
			int busSeat=bus.getBusSeat();
			int price=bus.getPrice();

			//System.out.println("BusDaoImpl:"+busId+" +"+busSeat);

			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Update Bus");
			String updateData="update busdetails set busdestination='"+busDestination+"',price="+price+",source='"+busSource+"',seats="+busSeat+" where busid='"+busId+"'";
			flag=statement.executeUpdate(updateData);

			LOGGER.info("Bus Update Successfully");
			//System.out.println(updateData);
			//System.out.println("Data Update Successfully");
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while updating the bus details");
			System.out.println(e);
		}

		return flag;
	}


	@Override
	public int deleteBus(Bus bus) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside DeleteBus Method from BusDAOImpl ");
		int flag=0;

		try
		{
			int busId=bus.getBusId();
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Delete Bus");
			String deleteData="delete from busdetails where busid='"+busId+"'";
			flag=statement.executeUpdate(deleteData);
			LOGGER.info("Bus Delete Successfully");
			
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while deleting the bus details");
			System.out.println(e);
		}
		return flag;
		//int rowUpdateCount=0;
		//return rowUpdateCount;
	}



	@Override
	public ArrayList<Bus> showBus() throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside ShowBus Method from BusDAOImpl ");
		ArrayList<Bus> list=new ArrayList<Bus>();

		try
		{
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Show Bus");
			String updateData="select * from busdetails";
			ResultSet rs=statement.executeQuery(updateData);
			//System.out.println("Bus Id,Bus Number,Bus Destination, Bus Source, Bus Seats, Bus Price");
			while(rs.next())
			{
				Bus bus=new Bus();
				bus.setBusId(rs.getInt(1));
				bus.setBusNo(rs.getString(2));
				bus.setBusDestination(rs.getString(3));
				bus.setBusSource(rs.getString(4));
				bus.setBusSeat(rs.getInt(5));
				bus.setPrice(rs.getInt(6));

				list.add(bus);
				LOGGER.info("Show Bus Successfully");
			}
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong while deleting the bus details");
		}
		finally
		{
			DBUtility.getDBConnectionClose();
		}
		//System.out.println("Data Update Successfully");
		return list;
	}

	/*public Bus showBus1(int busid) throws ClassNotFoundException, SQLException {
		ArrayList<Bus> list=new ArrayList<Bus>();

		Bus bus=new Bus();
		try
		{
		Connection connection = db.getDBConnection();
		Statement statement = connection.createStatement();

	String updateData="select * from busdetails where busid="+busid+"";
	ResultSet rs=statement.executeQuery(updateData);
	//System.out.println("Bus Id,Bus Number,Bus Destination, Bus Source, Bus Seats, Bus Price");

	while(rs.next())
	{

		bus.setBusId(rs.getInt(1));
		bus.setBusNo(rs.getString(2));
		bus.setBusDestination(rs.getString(3));
		bus.setBusSource(rs.getString(4));
		bus.setBusSeat(rs.getInt(5));
		bus.setPrice(rs.getInt(6));

		//list.add(bus);
	}

	}
		catch(Exception e)
		{

		}
		finally
		{
			DBUtility.getDBConnectionClose();
		}
	//System.out.println("Data Update Successfully");
		return bus;
	}
	 */
	public int updateBusSeat(Bus bus) throws ClassNotFoundException {
		try
		{
			int busId=bus.getBusId();
			String busNo=bus.getBusNo();
			String busDestination=bus.getBusDestination();
			String busSource=bus.getBusSource();
			int busSeat=bus.getBusSeat();
			int price=bus.getPrice();

			//System.out.println("BusDaoImpl:"+busId+" +"+busSeat);

			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();

			String updateData="update busdetails set seats="+busSeat+" where busid='"+busId+"'";
			statement.executeUpdate(updateData);
			//System.out.println(updateData);
			//System.out.println("Data Update Successfully");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

		int rowUpdateCount=0;
		return rowUpdateCount;
	}


}
