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
import uts.isd.model.Logs;
import uts.isd.model.User;
import uts.isd.model.dao.ItemDAO;
import uts.isd.model.dao.LogsDAO;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author JHUTS
 */
public class LogoutServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        LogsDAO logsDAO = (LogsDAO)session.getAttribute("logsDAO");
        

        try {
            logsDAO.createLogs(customer.getUserID(), "Logged out");
            session.invalidate();
//            request.getRequestDispatcher("store.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Logs not found in DB" : "Items found");
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}

