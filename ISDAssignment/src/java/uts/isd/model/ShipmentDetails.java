/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

/**
 *
 * @author steve
 */
public class ShipmentDetails {
    private int custID;
    private String streetnum;
    private String streetname;
    private String suburb;
    private String postcode;
    private String states;
    private String country;
    
     public ShipmentDetails(int custID, String streetnum, String streetname, String suburb, String postcode, String states, String country)
     {
         this.custID = custID;
         this.streetnum = streetnum;
         this.streetname = streetname;
         this.suburb = suburb;
         this.postcode = postcode;
         this.states = states;
         this.country = country;
     }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getStreetnum() {
        return streetnum;
    }

    public void setStreetnum(String streetnum) {
        this.streetnum = streetnum;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
