<%@page import="java.util.List"%>
<%@page import="com.realcoderz.busticket.bean.Bus" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/showbus.css">
</head>
<body>

<%List<Bus> bus = (List)request.getAttribute("bus"); %>


<center><h1>Bus Details</h1></center>
<table border="1" align="center">
	<tr id="header">
	
	<th>Bus Id</th>
	<th>Bus Number</th>
	<th>Bus Destination</th>
	<th>Source</th>
	<th>Seats</th>
	<th>Price</th>
	<th>Update</th>
	<th>Delete</th>
	
	</tr>
	<%for(Bus bus1: bus) {%>
	
		<tr>
			
			<td><%=bus1.getBusId() %></td>
			<td><%=bus1.getBusNo() %></td>
			<td><%=bus1.getBusDestination() %></td>
			<td><%=bus1.getBusSource() %></td>
			<td><%=bus1.getBusSeat() %></td>
			<td><%=bus1.getPrice() %></td>
			
			<td><a href="BusUpdate.jsp?id=<%=bus1.getBusId() %>">update</a></td>
			<td><a href="BusDelete?id=<%=bus1.getBusId() %>">delete</a>
			
		</tr>
	
	<%} %>
	</center>
</table>
<br><br><br><center><a href="AdminFunction.html">Back to Admin Home</a></center>


</body>
</html>