<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/UpdateBus.css">
</head>
<body>
<%
session.setAttribute("id", request.getParameter("id"));
%>

<center>
<div class="main">
<div class="register">
<h2>Update Bus Details</h2>
<form action="updatebus" method="post">
<table>
<tr><td>Bus Destination</td>
<td><input type="text" id="name" name="busdestination" placeholder="Enter Bus Destination"><br><br></td>
</tr>
<br>
<tr><td>Bus Source</td>
<td><input type="text" id="name" name="bussource" placeholder="Enter Bus Source"><br><br></td>
</tr>

<tr><td>Bus Seats</td>
<td><input type="number" id="name" name="busseats" placeholder="Enter Bus Seat"><br><br></td>
</tr>
<tr><td>Seat Price</td>
<td><input type="number" id="name" name="busprice" placeholder="Enter Seat Price"><br><br></td>
</tr>

</table>
<br><input type="submit" id="submit" id="name" value="Update"> 
</form>


</div>
</div>
</center>
</body>
</html>