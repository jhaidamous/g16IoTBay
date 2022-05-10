<%-- 
    Document   : main
    Created on : 02/04/2022, 6:25:00 PM
    Author     : g16
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@page import="uts.isd.model.*" %>
<%@page import="uts.isd.model.dao.*" %>

<!DOCTYPE html>
<head>
    <title>IoTBay - Store</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/layout_1.css">
    <script type="text/javascript" src="js/index.js"></script>
    <link href="websystems.css" rel="stylesheet">
    <jsp:include page="/ItemViewServlet" flush="true" />
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
            ArrayList<Item> items = (ArrayList<Item>)session.getAttribute("items");
            ArrayList<Categories> categories = (ArrayList<Categories>)session.getAttribute("categories");
            
            User user = new User();
            if ((User)session.getAttribute("login") == null) {
                user = new User("dont try navigate to main","cause you're not logged in","not","logged","and it wont work");
            }
            else {
                user = (User)session.getAttribute("login");
            }
        %>
    <div class="mainsite">
    
    <h1>Welcome to IoTBay Store</h1>
    <p>     
    <h2>Search current records</h2>
    <form method="POST" action="/ISDAssignment/ItemViewServlet">
        <table class="table">
            <tr><td>Item Name: </td><td><input type="text" name="searchq" required="true"></td></tr>
            <tr><td></td><td><input type="hidden" value="regsearch" name="regsearch"></td></tr>
            <tr><td></td><td><input type="hidden" value="/storeSearch.jsp" name="respurl"></td></tr>
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
    <input type="hidden" value="/storeSearch.jsp" name="respurl">
    <input class="button" type="submit" value="Category Search">
    </form>
        <div class="collection">
        These are all the items we have for sale 
            <%
            for (Item item : items) { %>
            <div class="product">
              <img class="product_image" src="<%=item.getItem_image_path()%>"></a>
              <div class="product__name">
                <p>
                  <a href="#"><%=item.getItem_name()%></a>
                </p>
              </div>
              <div class="product__price">
                  <p>$<%=item.getItem_price()%> </p>
              </div>
            </div>
            <%
            } %>
          </div>
    </p> 
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
