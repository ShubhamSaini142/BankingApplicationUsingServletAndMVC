<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(45deg, #FEE715, #FFDAB9);
        animation: fadeIn 1s;
    }

    h1 {
        color: #101820; /* Charcoal color */
        text-align: center;
        padding: 20px 0;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
    }

    .welcome-message {
        color: #101820; /* Charcoal color */
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
    }

    .menu-container {
        text-align: center;
        margin-top: 30px;
    }

    .menu {
        display: inline-block;
    }

    .menu a {
        display: block;
        margin: 10px;
        padding: 10px 20px;
        text-decoration: none;
        color: #101820; /* Charcoal color */
        background-color: #fff; /* White color */
        border-radius: 4px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        transition: background-color 0.2s, transform 0.2s;
    }

    .menu a:hover {
        background-color: #FEE715; /* Yellow color */
        transform: scale(1.05);
    }

    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }
</style>
</head>
<body>
    <h1>WELCOME TO THE BANK</h1>
    <%
    session = request.getSession();
    String s1 = (String)session.getAttribute("cust_name");
    out.println("<div class='welcome-message'>" + s1 + " , welcome to your account</div>");
    %>
    <div class="menu-container">
        <div class="menu">
            <a href="Checkbalance">Check Balance</a>
            <a href="ChangePassword.html">Change Password</a>
            <a href="loan.jsp">Take Loan</a>
            <a href="transfermoney.html">Transfer Money</a>
               <a href="transcationD.jsp">Transfer History</a>
            <a href="logout">Logout</a>
        </div>
    </div>
</body>
</html>
