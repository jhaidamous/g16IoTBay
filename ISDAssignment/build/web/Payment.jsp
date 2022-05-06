<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Payment Details</title>
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
    <h1>Welcome to the Payment Details</h1>
    <p>Create new payment details</p>
        <form method="POST" action="SystemAdmin.jsp">
            <table class="table">
                <form method="POST" action="welcome.jsp">
                <tr><td>Customer ID: </td><td><input type="text" name="custID" required="true" placeholder="1234"></td></tr>
                <tr><td>Customer Name: </td><td><input type="text" name="firstname" required="true" placeholder="John Doe"></td></tr>
                <tr><td>Card Number: </td><td><input type="text" name="cardnum" required="true" placeholder="5217 0000 1234 5678" maxlength="16"></td></tr>
                <tr><td>CVC: </td><td><input type="text" name="cvc" required="true" placeholder="123" maxlength="3"></td></tr>
                <tr><td>Expiry Date: </td><td><input type="text" name="expirydate" required="true" placeholder="MM/YY"></td></tr>
                <tr><td>Expiry Date: </td><td><input autocomplete="off" class="exp" id="month" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="MM" type="text" data-pattern-validate /><input autocomplete="off" class="exp" id="year" maxlength="2" pattern="[0-9]*" inputmode="numerical" placeholder="YY" type="text" data-pattern-validate /></div></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Save Payment Detail"></td></tr>
            </table>
            </form>
            
     <h2>Saved Payment Details</h2>
        <form method="POST" action="Payment.jsp">
            <table class="table">
                <form method="POST" action="welcome.jsp">
                <tr><td>Details: </td><td><input type="text" name="name" required="true"></td></tr>
                <!--<tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>-->
            </table>
            </form>
            <div class ="paymentdetails">
                <form method="POST" action="EditPayment.jsp">
            <input class="buttonn" type="submit" value="Edit Payment Details">
        </form>
        </div>
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