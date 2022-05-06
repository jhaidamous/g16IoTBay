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
    public void createPayment(String payment_error, String payment_status, int orderID) throws SQLException {
        String columns = "INSERT INTO iotadmin.payment(payment_error,payment_status,orderID)";
        String values = "VALUES('"+payment_error+"','"+payment_status+"','"+orderID+"')";
        st.executeUpdate(columns+values);      
    }
    

    //Fetch All: fetch all recrods of payment, by userID
    public ArrayList<Payment> fetchPayments(String userID) throws SQLException {
        String fetch = " SELECT * FROM payment WHERE paymentID = (SELECT paymentID FROM orders WHERE custID = '"+userID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> payment = new ArrayList<Payment>();     
        
        while (rs.next()) {            
            int paymentID = Integer.parseInt(rs.getString(1));
            String payment_error =  rs.getString(2);
            String payment_status = rs.getString(3);
            int orderID = Integer.parseInt(rs.getString(4));
            payment.add(new Payment(paymentID,payment_error,payment_status,orderID));
        }
        return payment;
            
        }
    
        //search by ID or date, to be done 
}