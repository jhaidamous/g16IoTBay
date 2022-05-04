/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author JHUTS
 */
public class SQLDBConnecter extends SQLDB {
    public SQLDBConnecter() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        super.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/iotdb;create=true", "iotadmin", "admin");
    }
    
    public Connection connection() {
        return this.connection;
    }
    
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
