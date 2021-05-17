<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Delete</title>
<link rel="stylesheet" type="text/css" href="./resources/css/register.css">
</head>
<body>
<%
session.setAttribute("id", request.getParameter("id"));
%>
<div class="main">
<div class="register">
<h2>Delete Passenger Details</h2>
<form action="deletepassenger" id="register" method="post">
<label>Passenger Id</label>
<br>
<input type="number" name="id" id="name" placeholder="Enter Your Id">
<br><br>
<input type="submit" id="submit" value="Delete"> 
</form>
</div>
</div>
</body>
</html>