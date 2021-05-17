<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.setAttribute("id", request.getParameter("id"));
%>
<center>
<h2>Delete Bus Details</h2>
<form action="deletebus" method="post">
<table>
<tr><td>Bus Id</td>
<td><input type="number" name="busid"></td>
</tr>
</table>
<br><input type="submit" value="Delete"> 
</form>
</center>
</body>
</html>