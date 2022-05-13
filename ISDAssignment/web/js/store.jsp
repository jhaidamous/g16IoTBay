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
<jsp:include page="/ConnServlet" flush="true"/>


<!DOCTYPE html>
<head>
    <title>IoTBay - Store</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:include page="/ItemViewServlet" flush="true" />
</head>
<%
    ArrayList<Item> items = (ArrayList<Item>) session.getAttribute("items");
    ArrayList<Categories> categories = (ArrayList<Categories>) session.getAttribute("categories");
    Customer customer = (Customer) session.getAttribute("customer");

    User user = new User();
    if ((User) session.getAttribute("login") == null) {
        user = new User("dont try navigate to main", "cause you're not logged in", "not", "logged", "and it wont work");
    } else {
        user = (User) session.getAttribute("login");
    }
%>

<body>

    <!-- HEADER -->

    <header class="header">
        <nav>
            <img src="images/logocropped.png"  class="logo">
            <ul>
                <a href="index.jsp">Home</a>
                <% if (customer == null) { %>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="register.jsp">Register</a></li>
                    <% } else { %>
                <li><a href="main.jsp">My Account</a></li>
                <li><a href="logout.jsp">Logout</a></li>
                    <% } %>


            </ul>
        </nav>
        <!-- Intro -->


    </header>
                        

    <div class="intro2">
            <div class="h">
            <h1>Welcome to <span>IoTBay</span></h1>
        </div>
        <div class="search">
            <h2 class="search">Search current records</h2>
            <form method="POST" action="/ISDAssignment/ItemViewServlet">
                <table>
                    <tr><td>Item Name: </td><td><input type="text" name="searchq" required="true"></td>
                        <td><input class="button" type="submit" value="Search"></td></tr>
                    <td></td><td><input type="hidden" value="regsearch" name="regsearch"></td>
                    <td></td><td><input type="hidden" value="/storeSearch.jsp" name="respurl"></td>
                </table>
            </form>

            <form method="POST" action="/ISDAssignment/ItemViewServlet" id="categoryform">
                    <h2>Category:</h2>
                    <label for="category"></label>
                    <div class="row">
                        <div class="column">
                            <select class="categories minimal" name="searchq" id="category" form="categoryform">
                        <option>Category...</option>
                        <!--<tr><td>-->
                                <%
                            for (Categories category : categories) {%>
                        <option value="<%=category.getName()%>"><%=category.getName()%></option>
                        <%
                            }
                        %>
                    <!--</td></tr>-->
                        </select>
                        </div>
                    <div class="column">
<!--                        <table>-->

                    <input type="hidden" value="/storeSearch.jsp" name="respurl">
<!--                    <tr><td>-->
                            <input class="button" type="submit" value="Category Search">
<!--                            </td</tr>-->
<!--                </table>-->
                    </div>
                        </div>
                

            </form>

        </div>

    </p> 





</div>
    <div class="h">
        <h1> <span>Items for sale:</span></h1>
    </div>
    <div class="ac-center box">
        <%
            for (Item item : items) {%>
        <div class="ac">
            <div class="img-cover">
                <img src="<%=item.getItem_image_path()%>" height="100px" width="100px" alt="" />
            </div>
            <p><%=item.getItem_name()%></p>
            
            <div class="rating">
                <i class="bx bxs-star"></i>
                <i class="bx bxs-star"></i>
                <i class="bx bxs-star"></i>
                <i class="bx bxs-star"></i>
                <i class="bx bxs-star"></i>
            </div>
            <div class="price">$<%=item.getItem_price()%></div>
        </div>
        <%
            }%>
    </div>

<!-----footer-------------------->
<section id="footer">

    <div class="foot">
        <ul>
            <li><p>Designed by:</p></li>
            <li><a href="">Jonathan H,  </a><a href="">Navid C,  </a><a href="">Anas A,  </a><a href="">Stephen B,  </a><a href="">Steven N</a></li>

        </ul>

    </div>
</section>

</body>

</html>