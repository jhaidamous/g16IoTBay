<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Shipment Details</title>
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
    <h1>Shipment Details</h1>
    <p>Create new Shipment Details record</p>
        <form method="POST" action="SystemAdmin.jsp">
            <table class="table">
                <form method="POST" action="welcome.jsp">
                <tr><td>Street Number: </td><td><input type="text" name="name" required="true"></td></tr>
                <tr><td>Street Name: </td><td><input type="text" name="email" required="true"></td></tr>
                <tr><td>Suburb: </td><td><input type="text" name="Type" required="true"></td></tr>
                <tr><td>Postcode: </td><td><input type="text" name="Address" required="true"></td></tr>
                <tr><td>State: </td><td><input type="text" name="Address" required="true"></td></tr>
                <tr><td>Country: </td><td><input type="text" name="Address" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Create Record"></td></tr>
            </table>
            </form>
            
     <h2>Delete a customer record</h2>
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