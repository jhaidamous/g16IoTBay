<%-- 
    Document   : index
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>
<head>
    <title>IoTBay - Homepage</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <jsp:include page="/ConnServlet" flush="true"/>

</head>
<%
    String name = "G16, ISD Autumn 2022";
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
%>
<html>
    <body class="bodyclass" onload="startTime()">
        <header class="toparea">
            <div class="title">
                <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
            </div>
            <nav class="navclass">
                <a href="index.jsp">Home</a>
                <a href="store.jsp">Store</a>
                <% if (customer != null) { %>
                <a href="main.jsp">My Account</a> 
                <a href="logout.jsp">Logout</a>
                <% } else if  (staff != null) { %>
                <a href="staffmain.jsp">Staff Portal</a> 
                <a href="logout.jsp">Logout</a>
                <% } else { %>
                <a href="login.jsp">Login</a>
                <a href="register.jsp">Register</a>
                <% }%>
            </nav>
        </header>
        <div class="mainsite">
            <h1>Welcome to IoTBay</h1>

            <h2>Group: <%= name%> </h2>
            <p>Desgined by: Jonathan H, Vu H, Anas A, Stephen B, Steven N, Navid C</p>    
        </div>
        <footer class="bottomarea">
            <p id="clock" class="footer">
            </p>
        </footer>
    </body>
</html>
