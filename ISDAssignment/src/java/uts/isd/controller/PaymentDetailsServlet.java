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
import uts.isd.model.Item;
import uts.isd.model.Payment;
import uts.isd.model.PaymentDetails;
import uts.isd.model.User;
import uts.isd.model.dao.PaymentDAO;
import uts.isd.model.dao.PaymentDetailsDAO;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author JHUTS
 */
public class PaymentDetailsServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userID = Integer.parseInt(request.getParameter("userID")) ;
        PaymentDetailsDAO paymentDetailsDAO = (PaymentDetailsDAO)session.getAttribute("paymentDetailsDAO");
        
        try {
            ArrayList<PaymentDetails> paymentdetails = paymentDetailsDAO.fetchPaymentDetails(userID);
            session.setAttribute("paymentdetails", paymentdetails);
//            request.getRequestDispatcher("store.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Items not found in DB" : "Items found");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    // this method when we post the from from payment.jsp to setvlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //get the posted details from the request, based on "name" appropriate field in the jsp form
        int userID = Integer.parseInt(request.getParameter("userID")) ;  // isn't it supposed to be custID?
//        int custID = Integer.parseInt(request.getParameter("custID"))    // should add this too
//        int pay_det_num = Integer.parseInt(request.getParameter("pay_det_num"))    // should add this too   
        String cvc = request.getParameter("cvc");                           // should add this too
        String cardnum = request.getParameter("cardnum");
        String expirydate = request.getParameter("expirydate");
//        String paymentID = request.getParameter("emailaddress");          // payment.jsp
//        String payment_error = request.getParameter("password");          // payment.jsp
//        String payment_status = request.getParameter("phone");            // payment.jsp
        //getting the dao from the session (initalised in connservlet which is run on index.jsp)
        PaymentDetailsDAO paymentDetailsDAO = (PaymentDetailsDAO)session.getAttribute("paymentDetailsDAO");
        
        //try this code,
        try {
            //create the payment details from the attributes we got above
            paymentDetailsDAO.createPaymentDetails(userID, 0, cardnum, expirydate);
            PaymentDetails paymentdetails = paymentDetailsDAO.read(cardnum);
            session.setAttribute("paymentdetails", paymentdetails);
            request.getRequestDispatcher("Payment.jsp").include(request, response);
        } catch (NullPointerException ex) { //if there is error of type "x" do this
            System.out.println(ex.getMessage() == null ? "Items not found in DB" : "Items found");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
