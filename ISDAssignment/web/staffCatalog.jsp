<%-- 
    Document   : register
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="uts.isd.model.Categories"%>
<%@page import="uts.isd.model.Item"%>
<%@page import="uts.isd.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<head>
    <title>IoTBay - Staff Catalog</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/ItemViewServlet" flush="true" />
</head>
<% 
ArrayList<Item> items = (ArrayList<Item>) session.getAttribute("items"); 
ArrayList<Item> staffsearchlist = (ArrayList<Item>) session.getAttribute("searchItems");
ArrayList<Categories> categories = (ArrayList<Categories>)session.getAttribute("categories");
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
    <h1>Store Catalog - Staff Portal</h1>
    <a href='createItem.jsp' class="buttonn">"Add an item"</a>
    <h2>Search Items</h2>
    <form method="POST" action="/ISDAssignment/ItemViewServlet">
        <table class="table">
            <tr><td>Item Name: </td><td><input type="text" name="searchq" required="true"></td></tr>
            <tr><td></td><td><input type="hidden" value="regsearch" name="regsearch"></td></tr>
            <tr><td></td><td><input type="hidden" value="/staffCatalog.jsp" name="respurl"></td></tr>
            <tr><td></td><td><input class="button" type="submit" value="Search"></td></tr>
        </table>
    </form>
    <form method="POST" action="/ISDAssignment/ItemViewServlet" id="categoryform">
        <label for="category">Category:</label>
        <select name="searchq" id="category" form="categoryform">
            <option>Category...</option>
            <%
            for (Categories category : categories) { %>
            <option value="<%=category.getName()%>"><%=category.getName()%></option>
            <%
            }
            %>
        </select>
    <input type="hidden" value="/staffCatalog.jsp" name="respurl">
    <input class="button" type="submit" value="Category Search">
    </form>
    <table class="table">
            <%
            if (staffsearchlist != null && staffsearchlist.size() > 0) {
                items = staffsearchlist; 
                %>
            Your search results - <a href="staffCatalog.jsp">Click here view all items</a>
            <%
            }
            for (Item item : items) { %>
            <form method="GET" action="/ISDAssignment/UpdateItemServlet"> 
                <tr>
                    <td><img class="staffproduct" src="<%=item.getItem_image_path()%>"></td>
                    <td><%=item.getItem_name()%></td>
                    <td>$<%=item.getItem_price()%></td>
                    <td><%=item.getItem_stock()%></td>
                    <td><%=item.getItem_status()%></td>
                    <td>$<%=item.getCost_per_item()%></td>
                    <td><%=item.getItem_category() %></td>
                    <td><input type="hidden" value="<%=item.getItemID() %>" name="editItemID"></td>
                    <td><input class="button" type="submit" value="Edit Item"></td>
                </tr>
            </form>
            <%
            }
            session.setAttribute("searchItems", null);
            %>
    </table>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>