/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

/**
 *
 * @author vu.huynh
 */
public class Cart {
    private int cartID;
    private float total_items;
    private float shipping_price;
    private int custID;
    
    public Cart (int cartID, int total_items, int shipping_price, int custID) {
        this.cartID = cartID;
        this.total_items = total_items;
        this.shipping_price = shipping_price;
        this.custID = custID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public float getTotal_items() {
        return total_items;
    }

    public void setTotal_items(float total_items) {
        this.total_items = total_items;
    }

    public float getShipping_price() {
        return shipping_price;
    }

    public void setShipping_price(float shipping_price) {
        this.shipping_price = shipping_price;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
}
