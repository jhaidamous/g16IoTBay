
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
import uts.isd.model.PaymentDetails;
import uts.isd.model.dao.*;
import uts.isd.model.dao.PaymentDetailsDAO;


/**
 *
 * @author g16
 */
public class EditPaymentDetailsServlet extends HttpServlet {
    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String pay_det_num = request.getParameter("pay_det_num");
//        session.setAttribute("pay_det_num", pay_det_num);
//        request.getRequestDispatcher("EditPayment.jsp").include(request, response);
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        Validator.clearRegister(session);
        PaymentDetails editdetails = (PaymentDetails) session.getAttribute("editdetails");
        int pay_det_num = editdetails.getPay_det_num();
//        int cvc = editdetails.getCvc();
//        String cardnum = editdetails.getCardnum();
//        String expirydate = editdetails.getExpirydate();
//        int pay_det_num = Integer.parseInt(request.getParameter("pay_det_num"));
        int cvc = Integer.parseInt(request.getParameter("cvc"));
        String cardnum = request.getParameter("cardnum");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String expirydate = year+ "-"+ month+"-"+"01";
        System.out.println(editdetails.getCustID() + " " + editdetails.getPay_det_num());
        Customer customer = (Customer) session.getAttribute("customer");
        PaymentDetailsDAO paymentDetailsDAO = (PaymentDetailsDAO)session.getAttribute("paymentDetailsDAO");
        
        
        Validator.clearRegister(session);
        
        boolean error = false;

        if (!validator.validateCVC(cvc)) {
            session.setAttribute("cvc", "Error: CVC format is incorrect");
            error = true;
        }
        
        if (!validator.validatecardnum(cardnum)) {
            session.setAttribute("cardnum", "Error: Card Number format is incorrect");
            error = true;
        }
        
//        if (!validator.validateexpirydate(expirydate)) {
//            session.setAttribute("expirydate", "Enter Expiry Date");
//            error = true;
//        }
        
        if (!validator.validatemonth(month)) {
            session.setAttribute("month", "Enter Month");
            error = true;
        }
        
        if (!validator.validateyear(year)) {
            session.setAttribute("year", "Enter Year");
            error = true;
        }
       
        System.out.print(cvc +" "+ cardnum+" "+  expirydate);

        if (error) {
            request.getRequestDispatcher("EditPayment.jsp").include(request, response);
        }

        else {
            try {
                    paymentDetailsDAO.update(editdetails.getCustID(), editdetails.getPay_det_num(), cvc, cardnum, expirydate);
//                    request.getRequestDispatcher("Payment.jsp").include(request, response);
                    String url = request.getContextPath() + "/Payment.jsp";
                        response.sendRedirect(url);

            }
           catch (NullPointerException ex) {
              System.out.println(ex.getMessage() == null ? "Payment Details cannot be updated" : "Payment Details updated from DB");
         }
            catch (SQLException ex) {
                Logger.getLogger(EditPaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
