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
import uts.isd.model.Customer;

/**
 *
 */
public class PaymentDetailsDAO {

    private Statement st;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
//    private String readQuery =  "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.USERID AND EMAIL=? AND PASSWORD=?";
//    private String updateQuery = "UPDATE USERS SET EMAILADDRESS=?, PASSWORD=?, FIRSTNAME=?, LASTNAME=?, MIDDLENAME=?, PHONE=?, DOB=?, DISABLED=? WHERE USERID=?";
//    private String deleteQuery = "DELETE FROM USERS WHERE USERID= ?";
    
    public PaymentDetailsDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery);
        updateSt = connection.prepareStatement(updateQuery);
        deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Operation: create a record of payment details
    public void createPaymentDetails(String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
//        String columns = "INSERT INTO USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)";
//        String values = "VALUES('" + firstname + "','" + lastname + "','" + middlename + "','" + emailaddress + "','" + phone + "','" + dob + "','" + password + "')";
//        st.executeUpdate(columns + values);
//        String query = "SELECT USERID FROM USERS WHERE EMAILADDRESS = '" + emailaddress + "'";
//        ResultSet rs = st.executeQuery(query);
//        String userID = rs.getString(1);
//        boolean disabled = false;
//        String columns2 = "INSERT INTO CUSTOMER_USER(USERID, PASSWORD, DISABLED)";
//        String values2 = "VALUES('" + userID + "','" + password + "', '" + disabled + "')";
//        st.executeUpdate(columns2 + values2);
    }


    //Update Operation: update patment details by custID + paydetnum
    public void update(int userID, String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
//        updateSt.setString(1, emailaddress);
//        updateSt.setString(2, password);
//        updateSt.setString(3, firstname);
//        updateSt.setString(4, lastname);
//        updateSt.setString(5, middlename);
//        updateSt.setString(6, phone);
//        updateSt.setString(7, dob);
//        updateSt.setString(8, Integer.toString(userID));
//        int row = updateSt.executeUpdate();
//        System.out.println("row "+row+" updated successfuly");
    }

    //Delete Operation: delete a payment details by custID and paydetnum
    public void delete(int ID) throws SQLException {
//        deleteSt.setString(1, Integer.toString(ID));
//        int row = deleteSt.executeUpdate();
//        System.out.println("row "+row+" deleted successfuly");
    }

    //Fetch All: Read all payment details by a userID
    public ArrayList<PaymentDetails> fetchPayDet() throws SQLException {
//        String fetch = "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.USERID";
//        ResultSet rs = st.executeQuery(fetch);
//        ArrayList<Customer> users = new ArrayList();
//
//        while (rs.next()) {
//            int userID = Integer.parseInt(rs.getString(1));
//            String emailaddress = rs.getString(2);
//            String password = rs.getString(3);
//            String firstname = rs.getString(4);
//            String lastname = rs.getString(5);
//            String middlename = rs.getString(6);
//            String phone = rs.getString(7);
//            String dob = rs.getString(8);
//            boolean disabled = Boolean.parseBoolean(rs.getString(9));
//            users.add(new Customer(userID, firstname, lastname, middlename, emailaddress, phone, dob, password, disabled));
//        }
//        return users;
    }
}
