package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author g16
 */
public class Customer implements Serializable{

    //Fields or properties
    private int userID;
    private String emailaddress;
    private String firstname;
    private String lastname;
    private String password;
    private String middlename;
    private String phone;
    private String dob;
    private boolean disabled;

    public Customer() {
    }

    public Customer(int userID, String firstname, String lastname, String middlename, String emailaddress, String phone, String dob, String password, boolean disabled) {
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.emailaddress = emailaddress;
        this.phone = phone;
        this.dob = dob;
        this.password = password;
        this.disabled = disabled;
    }

    public boolean login(String emailaddress, String password) {
        if (emailaddress == this.emailaddress && password == this.password) {
            return true;
        }
        else return false;
    }
    
        public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
    
    
}
