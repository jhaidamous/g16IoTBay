<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : Anas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Edit Payment Details</title>
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
    <h1>Edit Payment Details</h1>
    <p>Update the Payment Details</p>
        <form method="POST" action="/ISDAssignment/PaymentDetailsServlet">
            <table class="table">
                <tr><td>Customer ID: </td><td><input type="text" name="custID" required="true" placeholder="1234"></td></tr>
                <tr><td>Customer Name: </td><td><input type="text" name="firstname" required="true" placeholder="John Doe"></td></tr>
                <tr><td>Card Number: </td><td><input type="numerical" name="cardnum" required="true" placeholder="5217 0000 1234 5678" maxlength="16"></td></tr>
                <tr><td>CVC: </td><td><input type="text" name="cvc" required="true" placeholder="123" maxlength="3"></td></tr>
                <tr><td>Expiry Date: </td><td><input type="text" name="expirydate" required="true" placeholder="MM/YY"></td></tr>
                <tr><td>Expiry Date: </td><td><input autocomplete="off" class="exp" id="month" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="MM" type="text" data-pattern-validate /><input autocomplete="off" class="exp" id="year" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="YY" type="text" data-pattern-validate /></div></td></tr>
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