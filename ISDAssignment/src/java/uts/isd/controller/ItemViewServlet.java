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
import uts.isd.model.Item;
import uts.isd.model.User;
import uts.isd.model.dao.ItemDAO;
import uts.isd.model.dao.UserDAO;

/**
 *
 * @author JHUTS
 */
public class ItemViewServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String test3 = (String)session.getAttribute("test3");
        ItemDAO itemDAO = (ItemDAO)session.getAttribute("itemDAO");
        if (itemDAO == null) {
            String test2 = "itemdao is null";
            session.setAttribute("test2", test2);
        }
        if (test3 == null) {
            String test4 = "test3 is null";
            session.setAttribute("test4", test4);
        }
        else {
            String test4 = test3;
            session.setAttribute("test4", test4);
        }

        try {
            String test = "this istest";
            session.setAttribute("test", test);
            ArrayList<Item> items = itemDAO.fetchItems();
            session.setAttribute("items", items);
            ArrayList<Categories> categories = itemDAO.fetchCategories();
            session.setAttribute("categories", categories);
//            request.getRequestDispatcher("store.jsp").include(request, response);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Items not found in DB" : "Items found");
        } catch (SQLException ex) {
            Logger.getLogger(ItemViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String searchq = request.getParameter("searchq");
        String regsearch = request.getParameter("regsearch");
        ItemDAO itemDAO = (ItemDAO)session.getAttribute("itemDAO");
        
        try {
            if (regsearch != null) {
                System.out.print(searchq);
                ArrayList<Item> searchItems = itemDAO.searchItems(searchq);
                session.setAttribute("searchItems", searchItems);
                }
            else {
                System.out.print(searchq + "here");
                ArrayList<Item> searchItems = itemDAO.searchCategories(searchq);
                session.setAttribute("searchItems", searchItems);
            }
            String url = request.getContextPath() + "/storeSearch.jsp";
            response.sendRedirect(url);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Items not found in DB" : "Items found");
            String url = request.getContextPath() + "/storeSearch.jsp";
            response.sendRedirect(url);
        } catch (SQLException ex) {
            Logger.getLogger(ItemViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
