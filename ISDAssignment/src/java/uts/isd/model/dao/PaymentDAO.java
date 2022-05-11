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
import uts.isd.model.Payment;
import uts.isd.model.User;
/**
 *
 * @author Anas Awais
 */
public class PaymentDAO {
    
    private Statement st;
    private OrderDAO orderDAO;

    private PreparedStatement totalst;
    private String totalquery = "SELECT CATALOG_ITEM.item_price, LINE_ITEM.item_quantity FROM CATALOG_ITEM RIGHT OUTER JOIN LINE_ITEM ON CATALOG_ITEM.itemID= LINE_ITEM.itemID WHERE LINE_ITEM.itemID IN (SELECT LINE_ITEM.itemID FROM LINE_ITEM, CART WHERE LINE_ITEM.cartID = (SELECT ORDERS.cartID FROM ORDERS WHERE ORDERS.orderID = ? ))";
    
    
    public PaymentDAO(Connection connection) throws SQLException {
        OrderDAO orderDAO = new OrderDAO(connection);
        connection.setAutoCommit(true);
        st = connection.createStatement();
        totalst = connection.prepareStatement(totalquery);

    }
    
    //Create Operation: create a payment record
    public void createPayment(String payment_error, String payment_status, int orderID) throws SQLException {
        String columns = "INSERT INTO iotadmin.payment(payment_error,payment_status,orderID)";
        String values = "VALUES('"+payment_error+"','"+payment_status+"','"+orderID+"')";
        st.executeUpdate(columns+values);      
    }
    

    //Fetch All: fetch all recrods of payment, by userID
    public ArrayList<Payment> fetchPayments(int userID) throws SQLException {
        String fetch = "SELECT * FROM payment WHERE paymentID IN (SELECT paymentID FROM orders WHERE custID = "+userID+")"; 
//fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs1 = null;
        rs1 = st.executeQuery(fetch);
        ArrayList<Payment> payments = new ArrayList<Payment>();     
        while (rs1.next()) {            
            int paymentID = Integer.parseInt(rs1.getString(1));
            String payment_error =  rs1.getString(2);
            String payment_status = rs1.getString(3);
            String payment_date = rs1.getString(4);
            int pay_det_num = Integer.parseInt(rs1.getString(5));
            int custID = Integer.parseInt(rs1.getString(6));
            int orderID = Integer.parseInt(rs1.getString(7));
//            rs1.close();
            System.out.println("This is OrderID"+ orderID);
            if (orderDAO == null) {
            System.out.println("OrderDAO is NULL");
            }
//            System.out.println("This is total"+ orderDAO.calculateTotal(1));
            payments.add(new Payment(paymentID,payment_error,payment_status,payment_date, pay_det_num, custID, orderID, calculateTotal(orderID)));
        }   
        return payments;
            
    }
    
        public double calculateTotal(int orderID) throws SQLException {
            totalst.setString(1, Integer.toString(orderID));
            ResultSet rs = totalst.executeQuery();

//            String fetch = "SELECT CATALOG_ITEM.item_price, LINE_ITEM.item_quantity FROM CATALOG_ITEM RIGHT OUTER JOIN LINE_ITEM ON CATALOG_ITEM.itemID= LINE_ITEM.itemID WHERE LINE_ITEM.itemID IN (SELECT LINE_ITEM.itemID FROM LINE_ITEM, CART WHERE LINE_ITEM.cartID = (SELECT ORDERS.cartID FROM ORDERS WHERE ORDERS.orderID = "+ orderID +" ))";

//                    "SELECT CATALOG_ITEM.item_price, LINE_ITEM.item_quantity "
//                        + "FROM CATALOG_ITEM RIGHT OUTER JOIN LINE_ITEM "
//                        + "ON CATALOG_ITEM.itemID= LINE_ITEM.itemID "
//                        + "WHERE LINE_ITEM.itemID IN "
//                        + "(SELECT LINE_ITEM.itemID FROM LINE_ITEM, CART WHERE LINE_ITEM.cartID = "
//                        + "(SELECT ORDERS.cartID FROM ORDERS WHERE ORDERS.orderID = "+ orderID +" ))";
//            ResultSet rs = null;
//            rs = st.executeQuery(fetch);
            double total = 0;
            while (rs.next()) 
            {            
                double item_price = Double.parseDouble(rs.getString(1));
                int item_quantity =  Integer.parseInt(rs.getString(2));
                total += (item_price * item_quantity);
            }
//            rs.close();
            return total;
        }
    
        
    public ArrayList<Payment> searchPayments(String searchpay) throws SQLException {
        System.out.print(searchpay.toLowerCase());
        String fetch = "SELECT * FROM iotadmin.payment WHERE paymentID = "+searchpay+"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> payments = new ArrayList<Payment>();
        
        while (rs.next()) {            
            int paymentID = Integer.parseInt(rs.getString(1));
            String payment_error =  rs.getString(2);
            String payment_status = rs.getString(3);
            String payment_date = rs.getString(4);
            int pay_det_num = Integer.parseInt(rs.getString(5));
            int custID = Integer.parseInt(rs.getString(6));
            int orderID = Integer.parseInt(rs.getString(7));
            payments.add(new Payment(paymentID, payment_error, payment_status, payment_date, pay_det_num, custID, orderID, calculateTotal(orderID)));
        }
        return payments;
    }
    
    
    public ArrayList<Payment> searchPayDate(String searchpay) throws SQLException {
        System.out.print(searchpay.toLowerCase());
        String fetch = "SELECT * FROM iotadmin.payment WHERE payment_date = '"+searchpay+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Payment> payments = new ArrayList<Payment>();
        
        while (rs.next()) {            
            int paymentID = Integer.parseInt(rs.getString(1));
            String payment_error =  rs.getString(2);
            String payment_status = rs.getString(3);
            String payment_date = rs.getString(4);
            int pay_det_num = Integer.parseInt(rs.getString(5));
            int custID = Integer.parseInt(rs.getString(6));
            int orderID = Integer.parseInt(rs.getString(7));
            payments.add(new Payment(paymentID, payment_error, payment_status, payment_date, pay_det_num, custID, orderID, calculateTotal(orderID)));
        }
        return payments;
    }            
        //search by ID or date, to be done 
}