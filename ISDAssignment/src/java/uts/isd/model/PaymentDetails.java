package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author Anas Awais
 */
public class PaymentDetails implements Serializable{
    //Fields or properties to modify
    private int custID;
    private int pay_det_num;
    private int cvc;
    private String cardnum;
    private String expirydate;
    
// to modify
public PaymentDetails(int custID, int pay_det_num, int cvc, String cardnum, String expirydate) {
    
        this.custID = custID;
        this.pay_det_num = pay_det_num;
        this.cvc = cvc;
        this.cardnum = cardnum;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getPay_det_num() {
        return pay_det_num;
    }

    public void setPay_det_num(int pay_det_num) {
        this.pay_det_num = pay_det_num;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

}
