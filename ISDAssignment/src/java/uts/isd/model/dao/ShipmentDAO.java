/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Shipment;

/**
 *
 * @author steve
 */
public class ShipmentDAO {
     private Statement st;
    
    public ShipmentDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }
    
    //Create Operation: create an item
   public void createShipment(int shipmentID, int orderID, String ship_method, String ship_date, String ship_status, int custID) throws SQLException {
        String columns = "INSERT INTO iotadmin.shipment(orderID,ship_method,ship_date,ship_status,custID)";
        String values = "VALUES('"+orderID+"','"+ship_method+"','"+ship_date+"','"+ship_status+"','"+custID+"')";
        st.executeUpdate(columns+values);      
    }
    

    //Fetch one by shipment ID
        public Shipment fethchoneShipment(int shipmentID) throws SQLException {
        String fetch = " SELECT * FROM shipment WHERE shipmentID = '"+shipmentID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        
        int orderID =  Integer.parseInt(rs.getString(2));
        String ship_method = rs.getString(3);        
        String ship_date = rs.getString(4);
        String ship_status = rs.getString(5);
        int custID = Integer.parseInt(rs.getString(6));
        Shipment ds = new Shipment(orderID,ship_method,ship_date,ship_status,custID);
        return ds;
        
            
    } //Fetch All: fetch all recrods of payment, by userID
    public ArrayList<Shipment> fetchShipments(int shipmentID) throws SQLException {
        String fetch = " SELECT * FROM shipment WHERE shipmentID = '"+shipmentID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Shipment> shipment = new ArrayList<>();     
        
        while (rs.next()) {            
        shipmentID = Integer.parseInt(rs.getString(1));
        int orderID =  Integer.parseInt(rs.getString(2));
        String ship_method = rs.getString(3);        
        String ship_date = rs.getString(4);
        String ship_status = rs.getString(5);
        int custID = Integer.parseInt(rs.getString(6));
        shipment.add(new Shipment(shipmentID,orderID,ship_method,ship_date,ship_status,custID));
        }
        return shipment;
            
    }
}
