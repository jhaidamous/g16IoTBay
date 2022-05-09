<%-- 
    Document   : welcome
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<head>
    <title>IoTBay - Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
</head>

    <% 
        Customer customer = (Customer) session.getAttribute("customer");

        String registration = request.getParameter("registration");
        int errval = 0;
        String errormsg = "";
        int success = 0;
        String emailaddress="";
        String password="";
        String firstname="";
        
        if (customer == null && registration == null) {
            errormsg = "Customer was unable to be retrived";
            errval = 1;
            }
        
       else if(customer != null && registration == null) {
            emailaddress = customer.getEmailaddress();
            firstname = customer.getFirstname();
            password = customer.getPassword();
            String phone = customer.getPhone();
            success = 1; //logged in
        }
        else if(registration != null) {
            emailaddress = customer.getEmailaddress();
            firstname = customer.getFirstname();
            password = customer.getPassword();
            String phone = customer.getPhone();
            success = 2; //registered customer
        }
        
        else {
            errormsg = "Please enter your emailaddress and password.";
            errval = 2;
            }
        
            

    %>
<html>
    <body class="bodyclass" onload="startTime()">
    <header class="toparea">
        <div class="title">
            <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
        </div>
        <nav class="navclass">
        <a href="index.jsp">Home</a>
        <%if ( success == 1 || success == 2) { %>
        <a href="store.jsp">Store</a>
        <a href="logout.jsp">Logout</a>
        <% } %>
        </nav>
    </header>

    <div class="mainsite">
        <h1>IoTBay - Welcome Page</h1>
        <% if (success == 2) { %>
            <p>You've registered an account, please see your details below</p>
            <table class="table">
                <tr><td>Email: </td><td><%= emailaddress%></td></tr>
                <tr><td>Name: </td><td><%= firstname%></td></tr>
                <tr><td>Click <a href="main.jsp">here</a> to go to main page</td><td> </td></tr>
            </table>
        <% } else if (success == 1) { %>
            <p>You're successfully logged in as the below customer</p>
            <table class="table">
                <tr><td>Email: </td><td><%= emailaddress%></td></tr>
                <tr><td>Name: </td><td><%= firstname%></td></tr>
                <tr><td>Click <a href="main.jsp">here</a> to go to main page</td><td> </td></tr>
            </table>
        <% } else { %>
            <p>An error has occurred</p>
            <table class="table">
                <tr><td><%= errormsg%></td><td>Click <a href="login.jsp">here</a> to go back to login page </td></tr>       
            </table>
        <% } %>
        
    </div>
        
    <footer class="bottomarea">
        <p id="clock" class="footer">

        </p>
    </footer>
    </body>
</html>
