package com.realcoderz.busticket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.dao.PassengerDao;

import util.DBUtility;

public class PassengerDAOImpl implements PassengerDao {
	static final Logger LOGGER = Logger.getLogger(PassengerDAOImpl.class);
	//Passenger data=new Passenger();
	DBUtility db=new DBUtility();
	
	public int insertPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside InsertPassenger Method from PassengerDAOImpl ");
		int rowUpdateCount=0;
		try
		{
			int passengerId=passenger.getPassengerid();
			String passengerName=passenger.getPassengername();
			String passengerUsername=passenger.getUsername();
			String passengerPassword=passenger.getPassword();
			String passengerAdd=passenger.getPassengeradd();
			int mobileNo=passenger.getMobileno();
			String destination=passenger.getDestination();
			
			Connection connection=db.getDBConnection();
			Statement stmt = connection.createStatement();
			LOGGER.info("Connection Established for Add Passenger");
			//System.out.println(stmt);
			rowUpdateCount=stmt.executeUpdate("INSERT INTO passenger (passengerid,passengername,passengerusername,passengerpassword,passengeradd,passengermobileno,passengerdestination) values"
			+ "("+passengerId+",'"+passengerName+"','"+passengerUsername+"','"+passengerPassword+"','"+passengerAdd+"',"+mobileNo+",'"+destination+"')");
			
			if(rowUpdateCount==1)
			{
				LOGGER.info("Passenger Add Successfully");
			//System.out.println(" Passenger Register Successfully ");
			}
			else
			{
				LOGGER.info("Passenger do not add Successfully");
				//System.out.println("******Data do not add properly**************");
			}
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while inserting the passenger data");
			System.out.println(e);
			//throw e;
		}
		finally
		{
			return rowUpdateCount;
		}
		}
		
	public int updatePassenger(Passenger passenger) throws ClassNotFoundException {
		LOGGER.info("Inside UpdatePassenger Method from PassengerDAOImpl ");
		int rowUpdateCount=0;
		try
		{
			int passengerId=passenger.getPassengerid();
			String passengerName=passenger.getPassengername();
			String passengerAdd=passenger.getPassengeradd();
			int mobileNo=passenger.getMobileno();
			String destination=passenger.getDestination();
			
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Update Passenger");
			
		String updateData="update passenger set passengername='"+passengerName+"',passengeradd='"+passengerAdd+"',passengermobileno="+mobileNo+",passengerdestination='"+destination+"' where passengerid='"+passengerId+"'";
		rowUpdateCount = statement.executeUpdate(updateData);
		LOGGER.info("Update Passenger Successfully");
		//System.out.println("Data Update Successfully");
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while updating the passenger data");
			System.out.println(e);
		}

			return rowUpdateCount;
		}
	
	public int readPassenger() throws ClassNotFoundException, SQLException {
		return 0;
		
	}

	@Override
	public int deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside DeletePassenger Method from PassengerDAOImpl ");
		int rowUpdateCount=0;
		try
		{
			int passengerId=passenger.getPassengerid();
			
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Delete Passenger");
			
		String deleteData="delete from passenger where passengerid="+passengerId+"";
		rowUpdateCount=statement.executeUpdate(deleteData);
		LOGGER.info("Passenger Delete Successfully");
		//System.out.println("Passenger Data Delete Successfully");
		}
		catch(SQLException e)
		{
			LOGGER.info("Something went wrong while updating the passenger data");
			System.out.println(e);
		}
			return rowUpdateCount;
		
	}
	
	// Show Passenger Details
	
	@Override
	public ArrayList<Passenger> showPassenger() throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside ShowPassenger Method from PassengerDAOImpl");
		ArrayList<Passenger> list=new ArrayList<Passenger>();

		try {
			Connection connection = db.getDBConnection();
			Statement statement = connection.createStatement();
			LOGGER.info("Connection Established for Show Passenger");
	String updateData="select * from passenger";
	ResultSet rs=statement.executeQuery(updateData);
	//System.out.println("result ser"+rs);
	//System.out.println("Passenger Id,Passener Name,Passenger Address, Mobile No, Destination");
	//list.add(updateData);
	while(rs.next())
	{
		Passenger passenger=new Passenger();
		
		passenger.setPassengerid(rs.getInt(1));
		passenger.setPassengername(rs.getString(2));
		passenger.setUsername(rs.getString(3));
		passenger.setPassword(rs.getString(4));
		passenger.setPassengeradd(rs.getString(5));
		passenger.setMobileno(rs.getInt(6));
		passenger.setDestination(rs.getString(7));
		
		list.add(passenger);
		LOGGER.info("Show Passenger Successfully");
	     }
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong while updating the passenger data");
		}
		finally
		{
			DBUtility.getDBConnectionClose();
		}
	
		return list; 
	
	//System.out.println("Data Update Successfully");
		
	}
	/*public Passenger showPassenger1(int id) throws ClassNotFoundException, SQLException {
		Connection connection = db.getDBConnection();
		Statement statement = connection.createStatement();
		int a=0;
		
	String updateData="select * from passenger where passengerid="+id+"";
	ResultSet rs=statement.executeQuery(updateData);
	//System.out.println("Passenger Id,Passener Name,Passenger Address, Mobile No, Destination");
	 Passenger passenger=new Passenger();
	while(rs.next())
	{
		passenger.setPassengerid(rs.getInt(1));
		passenger.setPassengername(rs.getString(2));
		passenger.setUsername(rs.getString(3));
		passenger.setPassword(rs.getString(4));
		passenger.setPassengeradd(rs.getString(5));
		passenger.setMobileno(rs.getInt(6));
		passenger.setDestination(rs.getString(7));
		//a=Integer.parseInt(rs.getString("count"));
	}
	//System.out.println("Data Update Successfully");
	
		return passenger;
	}*/
	

}

