<%@page import="com.realcoderz.busticket.bean.Passenger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./resources/css/register.css">
</head>
<body>
<%Passenger passenger = (Passenger)session.getAttribute("passenger"); %>
<div class="main">
<div class="register">
<h2>Passenger Edit Page</h2>
<form action="updatepassenger" id="register" method="post">

<input type="hidden" name="id" value="${passenger.passengerid }">

<label>Passenger Name</label>
<br>
<input type="text" name="pname" id="name" value="${passenger.passengername}" placeholder="Enter Your Name">
<br><br>
<label>Passenger Address</label>
<br>
<input type="text" name="padd" id="name" value="${passenger.passengeradd}" placeholder="Enter Your Username">
<br><br>
<label>Passenger Mobile No</label>
<br>
<input type="number" name="mobno" id="name" value="${passenger.mobileno}" placeholder="Enter Your Password">
<br><br>
<label>Passenger Destination</label>
<br>
<input type="text" name="destination" id="name" value="${passenger.destination}" placeholder="Enter Your Address">
<br><br>
<input type="submit" id="submit" value="Update"> 
</form>
</div>
</div>

</body>
</html>