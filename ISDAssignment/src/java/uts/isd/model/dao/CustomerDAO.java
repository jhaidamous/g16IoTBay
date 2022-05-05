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
 * @author george
 */
public class CustomerDAO {

    private Statement st;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt1;
    private PreparedStatement deleteSt2;
    private String readQuery =  "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.CUSTID AND EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE USERS SET EMAILADDRESS=?, PASSWORD=?, FIRSTNAME=?, LASTNAME=?, MIDDLENAME=?, PHONE=?, DOB=?, DISABLED=? WHERE USERID=?";
    private String deleteQuery1 = "DELETE FROM CUSTOMER_USER WHERE CUSTID= ?";
    private String deleteQuery2 = "DELETE FROM USERS WHERE USERID= ?";
    
    public CustomerDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery);
        updateSt = connection.prepareStatement(updateQuery);
        deleteSt1 = connection.prepareStatement(deleteQuery1);
        deleteSt2 = connection.prepareStatement(deleteQuery1);
    }

    //Create Operation: create a user
    public void createCustomer(String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
        String columns = "INSERT INTO iotadmin.USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)";
        String values = "VALUES('" + firstname + "','" + lastname + "','" + middlename + "','" + emailaddress + "','" + phone + "','" + dob + "','" + password + "')";
        st.executeUpdate(columns + values);
        String query = "SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = '" + emailaddress + "'";
        ResultSet rs = st.executeQuery(query);
        String userID = rs.getString(1);
        boolean disabled = false;
        String columns2 = "INSERT INTO iotadmin.CUSTOMER_USER(CUSTID, PASSWORD, DISABLED)";
        String values2 = "VALUES('" + userID + "','" + password + "', '" + disabled + "')";
        st.executeUpdate(columns2 + values2);
    }

    Read Operation: user login
    public Customer login(String emailaddress, String password) throws SQLException {
        readSt.setString(1, emailaddress);
        readSt.setString(2, password);
        ResultSet rs = readSt.executeQuery();
        
        while (rs.next()) {
            String useremail = rs.getString(1);
            String userpass = rs.getString(2);
            
            if (emailaddress.equals(useremail) && password.equals(userpass)) {
                int userID = Integer.parseInt(rs.getString(1));
                String firstname = rs.getString(3);
                String lastname = rs.getString(4);
                String middlename = rs.getString(5);
                String phone = rs.getString(6);
                String dob = rs.getString(7);
                boolean disabled = Boolean.parseBoolean(rs.getString(8));
                return new Customer(userID, firstname, lastname, middlename, useremail, phone, dob, userpass, disabled);
            }
        }
        return null;
    }
    
    //needs some work on USERID and the SQL query needs to hit both tables -- and password
    //Update Operation: update user
    public void update(int userID, String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
        updateSt.setString(1, emailaddress);
        updateSt.setString(2, password);
        updateSt.setString(3, firstname);
        updateSt.setString(4, lastname);
        updateSt.setString(5, middlename);
        updateSt.setString(6, phone);
        updateSt.setString(7, dob);
        updateSt.setString(8, Integer.toString(userID));
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }

    //Delete Operation: user deletes their account after logging in 
    public void selfDelete(int ID) throws SQLException {
        deleteSt1.setString(1, Integer.toString(ID));
        deleteSt2.setString(1, Integer.toString(ID));
        deleteSt1.executeUpdate();
        int row = deleteSt2.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }

    //Fetch All: List all users
    public ArrayList<Customer> fetchUsers() throws SQLException {
        String fetch = "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.CUSTID";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> users = new ArrayList();

        while (rs.next()) {
            int userID = Integer.parseInt(rs.getString(1));
            String emailaddress = rs.getString(2);
            String password = rs.getString(3);
            String firstname = rs.getString(4);
            String lastname = rs.getString(5);
            String middlename = rs.getString(6);
            String phone = rs.getString(7);
            String dob = rs.getString(8);
            boolean disabled = Boolean.parseBoolean(rs.getString(9));
            users.add(new Customer(userID, firstname, lastname, middlename, emailaddress, phone, dob, password, disabled));
        }
        return users;
    }
}
