<%@page import="java.util.List"%>
<%@page import="com.realcoderz.busticket.bean.Bus" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/ShowBusPassenger.css">
</head>
<body>


<!--  <script>

function searchbusdata(bus)
{
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	{
		document.getElementById("success").innerHTML=xmlhttp.responseText;
	}
	xmlhttp.open("POST","./BookTicket?g="+bus,true)
	xmlhttp.send();
}
</script>-->


<%List<Bus> bus = (List)request.getAttribute("bus"); %>


<center><h1>Bus Details</h1></center>
<a href="PassengerLoginSuccess.html">Back to Passenger Home</a>
<table border="1" align="center">
	<tr>
	
	<th>Bus Id</th>
	<th>Bus Number</th>
	<th>Bus Destination</th>
	<th>Source</th>
	<th>Seats</th>
	<th>Price</th>
	<th>Book Ticket</th>
	
	
	
	</tr>
	<%for(Bus bus1: bus) {
	
	if(bus1.getBusSeat()>0)
	{%>
			
		<tr>
			<td><%=bus1.getBusId() %></td>
			<td><%=bus1.getBusNo() %></td>
			<td><%=bus1.getBusDestination() %></td>
			<td><%=bus1.getBusSource() %></td>
			<td><%=bus1.getBusSeat() %></td>
			<td><%=bus1.getPrice() %></td>
			<td>
			
			<form method="post" action="./busticketbook">
			
			<input type="hidden" name = "busId" value="<%=bus1.getBusId()%>">
			<!-- <input type="number" name="noOfSeat" id="noOfSeats" placeholder="Enter the no of seat" onkeyup="searchbusdata(this.value)"><br><br> -->
			<input type="number" name="noOfSeat" placeholder="Enter the no of seat"><br><br>
			<input type="submit" id="submit" value="Book">
			</form>
			
			</td>
			
			
		</tr>
		
	<%
	
	//session.setAttribute("bus", bus1);
	}} %>
	<%-- <a href="BookTicket.jsp?id=<%=bus1.getBusId()%>">Book</a> --%>
	
</table>
</center>
		

<div id="success"></div>


</body>
</html>