package uts.isd.model;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author g16
 */
public class User implements Serializable{
    //Fields or properties
    private int userID;
    private String email;
    private String name;
    private String username;
    private String password;
    private String phone;

    public User() {
    }

    public User(String email, String name, String username, String password, String phone) {
        userID = (new Random()).nextInt(999999);
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean login(String username, String password) {
        if (username == this.username && password == this.password) {
            return true;
        }
        else return false;
    }

    public int getID() {
        return userID;
    }

    public void setID(int ID) {
        this.userID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
