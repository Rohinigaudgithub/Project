package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	public static final String url="jdbc:mysql://localhost:3306/BusTicketManagement";
	public static final String username="root";
	public static final String password="system";
	public static Connection connection=null;

	
	public static Connection getDBConnection() throws ClassNotFoundException,SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver");
		//System.out.println("Driver Registered");
		connection= DriverManager.getConnection(url, username, password);
		//System.out.println("Connection Established");
		DatabaseMetaData databaseMetaData=connection.getMetaData();
		//System.out.println("JDBC Version" + databaseMetaData.getJDBCMajorVersion());
		return connection;
		}
	public static void getDBConnectionClose() throws SQLException
	{
		if(connection!=null)
		{
		connection.close();
		}
	}
	}