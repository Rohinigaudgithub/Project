package com.realcoderz.passenger.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.realcoderz.busticket.bean.Bus;
import com.realcoderz.busticket.dao.impl.BusDAOImpl;


public class Login extends HttpServlet 
{
	static final Logger LOGGER = Logger.getLogger(Login.class);
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			LOGGER.info("Admin Login Successfully");
			PrintWriter out=response.getWriter();
			String username=request.getParameter("uname");
			String password=request.getParameter("pwd");
			
			if(username.equals("rohini")&& password.equals("rohini"))
			{
				out.write("<h2> Welcome "+username+" your are login successfully</h2>");
				response.sendRedirect("AdminFunction.html");
				
			}
			else
			{
				out.write("Login Failed");
			}
					
		}
}
