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
    <title>IoTBay - Edit Account</title>
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
            Customer customer = new Customer();
            if ((Customer)session.getAttribute("customer") == null) {
                customer = new Customer(1, "dont try navigate to main","cause you're not logged in","not","logged","and it wont work", "hello", "hi", false);
            }
            else {
                customer = (Customer)session.getAttribute("customer");
            }
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String firstNameErr = (String) session.getAttribute("firstNameErr");
            String lastNameErr = (String) session.getAttribute("lastNameErr");
            String middleNameErr = (String) session.getAttribute("middleNameErr");
            String dobErr = (String) session.getAttribute("dobErr");
            String phoneErr = (String) session.getAttribute("phoneErr");

        %>
    <div class="mainsite">
    <h1>Welcome to IoTBay</h1>
    <p>
        <p>Please fill in the details before to edit your account details</p>
        <form method="POST" action="/ISDAssignment/UpdateAccServlet">
            <table class="table">
                <tr><td>Email: </td><td><input type="text" name="emailaddress" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required="true"></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" placeholder="<%=(firstNameErr != null ? firstNameErr : "Enter first name")%>" required="true"></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" placeholder="<%=(lastNameErr != null ? lastNameErr : "Enter last name")%>" required="true"></td></tr>
                <tr><td>Middle Name: </td><td><input type="text" name="middlename" placeholder="<%=(middleNameErr != null ? middleNameErr : "Optional")%>" required="false"></td></tr>
                <tr><td>Phone: </td><td><input type="text" name="phone" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone")%>" required="true"></td></tr>
                <tr><td>Date of Birth: </td><td><input type="text" name="dob" placeholder="hi" required="true"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Update Details"></td></tr>
                
            </table>
                <span class="message"> <%=(existErr != null ? existErr : "")%></span>
        </form>
         <a href = "/ISDAssignment/UpdateAccServlet">Delete Account</a>
        
            
    </p>
    </div>
        <% 
            session.setAttribute("login", customer);
        %>       
        
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
