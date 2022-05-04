/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model.dao;

import java.sql.Connection;

/**
 *
 */
public abstract class SQLDB {
    protected String URL = "jdbc:derby://localhost:/1527/";
    protected String db = "iotdb";
    protected String dbuser = "iotadmin";
    protected String dbpass = "admin";
    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection connection;
    
}
