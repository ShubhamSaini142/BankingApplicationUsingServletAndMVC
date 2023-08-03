<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Details</title>
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

    .loan-details {
        max-width: 500px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff; /* White color */
        border-radius: 5px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    .loan-details p {
        margin: 10px;
    }

    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }
</style>
</head>
<body>
    <div class="loan-details">
        <h1>Loan Details</h1>
        <%
        session = request.getSession();
        int s1 = (int) session.getAttribute("lid");
        String s2 = (String) session.getAttribute("ltype");
        int s3 = (int) session.getAttribute("tenure");
        Float s4 = (Float) session.getAttribute("interest");
        String s5 = (String) session.getAttribute("description");
        %>
        <p>Loan ID: <%= s1 %></p>
        <p>Loan Type: <%= s2 %></p>
        <p>Loan Tenure: <%= s3 %> months</p>
        <p>Loan Interest: <%= s4 %>%</p>
        <p>Loan Description: <%= s5 %></p>
    </div>
</body>
</html>
