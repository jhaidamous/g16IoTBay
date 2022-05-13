<%-- 
    Document   : main
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<head>
    <title>IoTBay - My Account</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/LogsServlet" flush="true" />

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
            Customer customer = (Customer)session.getAttribute("customer");
            ArrayList<Logs> logs = (ArrayList<Logs>) session.getAttribute("logs");
//            if ( == null) {
//                customer = new Customer(1, "dont try navigate to main","cause you're not logged in","not","logged","and it wont work", "hello", "hi", false);
//            }
//            else {
//                customer = (Customer)session.getAttribute("customer");
//            }
        %>
    <div class="mainsite">
    <h1>IoTBay - My Account</h1>
    <p>
        <table class="table">
            <tr><td>Email: </td><td><%= customer.getEmailaddress()%></td></tr>                    
            <tr><td>Name: </td><td><%= customer.getFirstname()%></td></tr>
            <tr><td>Phone: </td><td><%= customer.getPhone()%></td></tr>
        </table>
        <table class="table">
            <tr>
                <td><a class="buttonn" href = "/ISDAssignment/EditAccount.jsp">Edit Account</a></td>
                <td><a class="buttonn" href = "/ISDAssignment/Payment.jsp">Payment Details</a></td>
                <td><a class="buttonn" href = "/ISDAssignment/paymentHistory.jsp">Payment History</a></td>
            </tr>
        </table>
    <h2> Access logs below </h2>
    <div class="collection">
        <table class="table">
         <% 
        for (Logs log : logs) { %>
            <tr><td>Date: </td><td><%= log.getLogDate()%></td></tr>                    
            <tr><td>Time: </td><td><%= log.getLogTime()%></td></tr>
            <tr><td>Type: </td><td><%= log.getMessage()%></td></tr>
          <%}%>
        </table>
      </div>
    </p>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
