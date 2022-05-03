package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author g16
 */
public class Item implements Serializable{
    //Fields or properties
    private int itemID;
    private String item_name;
    private String item_price;
    private String item_stock;
    private String item_status;
    private String cost_per_item;
    private String item_category;
    private String item_image_path;

    public Item(int itemID, String item_name, String item_price, String item_stock, String item_status, String cost_per_item, String item_category, String item_image_path) {
        this.itemID = itemID;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_stock = item_stock;
        this.item_status = item_status;
        this.cost_per_item = cost_per_item;
        this.item_category = item_category;
        this.item_image_path = item_image_path;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_stock() {
        return item_stock;
    }

    public void setItem_stock(String item_stock) {
        this.item_stock = item_stock;
    }

    public String getItem_status() {
        return item_status;
    }

    public void setItem_status(String item_status) {
        this.item_status = item_status;
    }

    public String getCost_per_item() {
        return cost_per_item;
    }

    public void setCost_per_item(String cost_per_item) {
        this.cost_per_item = cost_per_item;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_image_path() {
        return item_image_path;
    }

    public void setItem_image_path(String item_image_path) {
        this.item_image_path = item_image_path;
    }


    
}
