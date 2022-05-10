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
import uts.isd.model.PaymentDetails;
import uts.isd.model.Customer;

/**
 *
 */
public class PaymentDetailsDAO {

    private Statement st;
//    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
//    private String readQuery =  "SELECT custID, pay_det_num, cvc, cardnum, expirydate DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.USERID AND EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE iotadmin.PAYMENT_DETAILS SET custID=?, pay_det_num=?, cvc=?, cardnum=?, expirydate=?, DISABLED=? WHERE CUSTID=? AND PAY_DET_NUM=?";
    private String deleteQuery = "DELETE FROM iotadmin.PAYMENT_DETAILS WHERE CUSTID= ? AND PAY_DET_NUM=?";
    
    public PaymentDetailsDAO(Connection connection) throws SQLException {
        
        connection.setAutoCommit(true);
        st = connection.createStatement();
//        readSt =  connection.prepareStatement(readQuery);
        updateSt = connection.prepareStatement(updateQuery);
        deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Operation: create a record of payment details
    public void createPaymentDetails(int custID, int cvc, String cardnum, String expirydate) throws SQLException {
        String columns = "INSERT INTO iotadmin.payment_details(custID,pay_det_num,cvc,cardnum,expirydate)";
        String values = "VALUES('"+custID+"','"+cvc+"','"+cardnum+"','"+expirydate+"')";
        st.executeUpdate(columns+values);      
    }
//Read one payment detail by a cardno 
    public PaymentDetails read(String cardnum) throws SQLException {
        String fetch = " SELECT * FROM payment_details WHERE cardnum='"+cardnum+"'"; 
        ResultSet rs = st.executeQuery(fetch);
        int cvc;
        String expirydate;
        int pay_det_num;
        int custID;
        custID = Integer.parseInt(rs.getString(1));
        pay_det_num =  Integer.parseInt(rs.getString(2));
        cvc =   Integer.parseInt(rs.getString(3));
        cardnum = rs.getString(4);
        expirydate = rs.getString(5); //Check this
        PaymentDetails paymentDetails= new PaymentDetails(custID,pay_det_num,cvc,cardnum,expirydate);
        
        return paymentDetails;
            
        }
    //Update Operation: update payment details by custID + paydetnum
    public void update(int custID, int pay_det_num, int cvc, String cardnum, String expirydate) throws SQLException {
        updateSt.setString(1, Integer.toString(custID));
        updateSt.setString(2, Integer.toString(pay_det_num));
        updateSt.setString(3, Integer.toString(cvc));
        updateSt.setString(4, cardnum);
        updateSt.setString(5, expirydate);
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }

    //Delete Operation: delete a payment details by custID and paydetnum
    public void delete(int custID, int pay_det_num) throws SQLException {
        deleteSt.setString(1, Integer.toString(custID));
        deleteSt.setString(2, Integer.toString(pay_det_num));
        int row = deleteSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }

    //Fetch All: Read all payment details by a custID // CHECK THIS
    public ArrayList<PaymentDetails> fetchPaymentDetails(int custID) throws SQLException {
        String fetch = " SELECT * FROM payment_details WHERE custID='"+custID+"' "; 
        //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentDetails> paymentDetails = new ArrayList<PaymentDetails>();     
        int pay_det_num;
        int cvc;
        String cardnum;
        String expirydate;
        while (rs.next()) {            
            custID = Integer.parseInt(rs.getString(1));
            pay_det_num =  Integer.parseInt(rs.getString(2));
            cvc =   Integer.parseInt(rs.getString(3));
            cardnum = rs.getString(4);
            expirydate = rs.getString(5); //Check this
            paymentDetails.add(new PaymentDetails(custID,pay_det_num,cvc,cardnum,expirydate));
        }
        return paymentDetails;
            
        }
}
