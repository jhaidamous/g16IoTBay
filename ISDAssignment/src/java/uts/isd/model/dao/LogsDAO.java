/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import uts.isd.model.Logs;

/**
 *
 * @author steve
 */
public class LogsDAO {
     private Statement st;
    
    public LogsDAO(Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }
    
    //Create Operation: create an item
   public void createLogs(int userID, String message) throws SQLException {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Time time = new java.sql.Time(Calendar.getInstance().getTime().getTime());
        String dateStr = date.toString();
        String timeStr = time.toString();
        String columns = "INSERT INTO iotadmin.user_logs(userID,logDate,logTime,message)";
        String values = "VALUES("+userID+",'"+dateStr+"','"+timeStr+"','"+message+"')";
        st.executeUpdate(columns+values);      
    }
    

    //Fetch one by logs ID
//        public Logs fethchoneLogs(int userID, String logDate, String logTime) throws SQLException {
//        String fetch = " SELECT * FROM logs WHERE userID = '"+userID+"')"; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
//        ResultSet rs = st.executeQuery(fetch);
//        
//        int orderID =  Integer.parseInt(rs.getString(2));
//        String ship_method = rs.getString(3);        
//        String ship_date = rs.getString(4);
//        String ship_status = rs.getString(5);
//        int custID = Integer.parseInt(rs.getString(6));
//        Logs ds = new Logs(orderID,ship_method,ship_date,ship_status,custID);
//        return ds;
//   
//   } 
    //Fetch All: fetch all recrods of payment, by userID
    public ArrayList<Logs> fetchLogs(int userID) throws SQLException {
        String fetch = "SELECT * FROM iotadmin.user_logs WHERE userID = "+userID+""; //fetch all the orderIDs which have the UserID, fetch all the Payments against the Orders.
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Logs> logs = new ArrayList<>();     
        
        while (rs.next()) {            
        String logDate = rs.getString(2);        
        String logTime = rs.getString(3);
        String message = rs.getString(4);
        logs.add(new Logs(userID,logDate,logTime,message));
        }
        return logs;
            
    }
}
