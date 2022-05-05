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
        
           <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String middleNameErr = (String) session.getAttribute("middleNameErr");
            String dobErr = (String) session.getAttribute("dobErr");
            String phoneErr = (String) session.getAttribute("phoneErr");
        %>
    <h1>Welcome to IoTBay</h1>
    <p>Please fill in the details before to register an account</p>
        <form method="POST" action="/RegisterServlet">
            <table class="table">
                <tr><td>Email: </td><td><input type="text" name="emailaddress" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(emailErr != null ? emailErr : "Enter password")%>" required="true"></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" placeholder="<%=(emailErr != null ? emailErr : "Enter first name")%>" required="true"></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" placeholder="<%=(emailErr != null ? emailErr : "Enter last name")%>" required="true"></td></tr>
                <tr><td>Middle Name: </td><td><input type="text" name="middlename" placeholder="<%=(emailErr != null ? emailErr : "Optional")%>" required="false"></td></tr>
                <tr><td>Phone: </td><td><input type="text" name="phone" placeholder="<%=(emailErr != null ? emailErr : "Enter phone")%>" required="true"></td></tr>
                <tr><td>Date of Birth: </td><td><input type="date" name="dob" placeholder="<%=(emailErr != null ? emailErr : "Enter DOB")%>" required="true"></td></tr>
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
