package com.example.shoppingmanagmentapp.DataFile;

public class Users {

    private String userEmailAddress;
    private String userPassword;
    private String userPhoneNumber;

    public Users(String userEmailAddress, String userPassword, String userPhoneNumber) {
        this.userEmailAddress = userEmailAddress;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
