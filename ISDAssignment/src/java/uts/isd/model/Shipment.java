/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author steve
 */
public class Shipment implements Serializable {
    private int shipmentID;
    private int custID;
    private int orderID;
    private String ship_method;
    private String ship_date;
    private String ship_status;

    public Shipment(int shipmentID, int custID, int orderID, String ship_method, String ship_date, String ship_status) {
        this.shipmentID = shipmentID;
        this.custID = custID;
        this.orderID = orderID;
        this.ship_method = ship_method;
        this.ship_date = ship_date;
        this.ship_status = ship_status;
    }

    public Shipment(int orderID, String ship_method, String ship_date, String ship_status, int custID) {
        this.custID = custID;
        this.orderID = orderID;
        this.ship_method = ship_method;
        this.ship_date = ship_date;
        this.ship_status = ship_status;
    }

    public Shipment(int shipmentID, int orderID, String ship_method, String ship_date, String ship_status, int custID) {
        this.shipmentID = shipmentID;
        this.custID = custID;
        this.orderID = orderID;
        this.ship_method = ship_method;
        this.ship_date = ship_date;
        this.ship_status = ship_status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    

    public String getShip_method() {
        return ship_method;
    }

    public void setShip_method(String ship_method) {
        this.ship_method = ship_method;
    }

    public String getShip_date() {
        return ship_date;
    }

    public void setShip_date(String ship_date) {
        this.ship_date = ship_date;
    }

    public String getShip_status() {
        return ship_status;
    }

    public void setShip_status(String ship_status) {
        this.ship_status = ship_status;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }
    
    
}
