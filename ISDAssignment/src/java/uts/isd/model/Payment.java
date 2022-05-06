package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author Anas Awais
 */
public class Payment implements Serializable{
    //Fields or properties to modify
    private int paymentID;
    private String payment_error;
    private String payment_status;
    private int orderID;
// to modify
    public Payment(int paymentID, String payment_error, String payment_status, int orderID) {
    
        this.paymentID = paymentID;
        this.payment_error = payment_error;
        this.payment_status = payment_status;
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPayment_error() {
        return payment_error;
    }

    public void setPayment_error(String payment_error) {
        this.payment_error = payment_error;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

}
