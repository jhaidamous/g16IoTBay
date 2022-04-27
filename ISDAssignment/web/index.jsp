<%-- 
    Document   : index
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Homepage</title>
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
        <a href="register.jsp">Register</a>
        </nav>
    </header>
    <div class="mainsite">
        <h1>Welcome to IoTBay</h1>
        <% 
            String name = "G16, ISD Autumn 2022";        
        %>
        <p>Group: <%= name%> </p>
        <p>Random ID: <%= new Random().nextInt(999999) %></p>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer">

        </p>
    </footer>
    </body>
</html>
