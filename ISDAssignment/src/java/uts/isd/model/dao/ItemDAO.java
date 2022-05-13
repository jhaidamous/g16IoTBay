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
import uts.isd.model.Categories;
import uts.isd.model.Item;
import uts.isd.model.User;

/**
 *
 * @author JHUTS
 */
public class ItemDAO {
    private Statement st;
    
public ItemDAO(Connection connection) throws SQLException {
    connection.setAutoCommit(true);
    st = connection.createStatement();
}

    //Create Operation: create an item
    public void createItem(String item_name, double item_price, int item_stock, String item_status, double cost_per_item, String item_category) throws SQLException {
        String columns = "INSERT INTO iotadmin.catalog_item(item_name,item_price,item_stock,item_status,cost_per_item,item_category)";
        String values = "VALUES('"+item_name+"',"+item_price+","+item_stock+",'"+item_status+"',"+cost_per_item+",'"+item_category+"')";
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
    
    //Fetch All: list all items
    public ArrayList<Item> fetchItems() throws SQLException {
        String fetch = "SELECT * FROM iotadmin.catalog_item";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Item> items = new ArrayList<Item>();
        
        while (rs.next()) {            
            int itemID = Integer.parseInt(rs.getString(1));
            String item_name =  rs.getString(2);
            double item_price = Double.parseDouble(rs.getString(3));
            int item_stock = Integer.parseInt(rs.getString(4));
            String item_status = rs.getString(5);
            double cost_per_item = Double.parseDouble(rs.getString(6));
            String item_category = rs.getString(7);
            String item_image_path = rs.getString(8);
            items.add(new Item(itemID,item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path));
        }
        return items;
            
    }
    public Item fetchItem(int itemID) throws SQLException {
        String fetch = "SELECT * FROM iotadmin.catalog_item WHERE itemID="+itemID+"";
        ResultSet rs = st.executeQuery(fetch);
        rs.next();
        String item_name =  rs.getString(2);
        double item_price = Double.parseDouble(rs.getString(3));
        int item_stock = Integer.parseInt(rs.getString(4));
        String item_status = rs.getString(5);
        double cost_per_item = Double.parseDouble(rs.getString(6));
        String item_category = rs.getString(7);
        String item_image_path = rs.getString(8);
        Item editItem = new Item(itemID,item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path);
        return editItem;
            
    }
    public void deleteItem(int itemID) throws SQLException {
        String sql = "DELETE FROM iotadmin.catalog_item WHERE itemID="+itemID+"";
        st.executeUpdate(sql);
    }
        
    public void updateItem(int itemID, String itemname, Double itemprice, int itemstock, String itemstatus, Double costperitem, String itemcategory) throws SQLException {
        String fetch = "UPDATE iotadmin.CATALOG_ITEM SET item_name='"+itemname+"', item_price="+itemprice+", item_stock="+itemstock+", item_status='"+itemstatus+"', cost_per_item="+costperitem+", item_category='"+itemcategory+"' WHERE itemID="+itemID+"";
        st.executeUpdate(fetch);
    }
    
    public ArrayList<Item> searchItems(String searchq) throws SQLException {
        System.out.print(searchq.toLowerCase());
        String fetch = "SELECT * FROM iotadmin.catalog_item WHERE LOWER(item_name) LIKE '%"+searchq.toLowerCase()+"%'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Item> items = new ArrayList<Item>();
        
        while (rs.next()) {            
            int itemID = Integer.parseInt(rs.getString(1));
            String item_name =  rs.getString(2);
            double item_price = Double.parseDouble(rs.getString(3));
            int item_stock = Integer.parseInt(rs.getString(4));
            String item_status = rs.getString(5);
            double cost_per_item = Double.parseDouble(rs.getString(6));
            String item_category = rs.getString(7);
            String item_image_path = rs.getString(8);
            items.add(new Item(itemID,item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path));
        }
        return items;
            
    }
        
    public ArrayList<Item> searchCategories(String searchq) throws SQLException {
        System.out.print(searchq);
        String fetch = "SELECT * FROM iotadmin.catalog_item WHERE item_category='"+searchq+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Item> items = new ArrayList<Item>();
        
        while (rs.next()) {            
            int itemID = Integer.parseInt(rs.getString(1));
            String item_name =  rs.getString(2);
            double item_price = Double.parseDouble(rs.getString(3));
            int item_stock = Integer.parseInt(rs.getString(4));
            String item_status = rs.getString(5);
            double cost_per_item = Double.parseDouble(rs.getString(6));
            String item_category = rs.getString(7);
            String item_image_path = rs.getString(8);
            items.add(new Item(itemID,item_name,item_price,item_stock,item_status,cost_per_item,item_category,item_image_path));
        }
        return items;
            
    }
    public ArrayList<Categories> fetchCategories() throws SQLException {
        String fetch = "SELECT distinct(item_category) FROM iotadmin.catalog_item";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Categories> categories = new ArrayList<Categories>();
        
        while (rs.next()) {            
            String item_category = rs.getString(1);
            categories.add(new Categories(item_category));
        }
        return categories;
            
    }
        
}