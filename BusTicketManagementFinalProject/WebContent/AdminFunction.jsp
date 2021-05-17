<%@page import="java.util.List"%>
<%@page import="com.realcoderz.busticket.bean.Passenger" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/ShowPassenger.css">
</head>
<body>
<%List<Passenger> passengers = (List)request.getAttribute("passengers"); %>


<center><h1>Passenger Details</h1></center>
<table border="1" align="center">
	<tr>
	<th>Passenger Id</th>
	<th>Passenger Name</th>
	<th>Passenger Username</th>
	<th>Passenger Password</th>
	<th>Passenger Address</th>
	<th>Passenger Mobile No</th>
	<th>Passenger Destination</th>
	<th>Delete</th>
	</tr>
	<%for(Passenger passenger: passengers) {%>
	
		<tr>
		
			<td><%=passenger.getPassengerid() %></td>
			<td><%=passenger.getPassengername() %></td>
			<td><%=passenger.getUsername() %></td>
			<td><%=passenger.getPassword() %></td>
			<td><%=passenger.getPassengeradd() %></td>
			<td><%=passenger.getMobileno() %></td>
			<td><%=passenger.getDestination() %></td>
			<td><a href="PassengerDeleteAdmin?id=<%=passenger.getPassengerid() %>">delete</a></td>
			
		</tr>
	
	<%} %>
	</center>
</table>
<br><br><br><center><a href="AdminFunction.html">Back to Admin Home</a></center>

</body>
</html>