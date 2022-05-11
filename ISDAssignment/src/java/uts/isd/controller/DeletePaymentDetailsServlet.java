/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.Item;
import uts.isd.model.Payment;
import uts.isd.model.PaymentDetails;
import uts.isd.model.User;
import uts.isd.model.dao.ItemDAO;
import uts.isd.model.dao.PaymentDAO;
import uts.isd.model.dao.PaymentDetailsDAO;

/**
 *
 * @author JHUTS
 */
public class DeletePaymentDetailsServlet extends HttpServlet {

    // this method when we post the from payment.jsp to setvlet
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int pay_det_num = Integer.parseInt((String)request.getParameter("pay_det_num"));
        PaymentDetailsDAO paymentDetailsDAO = (PaymentDetailsDAO)session.getAttribute("paymentDetailsDAO");
        Customer customer = (Customer) session.getAttribute("customer");

        //try this code,
        try {

            paymentDetailsDAO.delete(customer.getUserID(), pay_det_num);
            String url = request.getContextPath() + "/Payment.jsp";
            response.sendRedirect(url);
//            request.getRequestDispatcher("Payment.jsp").include(request, response);
        } catch (NullPointerException ex) { //if there is error of type "x" do this
            System.out.println(ex.getMessage() == null ? "Unable to delete payment details" : "payment details deleted");
        } catch (SQLException ex) {
            Logger.getLogger(DeletePaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
