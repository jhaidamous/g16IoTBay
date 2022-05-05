/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 */
package uts.isd.model.dao;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Customer;
import uts.isd.model.Staff;

/**
 *
 * @author george
 */
public class StaffDAO {

    private Statement st;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private String readQuery =  "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, STAFF_USER WHERE USERS.USERID=STAFF_USER.USERID AND EMAIL=? AND PASSWORD=?";
    private String updateQuery = "UPDATE USERS SET EMAILADDRESS=?, PASSWORD=?, FIRSTNAME=?, LASTNAME=?, MIDDLENAME=?, PHONE=?, DOB=?, DISABLED=? WHERE USERID=?";
    private String deleteQuery = "DELETE FROM USERS WHERE USERID= ?";
    
    public StaffDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery);
        updateSt = connection.prepareStatement(updateQuery);
        deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Operation: create a user
    public void createStaff(String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password) throws SQLException {
        String columns = "INSERT INTO USERS(FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB)";
        String values = "VALUES('" + firstname + "','" + lastname + "','" + middlename + "','" + emailaddress + "','" + phone + "','" + dob + "','" + password + "')";
        st.executeUpdate(columns + values);
        String query = "SELECT USERID FROM USERS WHERE EMAILADDRESS = '" + emailaddress + "'";
        ResultSet rs = st.executeQuery(query);
        String userID = rs.getString(1);
        boolean disabled = false;
        String columns2 = "INSERT INTO STAFF_USER(USERID, STAFF_ROLE, PASSWORD, )";
        String values2 = "VALUES('" + userID + "','" + staff_role + "', '" + password + "')";
        st.executeUpdate(columns2 + values2);
    }

    //Read Operation: staff login
    public Staff login(String emailaddress, String password) throws SQLException {
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
                String role = rs.getString(9);
                return new Staff(userID, firstname, lastname, middlename, useremail, phone, dob, userpass, disabled, role);
            }
        }
        return null;
    }

    //Update Operation: update staff
    public void update(int userID, String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password, String role) throws SQLException {
        updateSt.setString(1, emailaddress);
        updateSt.setString(2, password);
        updateSt.setString(3, firstname);
        updateSt.setString(4, lastname);
        updateSt.setString(5, middlename);
        updateSt.setString(6, phone);
        updateSt.setString(7, dob);
        updateSt.setString(8, Integer.toString(userID));
        updateSt.setString(10, role);
        int row = updateSt.executeUpdate();
        System.out.println("row "+row+" updated successfuly");
    }

    //Delete Operation: staff deletes their account after logging in 
    public void selfDelete(int ID) throws SQLException {
        deleteSt.setString(1, Integer.toString(ID));
        int row = deleteSt.executeUpdate();
        System.out.println("row "+row+" deleted successfuly");
    }

    //Fetch All: List all users
    public ArrayList<Staff> fetchUsers() throws SQLException {
        String fetch = "SELECT EMAILADDRESS, PASSWORD, FIRSTNAME, LASTNAME, MIDDLENAME, PHONE, DOB, DISABLED FROM USERS, STAFF_USER WHERE USERS.USERID=STAFF_USER.USERID";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> users = new ArrayList();

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
            String role = rs.getString(10);
            users.add(new Staff(userID, firstname, lastname, middlename, emailaddress, phone, dob, password, disabled, role));
        }
        return users;
    }
}
