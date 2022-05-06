/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Payment;
import uts.isd.model.ShipmentDetails;

/**
 *
 * @author steve
 */
public class ShipmentDetailsDAO {
    private Statement st;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt1;
    private String updateQuery = "UPDATE Shipment_Details SET streetnum=?,streetname=?, suburb=?, postcode=?, states=?, country=? WHERE custID=?";
    private String deleteQuery = "DELETE FROM Shipment_Details WHERE CUSTID= ?";
    
    public ShipmentDetailsDAO(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    //Create Operation: create a payment record
    public void createShipmentDetails(int custID, String streetnum, String streetname, String suburb, String postcode, String states, String country) throws SQLException {
        String columns = "INSERT INTO iotadmin.Shipment_Details(custID, streetnum, streetname, suburb, postcode, states, country)";
        String values = "VALUES('"+custID+"'"+streetnum+"','"+streetname+"','"+suburb+"','"+postcode+"','"+states+"','"+country+"')";
        st.executeUpdate(columns+values);      
    }
        public void updateShipmentDetails(int custID, String streetnum, String streetname, String suburb, String postcode, String states, String country) throws SQLException {
        updateSt.setString(1, streetnum);
        updateSt.setString(2, streetname);
        updateSt.setString(3, suburb);
        updateSt.setString(4, postcode);
        updateSt.setString(5, states);
        updateSt.setString(6, country);
        updateSt.setString(7, Integer.toString(custID));
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }
        
            public void selfDeleteShipmentDetails(int custID) throws SQLException {
        deleteSt1.setString(1, Integer.toString(custID));
        deleteSt1.executeUpdate();
        int row = deleteSt1.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }


    //Fetch All: fetch all recrods of payment, by userID
//    public ArrayList<ShipmentDetails> fetchShipmentDetails(int custID) throws SQLException {
//        String fetch = " SELECT streetnum, streetname, suburb, postcode, states, country FROM shipment_details WHERE custID = '"+custID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
//        ResultSet rs = st.executeQuery(fetch);
//        ArrayList<ShipmentDetails> shipmentdetails = new ArrayList<ShipmentDetails>();     
//        
//        while (rs.next()) {            
//            custID = Integer.parseInt(rs.getString(1));
//            String streetnum =  rs.getString(2);
//            String streetname = rs.getString(3);
//            String suburb = rs.getString(4);
//            String postcode = rs.getString(5);
//            String states = rs.getString(6);
//            String country = rs.getString(7);
//            shipmentdetails.add(new ShipmentDetails(custID,streetnum,streetname,suburb,postcode,states,country));
//        }
//        return shipmentdetails;
//            
//        }
    
}
