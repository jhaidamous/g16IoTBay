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
public class OrderDAO {
    
    private Statement st;
    
    public OrderDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }
    
    //Create Operation: create a order
    public void createOrder(String order_date, String order_status) throws SQLException {
        String columns = "INSERT INTO iotadmin.ORDERS(order_date, order_status)";
        String values = "VALUES('" + order_date + "','" + order_status + "')";
        st.executeUpdate(columns + values);
        
    }
    
    //Fetch One Order
    public Order readOrder(int orderID) throws SQLException {
        String fetch = "SELECT * FROM ORDERS WHERE ORDERS.ORDERID='" + orderID + "'";
        ResultSet rs = st.executeQuery(fetch);

            orderID = Integer.parseInt(rs.getString(1));
            int custID = Integer.parseInt(rs.getString(2));
            int cartID= Integer.parseInt(rs.getString(3));
            String arrival_date = rs.getString(4);
            String order_date = rs.getString(5);
            String order_status = rs.getString(6);
    
           Order order = new Order(orderID, custID, cartID, order_date, order_status);
        
        return order;
    }
    
    
    //Fetch All
    public ArrayList<Order> fetchOrder(int custID) throws SQLException {
        String fetch = "SELECT * FROM ORDERS WHERE ORDERS.CUSTID='" + custID + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> orders = new ArrayList();

        while (rs.next()) {
            int orderID = Integer.parseInt(rs.getString(1));
            custID = Integer.parseInt(rs.getString(2));
            int cartID= Integer.parseInt(rs.getString(3));
            String order_date = rs.getString(6);
            String order_status = rs.getString(7);
    
            orders.add(new Order(orderID, custID, cartID, order_date, order_status));
        }
        return orders;
    }
    
    
    
    

}
