/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;

/**
 *
 * @author Steph
 */
public class DisableAccServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String disableAccount = (String)request.getParameter("disableAccount");
        String enableAccount = (String)request.getParameter("enableAccount");
        int custID = Integer.parseInt(request.getParameter("admCustStatusID"));
        CustomerDAO customerDAO = (CustomerDAO)session.getAttribute("customerDAO");
        
        //try this code,
        try {
            if (disableAccount != null) {
                customerDAO.disableUser(custID);
                session.setAttribute("disableAccount", null);
            }
            else if(enableAccount != null) {
                customerDAO.enableUser(custID);
                session.setAttribute("enableAccount", null);
                
            }
            String url = request.getContextPath() + "/systemadmin.jsp";
            response.sendRedirect(url);
        } catch (NullPointerException ex) { //if there is error of type "x" do this
            System.out.println(ex.getMessage() == null ? "Unable to enable/disable account" : "Payment Details Created");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
