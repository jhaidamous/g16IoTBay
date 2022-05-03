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
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String registration = request.getParameter("registration");
        int errval = 0;
        String errormsg = "";
        int success = 0; 
        
        if ((User)application.getAttribute(""+username+"") == null && registration == null) {
            errval = 1;
            errormsg = "Invalid username and/or password.";
        }
        else {
            User user = (User)application.getAttribute(""+username+"");
            if(username != null && password != null && registration == null) {
                if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                    success = 1; //logged in
                    session.setAttribute("login", user);
                    email = user.getEmail();
                    username = user.getUsername();
                    name = user.getName();
                    phone = user.getPhone();
                }
            else {
                errormsg = "Invalid username and/or password.";
                errval = 1;
                }
            }
        
        else if(registration != null) {
            success = 2; //registered user
            user = new User(email,name,username,password,phone);
            application.setAttribute(""+username+"", user);
            session.setAttribute("login", user);            
        }
        
        else {
            errormsg = "Please enter your username and password.";
            errval = 2;
            }
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
        <%if (success == 1 || success == 2) { %>
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
                <tr><td>Email: </td><td><%= email%></td></tr>
                <tr><td>Username: </td><td><%= username%></td></tr>                    
                <tr><td>Name: </td><td><%= name%></td></tr>
                <tr><td>Phone: </td><td><%= phone%></td></tr>
                <tr><td>Click <a href="main.jsp">here</a> to go to main page</td><td> </td></tr>
            </table>
        <% } else if (success == 1) { %>
            <p>You've successfully logged in as the below user</p>
            <table class="table">
                <tr><td>Email: </td><td><%= email%></td></tr>
                <tr><td>Username: </td><td><%= username%></td></tr>                    
                <tr><td>Name: </td><td><%= name%></td></tr>
                <tr><td>Phone: </td><td><%= phone%></td></tr>
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
