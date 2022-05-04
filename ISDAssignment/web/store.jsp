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
        <% String test3 = "sending session to servlet";
            session.setAttribute("test3", test3);%>
    <jsp:include page="/ItemViewServlet" flush="true" />
        <%
            ArrayList<Item> items = (ArrayList<Item>)session.getAttribute("items");
            String test = (String)session.getAttribute("test");
            String test2 = (String)session.getAttribute("test2");
            String test4 = (String)session.getAttribute("test4");
            
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
        These are all the items we have for sale 
        <div class="collection">
             <% if (items == null) {
                 out.print("is null");
                 out.print(test);
                 out.print(test2);
                 out.print(test4);
             }
             else {
                 for (Item item : items) { %>
            <div class="product">
              <img class="product_image" src="<%=item.getItem_image_path()%>"></a>
              <div class="product__name">
                <p>
                  <a href="#"><%=item.getItem_name()%></a>
                </p>
              </div>
              <div class="product__price">
                <p>$<%=item.getItem_price()%>  
              </div>
            </div>
              <% } }%>
          </div>
    </p>

        <% 
            session.setAttribute("login", user);
        %>       
        
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
