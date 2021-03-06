<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>Staff - My Account</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/SearchServlet" flush="true" />
</head>
<% 
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
                <% if  (staff != null) { %>
                <a href="logout.jsp">Logout</a>
                <% } else { %>
                <% }%>
            </nav>
        </header>
        <div class="mainsite">
            <h1>Welcome to Staff Portal</h1>
            <% if(staff == null) { %>
            <p>You do not have access to this page.</p>
            <%} else { %>
            <table class="table">
                <tr><td><a href='staffCatalog.jsp' class="buttonn">Edit Store Catalog</a></td></tr>
            </table>
            <% } %>
        </div>
            <footer class="bottomarea">
                <p id="clock" class="footer">
                </p>
            </footer>
    </body>
</html>