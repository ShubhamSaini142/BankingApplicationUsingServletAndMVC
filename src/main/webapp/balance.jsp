<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
   <link rel="stylesheet" href="balance.css">

</head>
<body>
<%
session = request.getSession();
int s1 = (int) session.getAttribute("balance");
out.println(" Balance " + s1);
%> 
<a href = "HomePage.jsp">GO BACK</a>
</body>
</html>