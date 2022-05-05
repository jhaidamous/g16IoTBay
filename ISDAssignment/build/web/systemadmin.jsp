<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Register</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
</head>
<html>
    <body class="bodyclass" onload="startTime()">
    <header class="toparea">
        <div class="title">
            <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
        </div>
        <nav class="navclass">
        <a href="index.jsp">Home</a>
        <a href="login.jsp">Login</a>
        </nav>
    </header>
    <div class="mainsite">
    <h1>Welcome to System Admin Portal</h1>
    <p>Create new customer record</p>
        <form method="POST" action="SystemAdmin.jsp">
            <table class="table">
                <form method="POST" action="welcome.jsp">
                <tr><td>Name: </td><td><input type="text" name="name" required="true"></td></tr>
                <tr><td>Email: </td><td><input type="text" name="email" required="true"></td></tr>
                <tr><td>Type: </td><td><input type="text" name="Type" required="true"></td></tr>
                <tr><td>Address: </td><td><input type="text" name="Address" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Create Record"></td></tr>
            </table>
            </form>
            
     <h2>Search current records</h2>
        <form method="POST" action="SystemAdmin.jsp">
            <table class="table">
                <form method="POST" action="welcome.jsp">
                <tr><td>Customer Name: </td><td><input type="text" name="name" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>
            </table>
            </form>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>