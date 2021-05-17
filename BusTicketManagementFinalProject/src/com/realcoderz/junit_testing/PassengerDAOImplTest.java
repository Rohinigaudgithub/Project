package com.realcoderz.junit_testing;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import com.realcoderz.busticket.bean.Passenger;
import com.realcoderz.busticket.service.impl.PassengerServiceImpl;
public class PassengerDAOImplTest {

	PassengerServiceImpl passengerService=new PassengerServiceImpl();
	public static Passenger passenger=new Passenger();
	
	
	@Test
	public void Test1() throws ClassNotFoundException, SQLException
	{
		passenger.setPassengerid(115);
		passenger.setPassengername("Rajat");
		passenger.setUsername("Rajat@1234");
		passenger.setPassword("Rajat123");
		passenger.setPassengeradd("Saroj Nagar");
		passenger.setMobileno(784545);
		passenger.setDestination("Karol Bagh");
		int count=passengerService.insertPassenger(passenger);
		assertEquals("Insert Passenger Success",1,count);
	}
	
	@Test
	public void Test3() throws ClassNotFoundException, SQLException
	{
		
		passenger.setPassengername("Priyanka");
		passenger.setUsername("Priyanka@123");
		passenger.setPassword("Priyanka123");
		passenger.setPassengeradd("Karol Bagh");
		passenger.setMobileno(78181484);
		passenger.setDestination("Badarpur");
		int count=passengerService.updatePassenger(passenger);
		assertEquals("Update Passenger Success",1,count);
	}
	
	@Test
	public void Test4() throws ClassNotFoundException, SQLException
	{
		int count=passengerService.deletePassenger(passenger);
		assertEquals("Delete Bus Success",1,count);
	}
	
	@Test
	public void Test2() throws ClassNotFoundException, SQLException
	{
		int count=passengerService.insertPassenger(passenger);
		assertEquals("Insert Passenger Success",0,count);
	}
	
	@Test
	public void Test5() throws ClassNotFoundException, SQLException
	{
		int count=passengerService.deletePassenger(passenger);
		assertEquals("Delete Bus Success",0,count);
	}
	
		

	
	/*@Test
	public void insertPassengerSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(107);
		passenger.setPassengername("Kajal");
		passenger.setUsername("Kajal@123");
		passenger.setPassword("Kajal123");
		passenger.setPassengeradd("Nagloi");
		passenger.setMobileno(9552659);
		passenger.setDestination("Jyoti Nagar");
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.insertPassenger(passenger);
		assertEquals(1,count);
	}
	@Test
	public void insertPassengerFailed() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(107);
		passenger.setPassengername("Kajal");
		passenger.setUsername("Kajal@123");
		passenger.setPassword("Kajal123");
		passenger.setPassengeradd("Nagloi");
		passenger.setMobileno(9552659);
		passenger.setDestination("Jyoti Nagar");
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.insertPassenger(passenger);
		assertEquals(0,count);
	}
	
	
	@Test
	public void updatePassengerSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(105);
		passenger.setPassengername("Rohini");
		passenger.setUsername("Rohini@123");
		passenger.setPassword("Rohini123");
		passenger.setPassengeradd("Kanpur");
		passenger.setMobileno(784154);
		passenger.setDestination("Mumbai");
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.updatePassenger(passenger);
		assertEquals(1,count);
	}
	@Test
	public void updatePassengerFailed() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(105);
		passenger.setPassengername("Rohini");
		passenger.setUsername("Rohini@123");
		passenger.setPassword("Rohini123");
		passenger.setPassengeradd("Kanpur");
		passenger.setMobileno(784154);
		passenger.setDestination("Mumbai");
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.updatePassenger(passenger);
		assertEquals(0,count);
	}
	
	@Test
	public void deletePassengerSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(104);
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.deletePassenger(passenger);
		assertEquals(1,count);
	}
	@Test
	public void deletePassengerFailed() throws ClassNotFoundException, SQLException 
	{
		Passenger passenger=new Passenger();
		passenger.setPassengerid(104);
		PassengerServiceImpl passengerService=new PassengerServiceImpl();
		int count=passengerService.deletePassenger(passenger);
		assertEquals(0,count);
	}
	*/
	

}
