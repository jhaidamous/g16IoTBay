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
    <h1>Welcome to IoTBay</h1>
    <p>Please fill in the details before to register an account</p>
        <form method="POST" action="welcome.jsp">
            <table class="table">
                <tr><td>Email: </td><td><input type="text" name="email" required="true"></td></tr>
                <tr><td>Username: </td><td><input type="text" name="username" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" required="true"></td></tr>
                <tr><td>Name: </td><td><input type="text" name="name" required="true"></td></tr>
                <tr><td>Phone: </td><td><input type="text" name="phone" required="true"></td></tr>
                <tr><td></td><td><input type="hidden" value="registration" name="registration"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Sign Up"></td></tr>
            </table>
        </form>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
