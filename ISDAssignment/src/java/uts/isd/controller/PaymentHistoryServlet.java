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
import uts.isd.model.Payment;
import uts.isd.model.User;
import uts.isd.model.dao.ItemDAO;
import uts.isd.model.dao.PaymentDAO;

/**
 *
 * @author JHUTS
 */
public class PaymentHistoryServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer)session.getAttribute("customer");
        PaymentDAO paymentDAO = (PaymentDAO)session.getAttribute("paymentDAO");
        if (paymentDAO == null) {
            System.out.print("Payments DAO is Null");
            }
        try {
            ArrayList<Payment> payments = paymentDAO.fetchPayments(customer.getUserID());
             if (payments == null) {
            System.out.print("Payments is Null");
            }
            session.setAttribute("payments", payments);
//            request.getRequestDispatcher("store.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Payments not found in DB" : "Payments found");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String searchpay = request.getParameter("searchpay");
        String regsearch = request.getParameter("regsearch");
        PaymentDAO paymentDAO = (PaymentDAO)session.getAttribute("paymentDAO");
        try {
            if (regsearch != null) {
                System.out.print(searchpay);
                ArrayList<Payment> paymentsearchlist = paymentDAO.searchPayments(searchpay);
                session.setAttribute("paymentsearchlist", paymentsearchlist);
                }
            else {
                System.out.print(searchpay + "here");
                ArrayList<Payment> paymentsearchlist = paymentDAO.searchPayDate(searchpay);
                session.setAttribute("paymentsearchlist", paymentsearchlist);
            }
            String url = request.getContextPath() + "/paymentHistory.jsp";
            response.sendRedirect(url);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Payment History not found in DB" : "Payment History found");
            String url = request.getContextPath() + "/paymentHistory.jsp";
            response.sendRedirect(url);
        } catch (SQLException ex) {
            Logger.getLogger(ItemViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
