package com.example.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OurClass {

    private String email;
    private String number;

    private boolean isCorrectEmail = false;
    private boolean isCorrectNumber = false;

    public OurClass(){

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void ourMain(){

        email = email.trim();
        number = number.trim();

        if(email !=null && number !=null){
            if(checkEmail()){
                isCorrectEmail = true;
            }
            if(checkNumber() && (number.length() <= 13 || number.length() <= 12)){
                isCorrectNumber = true;
            }
        }
    }

    private boolean checkEmail(){

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    public void resetData(){
        isCorrectEmail = false;
        isCorrectNumber = false;
    }

    private boolean checkNumber(){

        Pattern pattern = Pattern.compile("^\\+?\\d+$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    public boolean isCorrectEmail() {
        return isCorrectEmail;
    }

    public boolean isCorrectNumber() {
        return isCorrectNumber;
    }


}
