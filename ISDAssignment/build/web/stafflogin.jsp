<%-- 
    Document   : Stafflogin
    Created on : 05-May-2022, 18:29:40
    Author     : Steph
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>

<!DOCTYPE html>

<head>
    <title>IoTBay - Staff Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
</head>         <%
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String logInErr = (String) session.getAttribute("logInErr");
            session.setAttribute("passErr", null);
            session.setAttribute("emailErr", null);

            session.setAttribute("logInErr", null);

        %>


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
    <div class="mainsite">
        <h1>Welcome to IoTBay</h1>
        <p>Staff Login</p>
        <form method="POST" action="/ISDAssignment/StaffLoginServlet">
            <table class="table">
                
                <tr><td>Email: </td><td><input type="text" name="emailaddress" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Login"></td></tr>
            </table>
                            <p><span class="message"> <%=(logInErr != null ? logInErr : "")%></span></p>

        </form>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
