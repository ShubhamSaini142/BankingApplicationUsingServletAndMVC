<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #101820; /* Charcoal */
        animation: fadeIn 1s;
    }

    form {
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    form label {
        display: block;
        color: #FEE715; /* Yellow */
        font-weight: bold;
    }

    form input[type="text"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        transition: border-color 0.2s;
    }

    form input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        margin-top: 20px;
        background-color: #FEE715; /* Yellow */
        color: #101820; /* Charcoal */
        border: none;
        border-radius: 4px;
        box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        cursor: pointer;
        transition: background-color 0.2s, transform 0.2s;
    }

    form input[type="submit"]:hover {
        background-color: #FFEEAD; /* Lighter Yellow on hover */
        transform: scale(1.05);
    }

    @keyframes fadeIn {
        from { opacity: 0; }
        to { opacity: 1; }
    }
</style>
</head>
<body>
    <form action="loan">
        <label>1. Home Loan</label><br>
        <label>2. Education Loan</label><br>
        <label>3. Vehicle Loan</label><br>
        <label>4. Gold Loan</label><br>
        <label>5. Personal Loan</label><br>
        Choose Your Option<br>
        <input type="text" name="option"><br><br>
        <input type="submit">
    </form>
</body>
</html>
