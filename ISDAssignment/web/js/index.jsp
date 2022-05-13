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
    <title>IoTBay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:include page="/ItemViewServlet" flush="true" />
</head>
        <% 
            String name = "G16, ISD Autumn 2022";  
            Customer customer = (Customer) session.getAttribute("customer");
        %>

<body>
  
  <!-- HEADER -->

 <header class="header">
  <nav>
    <img src="images/logocropped.png"  class="logo">
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="store.jsp">Store</a></li>
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
    <div class="intro">

  <!-- New Arrivals -->
  <section class="section">
    <div class="h">
      <h1>Welcome to <span>IoTBay</span></h1>
    </div>
    

  <!-- Popular Products -->

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