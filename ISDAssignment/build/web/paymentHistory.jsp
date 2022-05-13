<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Payment"%>
<%@page import="uts.isd.model.Categories"%>
<%@page import="uts.isd.model.Item"%>
<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>My Account - Payment History</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/PaymentHistoryServlet" flush="true" />
</head>
<% 
ArrayList<Payment> payments = (ArrayList<Payment>) session.getAttribute("payments"); 
ArrayList<Payment> paymentsearchlist = (ArrayList<Payment>) session.getAttribute("paymentsearchlist");
//ArrayList<Categories> categories = (ArrayList<Categories>)session.getAttribute("categories"); ENTER DATES HERE
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
    <h1>My Account - Payment History</h1>
    <h2>Search Payment History</h2>
    
    <table class="table">
        <form method="POST" action="/ISDAssignment/PaymentHistoryServlet">
            <tr><td>By Payment ID:</td><td><input type="text" name="searchpay" required="true"></td></tr>
            <tr><td></td><td><input type="hidden" value="regsearch" name="regsearch"></td></tr>
            <tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>
        </form>
        <form method="POST" action="/ISDAssignment/PaymentHistoryServlet">
            <tr><td>By Date:</td><td><input type="text" name="searchpay" required="true" placeholder="YYYY-MM-DD"></td></tr>
            <tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>
        </form>
    </table>
        
    <table class="table">
            <tr>
                <td>Payment ID</td>
                <td>Order ID</td>
                <td>Payment Status</td>
                <td>Payment Error</td>
                <td>Payment Date</td>
                <td>Total</td>
            </tr>
            <%
            if (paymentsearchlist != null && paymentsearchlist.size() > 0) {
                payments = paymentsearchlist; 
                %>
            Your search results - <a href="paymentHistory.jsp">Click here view all payment history</a>
            <%
            }
            for (Payment payment : payments) { %>
            <tr>
                <td><%=payment.getPaymentID()%></td>
                <td><%=payment.getOrderID()%></td>
                <td><%=payment.getPayment_status()%></td>
                <td><%=payment.getPayment_error()%></td>
                <td><%=payment.getPayment_date() %></td>
                <td>$<%=payment.getTotal()%></td>
            </tr>
            <%
            }
            session.setAttribute("paymentsearchlist", null);
            %>
    </table>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>