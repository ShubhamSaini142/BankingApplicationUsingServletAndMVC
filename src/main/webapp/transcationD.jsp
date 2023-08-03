<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.PreparedStatement"%>

<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Transaction History</title>

</head>

<body>

 

    <%

    int acc_no = (int) session.getAttribute("accno");

    String url = "jdbc:mysql://localhost:3306/banking";

    String user = "root";

    String pwd = "root";

 

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, pwd);

 

        PreparedStatement pstmt = con.prepareStatement(

        "select * from transferdata where sender_accno = ? order by transation_Id desc");

        pstmt.setInt(1, acc_no);


 

        ResultSet resultSet = pstmt.executeQuery();

 

        while (resultSet.next()) {

          out.println("custmer_id" + resultSet.getInt(1) + "<br>");
          out.println("bank_name"+resultSet.getString(2)+ "<br>");
          out.println("IFSC" + resultSet.getString(3)+ "<br>");
          out.println("senderAccount" + resultSet.getInt(4)+ "<br>");
          out.println("reciever_ifsc" + resultSet.getString(5)+ "<br>"); 
          out.println("reciever_accn" + resultSet.getInt(6)+ "<br>");
          out.println("amount" + resultSet.getInt(7)+ "<br>");
          out.println( "transation_Id" + resultSet.getInt(8)+ "<br>");

 

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    %>

    <br><br>

<a href="HomePage.jsp">Go To Home</a>

 

</body>

</html>

has context menu