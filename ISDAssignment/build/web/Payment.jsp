<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.PaymentDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Payment Details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/PaymentDetailsServlet" flush="true" />
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
        
    <h1>Welcome to the Payment Details</h1>
    <h2>Create new payment details</h2>
        <form method="POST" action="/ISDAssignment/PaymentDetailsServlet">
            <table class="table">
                <tr><td>Card Number: </td><td><input type="text" name="cardnum" required="true" placeholder="5217 0000 1234 5678" maxlength="16"></td></tr>
                <tr><td>CVC: </td><td><input type="text" name="cvc" required="true" placeholder="123" maxlength="3"></td></tr>
                <tr><td>Expiry Date: </td><td><input autocomplete="off" name="month" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="MM" type="text" data-pattern-validate /><input autocomplete="off" name="year" maxlength="4" pattern="[0-9]*" inputmode="numerical" placeholder="YYYY" type="text" data-pattern-validate /></div></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Save Payment Detail"></td></tr>
            </table>
        </form>
            
     <h2>Saved Payment Details</h2>
     <% ArrayList<PaymentDetails> paymentdetails = (ArrayList<PaymentDetails>)session.getAttribute("paymentdetails"); %>
     
     <% if (paymentdetails != null) {
            for (PaymentDetails details : paymentdetails) {%>
            <table class="table">
                <tr><td>Card Number: </td><td><%=details.getCardnum()%></td></tr>
                <tr><td>CVC: </td><td><%=details.getCvc()%></</td></tr>
                <tr><td>Expiry Date: </td><td><%=details.getExpirydate()%></</td></tr>
                <tr>
                    <td>
                        <form method="POST" action="/ISDAssignment/TransportPaymentDetailsServlet">
                            <input type="hidden" value="<%=details.getPay_det_num() %>" name="pay_det_num">
                            <input class="buttonn" type="submit" value="Edit Payment Details">
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="/ISDAssignment/DeletePaymentDetailsServlet">
                            <input type="hidden" value="<%=details.getPay_det_num() %>" name="pay_det_num">
                            <input class="buttonn" type="submit" value="Delete Payment Details">
                        </form>
                    </td>
                </tr>
            </table>
        <% 
            } 
        }%>
    </div>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>


<!--Add this for the button on Main/-->
<!--</div>
        <div class ="stafflogin">
            <form method="POST" action="stafflogin.jsp">
                <input class="buttonn" type="submit" value="Staff Login">
            </form>
        </div>-->