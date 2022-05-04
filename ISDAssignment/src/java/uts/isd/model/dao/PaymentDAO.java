/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Payment;
import uts.isd.model.User;
/**
 *
 * @author Anas Awais
 */
public class PaymentDAO {
    
    private Statement st;
    
    public PaymentDAO(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    //Create Operation: create a payment record
    public void createPayment(String payment_error, String payment_status, String temp_CVC, String temp_card_number, String temp_expiry_date, int orderID) throws SQLException {
        String columns = "INSERT INTO iotadmin.catalog_item(item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path)";
        String values = "VALUES('"+payment_error+"','"+payment_status+"','"+temp_CVC+"','"+temp_card_number+"','"+temp_expiry_date+"','"+orderID+"')";
        st.executeUpdate(columns+values);      
    }
    

    //Fetch All: fetch all recrods of payment, by userID
    public ArrayList<Payment> fetchPayments(String userID) throws SQLException {
        String fetch = " SELECT * FROM payment WHERE paymentID = (SELECT paymentID FROM orders WHERE userID = '"+userID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> payment = new ArrayList<Payment>();     
        
        while (rs.next()) {            
            int paymentID = Integer.parseInt(rs.getString(1));
            String payment_error =  rs.getString(2);
            String payment_status = rs.getString(3);
            String temp_CVC = rs.getString(4);
            String temp_card_number = rs.getString(5);
            String temp_expiry_date = rs.getString(6);
            int orderID = Integer.parseInt(rs.getString(7));
            payment.add(new Payment(paymentID,payment_error,payment_status,temp_CVC,temp_card_number,temp_expiry_date,orderID));
        }
        return payment;
            
        }
    
        //search by ID or date, to be done 
}