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
    private PreparedStatement updateSt1;
    private PreparedStatement updateSt2;
    private PreparedStatement deleteSt1;
    private PreparedStatement deleteSt2;
    private PreparedStatement disabledSt;
    private PreparedStatement enabledSt;
    private String readQuery1 =  "SELECT USERID, EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, CUSTOMER_USER WHERE USERS.USERID=CUSTOMER_USER.CUSTID AND EMAILADDRESS=? AND PASSWORD=?";
    private String updateQuery1 = "UPDATE USERS SET EMAILADDRESS=?, FIRSTNAME=?, LASTNAME=?, MIDDLENAME=?, PHONE=?, DOB=? WHERE USERID=?";
    private String updateQuery2 = "UPDATE CUSTOMER_USER SET PASSWORD=? WHERE CUSTOMER_USER.CUSTID=?";
    private String deleteQuery1 = "DELETE FROM iotadmin.CUSTOMER_USER WHERE CUSTID= ?";
    private String deleteQuery2 = "DELETE FROM USERS WHERE USERID= ?";
    private String disabledQuery = "UPDATE CUSTOMER_USER SET DISABLED=TRUE WHERE CUSTID=?";
    private String enableQuery = "UPDATE CUSTOMER_USER SET DISABLED=FALSE WHERE CUSTID=?";
    
    public CustomerDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery1);
        updateSt1 = connection.prepareStatement(updateQuery1);
        updateSt2 = connection.prepareStatement(updateQuery2);
        deleteSt1 = connection.prepareStatement(deleteQuery1);
        deleteSt2 = connection.prepareStatement(deleteQuery2);
        disabledSt = connection.prepareStatement(disabledQuery);
        enabledSt = connection.prepareStatement(enableQuery);
    }

    //Create Operation: create a user
    public void createCustomer(String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
        String columns = "INSERT INTO iotadmin.USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)";
        String values = "VALUES('" + firstname + "','" + lastname + "','" + middlename + "','" + emailaddress + "','" + phone + "','" + dob + "')";
        st.executeUpdate(columns + values);
        String query = "SELECT USERID FROM iotadmin.USERS WHERE EMAILADDRESS = '" + emailaddress + "'";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        String userID = rs.getString(1);
        boolean disabled = false;
        String columns2 = "INSERT INTO iotadmin.CUSTOMER_USER(CUSTID, PASSWORD, DISABLED)";
        String values2 = "VALUES(" + userID + ",'" + password + "', '" + disabled + "')";
        st.executeUpdate(columns2 + values2);
    }

    //Read Operation: user login
    public Customer login(String emailaddress, String password) throws SQLException {
        readSt.setString(1, emailaddress);
        readSt.setString(2, password);
        ResultSet rs = readSt.executeQuery();
        
        while (rs.next()) {
            String useremail = rs.getString(2);
            String userpass = rs.getString(3);
            
            if (emailaddress.equals(useremail) && password.equals(userpass)) {
//                System.out.print(rs.getString(1));
                int userID = Integer.parseInt(rs.getString(1));
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String middlename = rs.getString(6);
                String phone = rs.getString(7);
                String dob = rs.getString(8);
                boolean disabled = Boolean.parseBoolean(rs.getString(9));
                System.out.print("Creating Customer");
                return new Customer(userID, firstname, lastname, middlename, useremail, phone, dob, userpass, disabled);
            }
            else {
                System.out.print("Unable to Creating Customer "+useremail);

            }
        }
        
        return null;
        
    }
    
    
    //needs some work on USERID and the SQL query needs to hit both tables -- and password
    //Update Operation: update user
    public void update(int userID, String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
        updateSt1.setString(1, emailaddress);
        updateSt1.setString(2, firstname);
        updateSt1.setString(3, lastname);
        updateSt1.setString(4, middlename);
        updateSt1.setString(5, phone);
        updateSt1.setString(6, dob);
        updateSt1.setString(7, Integer.toString(userID));
        updateSt2.setString(1, password);
        updateSt2.setString(2, Integer.toString(userID));
        updateSt1.executeUpdate();
        updateSt2.executeUpdate();

        System.out.println("row updated successfuly");
    }

    //Delete Operation: user deletes their account after logging in 
    public void selfDelete(int ID) throws SQLException {
        deleteSt1.setString(1, Integer.toString(ID));
        deleteSt2.setString(1, Integer.toString(ID));
        deleteSt1.executeUpdate();
        deleteSt2.executeUpdate();
        System.out.println("row deleted successfuly");
    }
    public void disableUser(int custID) throws SQLException {
        disabledSt.setString(1, Integer.toString(custID));
        int row = disabledSt.executeUpdate();
        System.out.println("customer "+row+" disabled successfuly");
    }
    public void enableUser(int custID) throws SQLException {
        enabledSt.setString(1, Integer.toString(custID));
        int row = enabledSt.executeUpdate();
        System.out.println("customer "+row+" enabled successfuly");
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
