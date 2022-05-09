<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>

<head>
    <title>IoTBay - Login</title>
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
        <a href="register.jsp">Register</a>
        </nav>
    </header>
        
         <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String logInErr = (String) session.getAttribute("logInErr");
        %>

    <div class="mainsite">
        <h1>Welcome to IoTBay</h1>
        <p>Please fill your account details to login</p>
        <form method="POST" action="/ISDAssignment/LoginServlet">
            <table class="table">
                <tr><td>Email: </td><td><input type="text" name="emailaddress" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Login"></td></tr>
            </table>
            <span class="message"> <%=(logInErr != null ? logInErr : "")%></span>
   
        </form>
    </div>
        <div class ="stafflogin">
            <form method="POST" action="stafflogin.jsp">
                <input class="button" type="submit" value="Staff Login">
            </form>
        </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
