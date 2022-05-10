package uts.isd.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {

    private String emailPattern = "[A-Za-z0-9.@]+";//"([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
    private String namePattern = "[A-Za-z]+";//"([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
    private String passwordPattern = "[a-z0-9]{5,}";
    private String phonePattern = "[A-Za-z0-9.@]+";
    private String cvcPattern =  "[0-9]{3,4}$";
//    private String expirydatePattern = "((0[1-9])|(1[0-2]))[\\/\\.\\-]*((0[8-9])|(1[1-9]))$";
    private String monthPattern = "(0[1-9]|1[012])";
    private String yearPattern = "^[12][0-9]{3}$";
    private String cardnumPattern = "(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$";
//    private String dobPattern = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]((19|20)\\d\\d)$";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    public boolean checkEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }
    
    public boolean validatePhone(String phone){
        return validate(phonePattern, phone);
    }
    
    public boolean validateCVC(int cvc){
        return validate(cvcPattern, Integer.toString(cvc)); 
   }
    
    public boolean validatecardnum(String cardnum){
        return validate(cardnumPattern, cardnum);
    }
    
//    public boolean validateexpirydate(String expirydate){
//        return validate(expirydatePattern, expirydate);
//    }
    
    public boolean validatemonth(String month){
        return validate(monthPattern, month);
    }
     
    public boolean validateyear(String year){
        return validate(yearPattern, year);
    }
    
//    public boolean validateDob (String dob){
//        return validate(dobPattern, dob);
//    }
    
    public static void clearRegister(HttpSession session) {
        session.setAttribute("emailErr", "Enter email");
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("firstNameErr", "Enter first name");
        session.setAttribute("middleNameErr", "Optional");
        session.setAttribute("lastNameErr", "Enter last name");
        session.setAttribute("phoneErr", "Enter phone");
        session.setAttribute("dobErr", "Enter DOB");
        session.setAttribute("registration", "");
        session.setAttribute("cvcErr", "Enter CVC");
        session.setAttribute("expirydateErr", "Enter Expiry Date");
        session.setAttribute("cardnumErr", "Enter Card Number");
    }
}
