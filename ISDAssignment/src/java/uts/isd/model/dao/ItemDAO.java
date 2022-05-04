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
import uts.isd.model.Item;
import uts.isd.model.User;

/**
 *
 * @author JHUTS
 */
public class ItemDAO {
    private Statement st;
    
    public ItemDAO(Connection connection) throws SQLException {
        st = connection.createStatement();
    }
    
    //Create Operation: create a user
    public void createItem(String item_name, String item_price, String item_stock, String item_status, String cost_per_item, String item_category, String item_image_path) throws SQLException {
        String columns = "INSERT INTO iotadmin.catalog_item(item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path)";
        String values = "VALUES('"+item_name+"','"+item_price+"','"+item_stock+"','"+item_status+"','"+cost_per_item+"','"+item_category+"','"+item_image_path+"')";
        st.executeUpdate(columns+values);      
    }
    
    //Read Operation: user login
//    public User login(String email, String password) throws SQLException {
//        String fetch = "SELECT * FROM ISDUSER.USERS WHERE EMAIL='"+email+"' AND PASSWORD = '"+password+"'";
//        ResultSet rs = st.executeQuery(fetch);
//        while(rs.next()) {
//            String useremail = rs.getString(2);
//            String userpass = rs.getString(4);
//            if(email.equals(useremail) && password.equals(userpass)) {
//                String name = rs.getString(3);
//                String phone = rs.getString(5);
//                int ID = Integer.parseInt(rs.getString(1));
//                return new User(ID, email,name,password,phone);
//            }
//        }
//        return null;
//    }
    
    //Fetch All: list all users
    public ArrayList<Item> fetchItems() throws SQLException {
        String fetch = "SELECT * FROM iotadmin.catalog_item";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Item> items = new ArrayList<Item>();
        
        while (rs.next()) {            
            int itemID = Integer.parseInt(rs.getString(1));
            String item_name =  rs.getString(2);
            String item_price = rs.getString(3);
            String item_stock = rs.getString(4);
            String item_status = rs.getString(5);
            String cost_per_item = rs.getString(6);
            String item_category = rs.getString(7);
            String item_image_path = rs.getString(8);
            items.add(new Item(itemID,item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path));
        }
        return items;
            
        }
        
}