/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.Item;
import uts.isd.model.User;
import uts.isd.model.Order;
import uts.isd.model.LineItem;

/**
 *
 * @author vu.huynh
 */
public class CartDAO {
    private Statement st;
    private PreparedStatement deleteSt1;
    private String deleteQuery1 = "DELETE FROM CART WHERE CARTID= ?";
    
    public CartDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        
        st = connection.createStatement();
        deleteSt1 = connection.prepareStatement(deleteQuery1);
    }
    
    //Create Operation: create a order
    public void createCart(String arrival_date, float total_items, int shipping_price, int custID) throws SQLException {
        String columns = "INSERT INTO iotadmin.ORDERS(arrival_date, total_items, shipping_price, custID)";
        String values = "VALUES('" + arrival_date + "','" + total_items + "','" + shipping_price + "','" + custID + "')";
        st.executeUpdate(columns + values);
        
    }
    
    //Delete Operation
    public void itemDelete(int cartID) throws SQLException {
        deleteSt1.setString(1, Integer.toString(cartID));
        int row = deleteSt1.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }
}
