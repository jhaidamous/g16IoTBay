/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private String readQuery =  "SELECT USERID, FIRSTNAME, LASTNAME, MIDDLENAME, EMAILADDRESS, PHONE, DOB, STAFF_ROLE, PASSWORD FROM USERS, STAFF_USER WHERE USERS.USERID=STAFF_USER.STAFFID AND EMAILADDRESS=? AND PASSWORD=?";
 
    
    public StaffDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
        readSt =  connection.prepareStatement(readQuery);
    }

    //Read Operation: staff login
    public Staff login(String emailaddress, String password) throws SQLException {
        readSt.setString(1, emailaddress);
        readSt.setString(2, password);
        ResultSet rs = readSt.executeQuery();
        
        while (rs.next()) {
                String useremail = rs.getString(5);
                String userpass = rs.getString(9);
                int userID = Integer.parseInt(rs.getString(1));
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String middlename = rs.getString(4);
                String phone = rs.getString(6);
                String dob = rs.getString(7);
                //boolean disabled = Boolean.parseBoolean(rs.getString(8));
                String role = rs.getString(8);
                return new Staff(userID, firstname, lastname, middlename, useremail, phone, dob, role, userpass);
        }
        return null;
    }

}
