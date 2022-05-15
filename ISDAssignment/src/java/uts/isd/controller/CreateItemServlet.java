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
        ItemDAO itemDAO = (ItemDAO) session.getAttribute("itemDAO");

        String itemname = (String) request.getParameter("itemname");
        String itemstatus = (String) request.getParameter("itemstatus");
        String itemcategory = (String) request.getParameter("itemcategory");
        
        double itemprice = 0;
        double costperitem = 0;
        int itemstock = 0;
        boolean error = false;

        try {
            itemprice = Double.parseDouble((String)request.getParameter("itemprice"));
            costperitem = Double.parseDouble((String)request.getParameter("costperitem"));
        }
        catch (NumberFormatException ex) {
            session.setAttribute("priceErr", "Error: Price format is incorrect");
            error = true;
        }
        
        try {
            itemstock = Integer.parseInt((String)request.getParameter("itemstock"));
        } 
        catch (NumberFormatException e) {
            session.setAttribute("stockErr", "Error: Stock format is incorrect");
            error = true;
        }
        
        Validator validator = new Validator();
        Validator.clearItems(session);
        
        
        if (!validator.validatePrice(itemprice)) {
            session.setAttribute("priceErr", "Error: Price format is incorrect");
            error = true;
        }
        if (!validator.validatePrice(costperitem)) {
            session.setAttribute("priceErr", "Error: Price format is incorrect");
            error = true;
        }        
        if (!validator.validateStock(itemstock)) {
            session.setAttribute("stockErr", "Error: Stock format is incorrect");
            error = true;
        }       
        
        if (!validator.validateItemName(itemname)) {
            session.setAttribute("itemNameErr", "Error: Item name format is incorrect");
            error = true;
        }
        
        if (error) {
            request.getRequestDispatcher("login.jsp").include(request, response);
            String url = request.getContextPath() + "/createItem.jsp";
            response.sendRedirect(url);
        }
        else {
            try {

                //create the payment details from the attributes we got above
                itemDAO.createItem(itemname, itemprice, itemstock, itemstatus, costperitem, itemcategory);
                String url = request.getContextPath() + "/staffCatalog.jsp";
                response.sendRedirect(url);
    //            request.getRequestDispatcher("Payment.jsp").include(request, response);
            } catch (NullPointerException ex) { //if there is error of type "x" do this
                System.out.println(ex.getMessage() == null ? "Unable to create Item " : "Payment Details Created");
            } catch (SQLException ex) {
                Logger.getLogger(PaymentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
