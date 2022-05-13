package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.isd.model.Customer;
import java.util.Random;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>IoTBay - Homepage</title>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/layout_1.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/index.js\"></script>\r\n");
      out.write("    <link href=\"websystems.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("        ");
 
            String name = "G16, ISD Autumn 2022";  
            Customer customer = (Customer) session.getAttribute("customer");
        
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <body class=\"bodyclass\" onload=\"startTime()\">\r\n");
      out.write("    <header class=\"toparea\">\r\n");
      out.write("        <div class=\"title\">\r\n");
      out.write("            <a href=\"index.jsp\"><img id=\"logo\" src=\"images/logocropped.png\" alt=\"Website logo, IoTBay\"></a><!--logo generated using https://www.freelogodesign.org/-->\r\n");
      out.write("        </div>\r\n");
      out.write("        <nav class=\"navclass\">\r\n");
      out.write("        <a href=\"index.jsp\">Home</a>\r\n");
      out.write("        ");
 if (customer == null) { 
      out.write("\r\n");
      out.write("        <a href=\"login.jsp\">Login</a>\r\n");
      out.write("        <a href=\"register.jsp\">Register</a>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        <a href=\"store.jsp\">Store</a>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <div class=\"mainsite\">\r\n");
      out.write("        <h1>Welcome to IoTBay</h1>\r\n");
      out.write("\r\n");
      out.write("        <p>Group: ");
      out.print( name);
      out.write(" </p>\r\n");
      out.write("        <p>Random ID: ");
      out.print( new Random().nextInt(999999) );
      out.write("</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <footer class=\"bottomarea\">\r\n");
      out.write("        <p id=\"clock\" class=\"footer\">\r\n");
      out.write("\r\n");
      out.write("        </p>\r\n");
      out.write("    </footer>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/ConnServlet", out, true);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
