/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author vu.huynh
 */
public class Order implements Serializable{
    private int orderID;
    private int custID;
    private int cartID;
    private String order_date;
    private String order_status;
    
        public Order(int orderID, int custID, int cartID, String order_date, String order_status) {
            this.orderID = orderID;
            this.custID = custID;
            this.order_date = order_date;
            this.order_status = order_status;
        }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    } 
    
}
