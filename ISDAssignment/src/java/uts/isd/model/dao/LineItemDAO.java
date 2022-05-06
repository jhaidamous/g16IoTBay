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
public class LineItemDAO {
        private Statement st;
        private PreparedStatement deleteSt1;
        private String deleteQuery1 = "DELETE FROM LINE_ITEM WHERE LINEID= ?";
    
    public LineItemDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        deleteSt1 = connection.prepareStatement(deleteQuery1);
    }
    
    //Create Operation
    public void createLineItem(int itemID, int item_quantity, int cartID) throws SQLException {
        String columns = "INSERT INTO iotadmin.line_item(itemID, item_quantity, cartID)";
        String values = "VALUES(" + itemID + "," + item_quantity + "," + cartID + ")";
        st.executeUpdate(columns + values);
        
    }
    
    //Delete Operation
    public void itemDelete(int lineID) throws SQLException {
        deleteSt1.setString(1, Integer.toString(lineID));
        int row = deleteSt1.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }
    
    //Fetch All
    public ArrayList<LineItem> fetchLineItem(int itemID) throws SQLException {
        String fetch = "SELECT * FROM ORDERS WHERE LINE_ITEM.ITEMID='" + itemID + "'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<LineItem> lineItems = new ArrayList();

        while (rs.next()) {
            
        int lineID = Integer.parseInt(rs.getString(1));
        itemID = Integer.parseInt(rs.getString(2));
        int item_quantity = Integer.parseInt(rs.getString(3));
        int cartID= Integer.parseInt(rs.getString(4));
        
        lineItems.add(new LineItem(lineID, itemID, item_quantity, cartID));
        
        }
        return lineItems;
    }
}
