
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.dao.*;

/**
 *
 * @author g16
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clearRegister(session);
        String emailaddress = request.getParameter("emailaddress");
        String password = request.getParameter("password");
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        LogsDAO logsDAO = (LogsDAO) session.getAttribute("logsDAO");
        
        Customer customer = null;
        try {
            customer = customerDAO.login(emailaddress, password);
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "Customer already exists");
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Validator.clearRegister(session);
        
        boolean error = false;

        if (!validator.validateEmail(emailaddress)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            error = true;
        }
        
        if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            error = true;
        }
    
//        if (!validator.validateDob(dob)) {
//            session.setAttribute("dobErr", "Error: Date format is incorrect");
//            error = true;
//        }
        System.out.print(emailaddress+" "+ password);

        if (error) {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        

        else {
            try {
                if (customer != null && customer.isDisabled() == true) {
                    session.setAttribute("logInErr", "Your account is disabled");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
                else if (customer != null) {
       
                    session.setAttribute("customer", customer);
                    logsDAO.createLogs(customer.getUserID(),"Logged in successfully" );
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                } 
                else {

                    session.setAttribute("logInErr", "Email or Password Incorrect");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }
            }
           catch (NullPointerException ex) {
              System.out.println(ex.getMessage() == null ? "Customer was unable to be logged in" : "Customer Retrieved from DB");
         }  catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
