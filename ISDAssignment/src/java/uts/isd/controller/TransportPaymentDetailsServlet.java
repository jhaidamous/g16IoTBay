/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import uts.isd.model.PaymentDetails;
import uts.isd.model.dao.PaymentDetailsDAO;

/**
 *
 * @author Anas Awais
 */
public class TransportPaymentDetailsServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int pay_det_num = Integer.parseInt(request.getParameter("pay_det_num"));
        PaymentDetailsDAO paymentDetailsDAO = (PaymentDetailsDAO) session.getAttribute("paymentDetailsDAO");
//        session.setAttribute("pay_det_num", pay_det_num);
        Customer customer = (Customer) session.getAttribute("customer");
         try {
             PaymentDetails editdetails = paymentDetailsDAO.read(customer.getUserID(), pay_det_num);
             session.setAttribute("editdetails", editdetails);
//             System.out.println(customer.getUserID() + " " + pay_det_num);
//             System.out.println(editdetails.getCustID() + " " + editdetails.getPay_det_num());
         } catch (SQLException ex) {
             Logger.getLogger(TransportPaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
//        request.getRequestDispatcher("EditPayment.jsp").include(request, response);
        String url = request.getContextPath() + "/EditPayment.jsp";
        response.sendRedirect(url);
        //everything goes above^      
    }

}
