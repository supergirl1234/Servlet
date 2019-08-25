package com.springboot2.po;

public class User {



    private  String username;
    private  String userAddress;
    private  boolean gender;

    public User() {
    }

    public User(String username, String userAddress, boolean gender) {
        this.username = username;
        this.userAddress = userAddress;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
