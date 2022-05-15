<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : Anas
--%>

<%@page import="uts.isd.model.Staff"%>
<%@page import="uts.isd.model.Item"%>
<%@page import="uts.isd.model.PaymentDetails"%>
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
<%
    Item editItem = (Item) session.getAttribute("editItem");
    Staff staff = (Staff) session.getAttribute("staff");
%>
<html>
    <body class="bodyclass" onload="startTime()">
        <header class="toparea">
            <div class="title">
                <a href="index.jsp"><img id="logo" src="images/logocropped.png" alt="Website logo, IoTBay"></a><!--logo generated using https://www.freelogodesign.org/-->
            </div>
            <nav class="navclass">
                <a href="index.jsp">Home</a>
                <% if (staff != null) { %>
                <a href="staffCatalog.jsp">Store Catalog</a>
                <a href="logout.jsp">Logout</a>
                <% } else { %>
                <% }%>
            </nav>
        </header>
        <div class="mainsite"> 
            <h1>Edit Item</h1>
            <% if (staff == null) { %>
            <p>You do not have access to this page.</p>
            <%} else {%>    
            <p>Update the Payment Details</p>
            <form method="POST" action="/ISDAssignment/UpdateItemServlet">
                <table class="table">
                    <tr><td>Item ID: </td><td><%=editItem.getItemID()%></td><td></tr>
                    <tr><td><input type="hidden" value="<%=editItem.getItemID()%>" name="itemID"></td></tr>
                    <tr><td>Item Name: </td><td><input type="text" name="itemname" value="<%=editItem.getItem_name()%>"></td></tr>
                    <tr><td>Item Price: </td><td><input type="text" name="itemprice" value="<%=editItem.getItem_price()%>"></td></tr>
                    <tr><td>Item Stock: </td><td><input type="text" name="itemstock" value="<%=editItem.getItem_stock()%>"></td></tr>
                    <tr><td>Cost Per Item: </td><td><input type="text" name="costperitem" value="<%=editItem.getCost_per_item()%>"></td></tr>
                    <tr><td>Item Category: </td><td><input type="text" name="itemcategory" value="<%=editItem.getItem_category()%>"></td></tr>
                    <tr><td>Item Status: 
                        </td><td>
                            <select name="itemstatus" id="itemstatus">
                                <option value="<%=editItem.getItem_status()%>">Currently: <%=editItem.getItem_status()%></option>
                                <option value="In Stock">In Stock</option>
                                <option value="Out of Stock">Out of Stock</option>
                                <option value="Backorder">Back Order</option>
                            </select>
                        </td></tr>
                    <tr><td></td><td><input class="button" type="submit" value="Update Item"></td></tr>
                </table>
            </form>
            <form method="POST" action="/ISDAssignment/DeleteItemServlet">
                <table class="table">
                    <tr><td><input type="hidden" value="<%=editItem.getItemID()%>" name="itemID"></td></tr>
                    <tr><td></td><td><input class="button" type="submit" value="Delete Item"></td></tr>
                </table>
            </form>

        </div>
        <% }%>
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