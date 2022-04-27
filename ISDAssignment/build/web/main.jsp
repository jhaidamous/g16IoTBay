<%-- 
    Document   : main
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<head>
    <title>IoTBay - Main</title>
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
        <a href="logout.jsp">Logout</a>
        </nav>
    </header>
        <%
            User user = new User();
            if ((User)session.getAttribute("login") == null) {
                user = new User("dont try navigate to main","cause you're not logged in","not","logged","and it wont work");
            }
            else {
                user = (User)session.getAttribute("login");
            }
        %>
    <div class="mainsite">
    <h1>Welcome to IoTBay</h1>
    <p>
        This is the main page... it doesn't do much right so here, have some details
        <table class="table">
                <tr><td>Email: </td><td><%= user.getEmail()%></td></tr>                    
                <tr><td>Name: </td><td><%= user.getName()%></td></tr>
                <tr><td>Phone: </td><td><%= user.getPhone()%></td></tr>
        </table>
    </p>
    </div>
        <% 
            session.setAttribute("login", user);
        %>       
        
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
