<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page import="uts.isd.model.PaymentDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>Staff - Edit Item</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/PaymentDetailsServlet" flush="true" />
</head>
<%
    Staff staff = (Staff) session.getAttribute("staff");
    String priceErr = (String)session.getAttribute("priceErr");
    String itemNameErr = (String)session.getAttribute("itemNameErr");
    String stockErr = (String)session.getAttribute("stockErr");
    session.setAttribute("stockErr", null);
    session.setAttribute("itemNameErr", null);
    session.setAttribute("priceErr", null);
%>
<html>
    <body class="bodyclass" onload="startTime()">
    <header class="toparea">
        <div class="title">
            <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
        </div>
        <nav class="navclass">
            <a href="index.jsp">Home</a>
            <% if  (staff != null) { %>
            <a href="staffCatalog.jsp">Store Catalog</a>
            <a href="logout.jsp">Logout</a>
            <% } else { %>
            <% }%>
        </nav>
    </header>
    <div class="mainsite">
    <% if(staff == null) { %>
   <p>You do not have access to this page.</p>
   <%} else { %>    
   <h1>Create a Catalog Item</h1>
        <form method="POST" action="/ISDAssignment/CreateItemServlet">
            <table class="table">
                <tr><td>Item Name: </td><td><input type="text" name="itemname""></td></tr>
                <tr><td>Item Price: </td><td><input type="text" name="itemprice""></td></tr>
                <tr><td>Item Stock: </td><td><input type="text" name="itemstock""></td></tr>
                <tr><td>Cost Per Item: </td><td><input type="text" name="costperitem""></td></tr>
                <tr><td>Item Category: </td><td><input type="text" name="itemcategory""></td></tr>
                <tr><td>Item Status: 
                    </td><td>
                        <select name="itemstatus" id="itemstatus">
                            <option value="In Stock">In Stock</option>
                            <option value="Out of Stock">Out of Stock</option>
                            <option value="Backorder">Back Order</option>
                        </select>
                    </td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Create Item"></td></tr>
            </table>
            <p><%=(priceErr != null ? priceErr : "")%></p>
            <p><%=(itemNameErr != null ? itemNameErr : "")%></p>
            <p><%=(stockErr != null ? stockErr : "")%></p>
        </form>
    </div>
    <% } %>
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