
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
import uts.isd.model.Staff;
import uts.isd.model.dao.*;

/**
 *
 * @author g16
 */
public class StaffLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clearRegister(session);
        String emailaddress = request.getParameter("emailaddress");
        String password = request.getParameter("password");
        StaffDAO staffDAO = (StaffDAO) session.getAttribute("staffDAO");
        
        Staff staff = null;
        if (staffDAO == null) {
            System.out.print("staffdao is null");
        }

        
        try {
            
            System.out.print("here" + emailaddress + password);
            
            staff = staffDAO.login(emailaddress, password);
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
            request.getRequestDispatcher("stafflogin.jsp").include(request, response);
        }
        

        else {
            try {
                if (staff != null) {
       
                    session.setAttribute("staff", staff);
                    String url = request.getContextPath() + "/systemadmin.jsp";
                    response.sendRedirect(url);                } 
                else {

                    session.setAttribute("logInErr", "Email or Password Incorrect");
                    request.getRequestDispatcher("stafflogin.jsp").include(request, response);
                }
            }
           catch (NullPointerException ex) {
              System.out.println(ex.getMessage() == null ? "Staff was unable to be logged in" : "Staff Retrieved from DB");
         }
        }
    }
}
