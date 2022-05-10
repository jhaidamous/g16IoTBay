<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : Anas
--%>

<%@page import="uts.isd.model.PaymentDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Edit Item</title>
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
        
          <%
            PaymentDetails editdetails = (PaymentDetails) session.getAttribute("editdetails");
            String cvcErr = (String) session.getAttribute("cvcErr");
            String cardnumErr = (String) session.getAttribute("cardnumErr");
            String monthErr = (String) session.getAttribute("monthErr");
            String yearErr = (String) session.getAttribute("yearErr");
            
        %>
        
    <div class="mainsite">
    <h1>Edit Catalog Item</h1>
    <form method="POST" action="/ISDAssignment/EditPaymentDetailsServlet">
        <table class="table">
            <tr><td>Card Number:</td><td><%=editdetails.getCardnum()%></td><td><input type="numerical" name="cardnum" required="true" placeholder="<%=(cardnumErr != null ? cardnumErr : "5217 0000 1234 5678")%>" maxlength="16"></td></tr>
            <tr><td>CVC: </td><td><%=editdetails.getCvc()%></td><td><input type="text" name="cvc" required="true" placeholder="<%=(cvcErr != null ? cvcErr : "123")%>" maxlength="3"></td></tr>
            <tr><td>Expiry Date: </td><td><%=editdetails.getExpirydate()%></td><td><input autocomplete="off" name="month" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="<%=(monthErr != null ? monthErr : "11")%>MM" type="text" data-pattern-validate /><input autocomplete="off" name="year" maxlength="4" pattern="[0-9]*" inputmode="numerical" placeholder="<%=(yearErr != null ? yearErr : "2020")%>YYYY" type="text" data-pattern-validate /></div></td></tr>
            <input type="hidden" value="<%=editdetails.getPay_det_num() %>" name="pay_det_num">
            <tr><td></td><td><input class="button" type="submit" value="Update the Payment Details"></td></tr>
        </table>
    </form>
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