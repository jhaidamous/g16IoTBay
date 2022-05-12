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
import uts.isd.model.dao.ItemDAO;

/**
 *
 * @author Steph
 */
public class TransferToUpdateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String admCustEmail = (String)request.getParameter("admCustEmail");
        String admCustPass = (String)request.getParameter("admCustPass");
        CustomerDAO customerDAO = (CustomerDAO)session.getAttribute("customerDAO");
        
        //try this code,
        try {

            Customer admCust = customerDAO.login(admCustEmail, admCustPass);
            session.setAttribute("customer", admCust);
            String url = request.getContextPath() + "/admEditAcc.jsp";
            response.sendRedirect(url);
        } catch (NullPointerException ex) { //if there is error of type "x" do this
            System.out.println(ex.getMessage() == null ? "Unable to create Payment Details" : "Payment Details Created");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

}
