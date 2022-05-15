<%-- 
    Document   : logout
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<head>
    <title>IoTBay - Logout</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/LogoutServlet" flush="true" />
</head>
<html>
    <body class="bodyclass" onload="startTime()">
    <header class="toparea">
        <div class="title">
            <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
        </div>
        <nav class="navclass">
        <a href="index.jsp">Home</a>
        </nav>
    </header>
    <div class="mainsite">
        <h1>Thank you</h1>
        <p>You have logged out. Click <a href="index.jsp">here</a> to go home</p>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
    <% session.invalidate();%>

</html>

        
