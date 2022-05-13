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
    <title>IoTBay - Search Results</title>
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
        <% String test3 = "sending session to servlet";
            session.setAttribute("test3", test3);%>
        <%
            ArrayList<Item> searchItems = (ArrayList<Item>)session.getAttribute("searchItems");
            ArrayList<Categories> categories = (ArrayList<Categories>) session.getAttribute("categories");

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
    <h2>Search current records</h2>
    <form method="POST" action="/ISDAssignment/ItemViewServlet">
        <table class="table">
            <tr><td>Name: </td><td><input type="text" name="searchq" required="true"></td><td><input class="button" type="submit" value="Search"></td></tr>
            <tr><td></td><td><input type="hidden" value="regsearch" name="regsearch"></td></tr>
            <tr><td></td><td><input type="hidden" value="/storeSearch.jsp" name="respurl"></td></tr>
        </table>
    </form>
                </form>
            <div class="adjust">
                <form method="POST" action="/ISDAssignment/ItemViewServlet" id="categoryform">

                    <label for="category">Category:</label>
                    <select name="searchq" id="category" form="categoryform">
                        <option>Category...</option>
                        <%
                for (Categories category : categories) {%>
                        <option value="<%=category.getName()%>"><%=category.getName()%></option>
                        <%
                            }
                        %>
                    </select>
                    <input type="hidden" value="/storeSearch.jsp" name="respurl">
                    <input class="button" type="submit" value="Category Search">
                </form>
            </div>
    
        <div class="collection">
            <%
            if (searchItems != null && searchItems.size() > 0) { %>
            <p>Your search results - <a href="store.jsp">Click here to go back to store</a></p>
            <br>
            <div class="ac-center box">
                <%  
                for (Item item : searchItems) { %>
    <div class="ac">
        <div class="img-cover">
            <img src="<%=item.getItem_image_path()%>" height="250px" width="250px   " alt="" />
        </div>
        <div class="price"><%=item.getItem_name()%></div>


        $<%=item.getItem_price()%>
    </div>
            <% }
            }
            else { %>
            <p>Your search produced no results - <a href="store.jsp">Click here to go back to store</a></p>
            <%
            } %>
            </div>
            </p>
    <footer class="bottomarea">
        <p id="clock" class="footer"></p>
    </footer>
    </body>
</html>
