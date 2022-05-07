
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
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
public class RegisterServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clearRegister(session);
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String middlename = request.getParameter("middlename");
        String emailaddress = request.getParameter("emailaddress");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");    
        String dob = request.getParameter("dob");
        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        
        Customer customer = null;
        try {
            customer = customerDAO.login(emailaddress, password);
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist" : "Customer already exists");
        }
        catch (SQLException ex) {
            Logger.getLogger(RegisterServlet1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Validator.clearRegister(session);
        
        boolean error = false;

        if (!validator.validateEmail(emailaddress)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            error = true;
        }
        if (!validator.validateName(firstname)) {
            session.setAttribute("firstNameErr", "Error: Name format is incorrect");
            error = true;
        }
        if (middlename != null) {
            if (!validator.validateName(middlename)) {
            session.setAttribute("middleNameErr", "Error: Name format is incorrect");
            error = true;
            }
        }
        if (!validator.validateName(lastname)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            error = true;
        }
        if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            error = true;
        }
        if (!validator.validatePhone(phone)) {
            session.setAttribute("phoneErr", "Error: Phone format is incorrect");
            error = true;
        }
//        if (!validator.validateDob(dob)) {
//            session.setAttribute("dobErr", "Error: Date format is incorrect");
//            error = true;
//        }
        System.out.print(firstname +" "+ lastname+" "+  middlename+" "+ emailaddress+" "+ phone+" "+ dob+" "+ password);

        if (error) {
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        

        else {
            try {
                if (customer != null) {
                    session.setAttribute("existErr", "Customer already exists in the Database!");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } 
                else {

                    customerDAO.createCustomer(firstname, lastname, middlename, emailaddress, phone, dob, password);
                    customer = customerDAO.login(emailaddress, password);
                    session.setAttribute("customer", customer);
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                }
            }
           catch (NullPointerException ex) {
              System.out.println(ex.getMessage() == null ? "Customer was unable to be logged in" : "Customer Retrieved from DB");
         }
            catch (SQLException ex) {
                Logger.getLogger(RegisterServlet1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
