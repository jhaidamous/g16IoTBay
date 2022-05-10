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
import uts.isd.model.Categories;
import uts.isd.model.Customer;
import uts.isd.model.Item;
import uts.isd.model.User;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.ItemDAO;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author JHUTS
 */
public class SearchServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        CustomerDAO customerDAO = (CustomerDAO)session.getAttribute("customerDAO");
        try {
            ArrayList<Customer> customers = customerDAO.fetchUsers();
            session.setAttribute("customers", customers);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Customers not found" : "customer found");
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String custsearch = request.getParameter("custsearch");
        CustomerDAO customerDAO = (CustomerDAO)session.getAttribute("customerDAO");
        
        try {
                ArrayList<Customer> custsearchlist = customerDAO.searchCustomers(custsearch);
                session.setAttribute("custsearchlist", custsearchlist);

            String url = request.getContextPath() + "/systemadmin.jsp";
            response.sendRedirect(url);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "customer not found" : "customer");
            String url = request.getContextPath() + "/systemadmin.jsp";
            response.sendRedirect(url);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
