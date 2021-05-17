package com.realcoderz.junit_testing;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.service.impl.BusServiceImpl;
//@FixMethodOrder(OrderAnnotation.class)
public class BusDAOImplTest {
	BusServiceImpl busService=new BusServiceImpl();
	public static Bus bus=new Bus();
	
	@Test
	public void Test1() throws ClassNotFoundException, SQLException
	{
		bus.setBusId(112);
		bus.setBusNo("DL1258");
		bus.setBusDestination("Anand Vihar");
		bus.setBusSource("Vivek Vihar");
		bus.setBusSeat(20);
		bus.setPrice(30);
		int count=busService.insertBus(bus);
		assertEquals("Insert Bus Success",1,count);
	}
	
	@Test
	public void Test3() throws ClassNotFoundException, SQLException
	{
		
		bus.setBusNo("DL1258");
		bus.setBusDestination("Preet Vihar");
		bus.setBusSource("Geeta Colony");
		bus.setBusSeat(70);
		bus.setPrice(60);
		int updateBus=busService.updateBus(bus);
		assertEquals("Update Bus Success",1,updateBus);
	}
	
	@Test
	public void Test4() throws ClassNotFoundException, SQLException
	{
		
		int deleteBusTest=busService.deleteBus(bus);
		assertEquals(1,deleteBusTest);
	}
	
	@Test
	public void Test2() throws ClassNotFoundException, SQLException
	{
		int count=busService.insertBus(bus);
		assertEquals("Insert Bus Fail",0,count);
	}
	
	/*@Test 
	public void Test4() throws ClassNotFoundException, SQLException
	{
	
		bus.setBusNo("DL1258");
		bus.setBusDestination("Preet Vihar");
		bus.setBusSource("Geeta Colony");
		bus.setBusSeat(70);
		bus.setPrice(60);
		int updateBus=busService.updateBus(bus);
		assertEquals("Update Bus Fail",0,updateBus);
	}
	*/
	@Test
	public void Test5() throws ClassNotFoundException, SQLException
	{
		int deleteBusTest=busService.deleteBus(bus);
		assertEquals(0,deleteBusTest);
	}
	

	
	
	
/*	@Test
	public void insertBusSuccessfully() throws ClassNotFoundException, SQLException 
	{
		BusServiceImpl busService=new BusServiceImpl();
		int actual=busService.insertBus(bus);
		flag=1;
		int expected=1;
		assertEquals(expected,actual);
	}
	
	@Test
	public void updateBusSuccessfully() throws ClassNotFoundException, SQLException 
	{
		BusServiceImpl busService=new BusServiceImpl();
		Bus bus=new Bus();
		bus.setBusId(107);
		bus.setBusDestination("Mandawali");
		bus.setBusSource("Anand Vihar");
		bus.setBusSeat(30);
		bus.setPrice(25);
		
		int actual=busService.updateBus(bus);
		int expected = 1;
		assertEquals(expected,actual);
	}
	*/
	
	/*@Test
	public void insertBusSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(104);
		System.out.println("Insert Bus Success");
		bus.setBusNo("DL78415");
		bus.setBusDestination("Nagloi");
		bus.setBusSource("Seelampur");
		bus.setBusSeat(25);
		bus.setPrice(20);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.insertBus(bus);
		//System.out.println(rowUpdateCount);
		assertEquals(1,flag);
	}
	
	@Test
	public void insertBusFailed() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(104);
		bus.setBusNo("DL78415");
		bus.setBusDestination("Nagloi");
		bus.setBusSource("Seelampur");
		bus.setBusSeat(25);
		bus.setPrice(20);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.insertBus(bus);
		assertEquals(0,flag);
	}
	
	
	@Test
	public void updateBusSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(109);
		bus.setBusDestination("FirozNagar");
		bus.setBusSource("Gokalpur");
		bus.setBusSeat(30);
		bus.setPrice(25);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.updateBus(bus);
		assertEquals(1,flag);
	}
	
	@Test
	public void updateBusFailed() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(107);
		bus.setBusDestination("Mandawali");
		bus.setBusSource("Anand Vihar");
		bus.setBusSeat(30);
		bus.setPrice(25);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.updateBus(bus);
		assertEquals(0,flag);
	}
	
	
	@Test
	public void deleteBusSuccessfully() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(104);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.deleteBus(bus);
		//System.out.println(flag);
		assertEquals(1,flag);
	}
	
	@Test
	public void deleteBusFailed() throws ClassNotFoundException, SQLException 
	{
		Bus bus=new Bus();
		bus.setBusId(103);
		BusServiceImpl busService=new BusServiceImpl();
		int flag=busService.deleteBus(bus);
		assertEquals(0,flag);
	}*/
	
		


	
}
