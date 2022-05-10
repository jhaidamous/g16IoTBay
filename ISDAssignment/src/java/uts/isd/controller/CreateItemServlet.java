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
public class CreateItemServlet extends HttpServlet {
    
    // this method when we post the from payment.jsp to setvlet
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String itemname = (String)request.getParameter("itemname");
        double itemprice = Double.parseDouble((String)request.getParameter("itemprice"));
        int itemstock = Integer.parseInt((String)request.getParameter("itemstock"));
        String itemstatus = (String)request.getParameter("itemstatus");
        double costperitem = Double.parseDouble((String)request.getParameter("costperitem"));
        String itemcategory = (String)request.getParameter("itemcategory");
        //get the posted details from the request, based on "name" appropriate field in the jsp form
//        int userID = Integer.parseInt(request.getParameter("userID")) ;
        //getting the dao from the session (initalised in connservlet which is run on index.jsp)
        ItemDAO itemDAO = (ItemDAO)session.getAttribute("itemDAO");
        
        //try this code,
        try {

            //create the payment details from the attributes we got above
            itemDAO.createItem(itemname, itemprice, itemstock, itemstatus, costperitem, itemcategory);
            String url = request.getContextPath() + "/staffCatalog.jsp";
            response.sendRedirect(url);
//            request.getRequestDispatcher("Payment.jsp").include(request, response);
        } catch (NullPointerException ex) { //if there is error of type "x" do this
            System.out.println(ex.getMessage() == null ? "Unable to create Payment Details" : "Payment Details Created");
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
