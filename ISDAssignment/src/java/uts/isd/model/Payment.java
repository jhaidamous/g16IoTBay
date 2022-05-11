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
    private String payment_date;
    private int pay_det_num;
    private int custID;
    private int orderID;
    private double total;

    public Payment(int paymentID, String payment_error, String payment_status, String payment_date, int pay_det_num, int custID, int orderID, double total) {
        this.paymentID = paymentID;
        this.payment_error = payment_error;
        this.payment_status = payment_status;
        this.payment_date = payment_date;
        this.pay_det_num = pay_det_num;
        this.custID = custID;
        this.orderID = orderID;
        this.total = total;
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

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getPay_det_num() {
        return pay_det_num;
    }

    public void setPay_det_num(int pay_det_num) {
        this.pay_det_num = pay_det_num;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}