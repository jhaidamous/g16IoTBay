/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author Anas Awais
 */
public class Payment implements Serializable{
    //Fields or properties
    private int paymentID;
    private String payment_error;
    private String payment_status;
    private String temp_CVC;
    private String temp_card_number;
    private String temp_expiry_date;
    private int orderID;

    public Payment(int paymentID, String payment_error, String payment_status, String temp_CVC, String temp_card_number, String temp_expiry_date, int orderID) {
        
        this.paymentID = paymentID;
        this.payment_error = payment_error;
        this.payment_status = payment_status;
        this.temp_CVC = temp_CVC;
        this.temp_card_number = temp_card_number;
        this.temp_expiry_date = temp_expiry_date;
        this.orderID = orderID;
    }

    public int getpaymentID() {
        return paymentID;
    }

    public void setpaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getpayment_error() {
        return payment_error;
    }

    public void setIpayment_error(String payment_error) {
        this.payment_error = payment_error;
    }

    public String getpayment_status() {
        return payment_status;
    }

    public void setpayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getItem_stock() {
        return temp_CVC;
    }

    public void settemp_CVC(String temp_CVC) {
        this.temp_CVC = temp_CVC;
    }

    public String getItem_status() {
        return temp_card_number;
    }

    public void settemp_card_number(String temp_card_number) {
        this.temp_card_number = temp_card_number;
    }

    public String gettemp_expiry_date() {
        return temp_expiry_date;
    }

    public void settemp_expiry_date(String temp_expiry_date) {
        this.temp_expiry_date = temp_expiry_date;
    }

    public String getorderID() {
        return orderID;
    }

    public void setorderID(String orderID) {
        this.orderID = orderID;
    }

}
