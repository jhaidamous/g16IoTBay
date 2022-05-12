<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Register</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/SearchServlet" flush="true" />
</head>
<% ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("customers"); 
ArrayList<Customer> custsearchlist = (ArrayList<Customer>) session.getAttribute("custsearchlist");
%>
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
    <h1>Welcome to System Admin Portal</h1>
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
    <p>Create new customer record</p>
            <form method="POST" action="/ISDAssignment/RegisterServlet1">
            <table class="table">
                <tr><td>Email: </td><td><input type="text" name="emailaddress" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" required="true"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" required="true"></td></tr>
                <tr><td>First Name: </td><td><input type="text" name="firstname" placeholder="<%=(firstNameErr != null ? firstNameErr : "Enter first name")%>" required="true"></td></tr>
                <tr><td>Last Name: </td><td><input type="text" name="lastname" placeholder="<%=(lastNameErr != null ? lastNameErr : "Enter last name")%>" required="true"></td></tr>
                <tr><td>Middle Name: </td><td><input type="text" name="middlename" placeholder="<%=(middleNameErr != null ? middleNameErr : "Optional")%>" required="false"></td></tr>
                <tr><td>Phone: </td><td><input type="text" name="phone" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone")%>" required="true"></td></tr>
                <tr><td>Date of Birth: </td><td><input type="text" name="dob" placeholder="hi" required="true"></td></tr>
                <tr><td></td><td><input type="hidden" value="registration" name="registration"></td></tr>
                <tr><td></td><td><input type="hidden" value="/systemadmin.jsp" name="respurll"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Create"></td></tr>
            </table>
                <span class="message"> <%=(existErr != null ? existErr : "")%></span>
            </form>
            
     <h2>Search current records</h2>
        <form method="POST" action="/ISDAssignment/SearchServlet">
            <table class="table">
                <tr><td>Customer Name: </td><td><input type="text" name="custsearch" required="true"></td></tr>
                <tr><td></td><td><input type="hidden" value="custsearch" name="custsearch"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>
            </table>
            
            </form>
            <% if(custsearchlist == null) { %>
            <h2>All Customer Records</h2>
            <form method="POST" action="/ISDAssignment/TransferToUpdateAccountServlet"> 
            <table class="table">


                <tr><td>Email</td><td>Firstname</td><td>Middlename</td><td>Lastname</td><td>Phone</td><td>DOB</td><td>Disabled?</td></tr>
                <% for (Customer customer : customers) { %>
                <tr><td><%=customer.getEmailaddress()%></td><td><%=customer.getFirstname()%></td><td><%=customer.getMiddlename()%></td><td><%=customer.getLastname()%></td><td><%=customer.getPhone()%></td><td><%=customer.getDob()%></td><td><%= customer.isDisabled() %></td><td><input class="button" type="submit" value="Edit Account"></td><td><input type="hidden" value="<%= customer.getEmailaddress() %>" name="admCustEmail"></td><td><input type="hidden" value="<%= customer.getPassword()%>" name="admCustPass"></td></tr>
                    <% }
                } else { %> 
            <h2>Search Results</h2>
            Your search results - <a href="systemadmin.jsp">Click here to view all customer records</a>
            <table class="table">
                <tr><td>Email</td><td>Firstname</td><td>Middlename</td><td>Lastname</td><td>Phone</td><td>DOB</td></tr>
                <% for (Customer customer : custsearchlist) { %>
                <tr><td><%=customer.getEmailaddress()%></td><td><%=customer.getFirstname()%></td><td><%=customer.getMiddlename()%></td><td><%=customer.getLastname()%></td><td><%=customer.getPhone()%></td><td><%=customer.getDob()%></td><td><%= customer.isDisabled() %></td><td><input class="button" type="submit" value="Edit Account"></td><td><input type="hidden" value="<%= customer.getEmailaddress() %>" name="admCustEmail"></td><td><input type="hidden" value="<%= customer.getPassword()%>" name="admCustPass"></td></tr>
                    <% } }
                    session.setAttribute("custsearchlist", null); %>
                
                    
                
            </table>
            </form>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>