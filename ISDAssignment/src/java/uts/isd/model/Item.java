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
    private double item_price;
    private int item_stock;
    private String item_status;
    private double cost_per_item;
    private String item_category;
    private String item_image_path;

    public Item(int itemID, String item_name, double item_price, int item_stock, String item_status, double cost_per_item, String item_category, String item_image_path) {
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

    public String getItem_name() {
        return item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public int getItem_stock() {
        return item_stock;
    }

    public String getItem_status() {
        return item_status;
    }

    public double getCost_per_item() {
        return cost_per_item;
    }

    public String getItem_category() {
        return item_category;
    }

    public String getItem_image_path() {
        return item_image_path;
    }




    
}
