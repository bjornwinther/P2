package com.example.p2;

public class Account {

    private String username;
    private String email;
    private String phone;
    private String createPass;
    private String confirmPass;


    public Account(String username, String email, String phone, String createPass, String confirmPass) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createPass = createPass;
        this.confirmPass = confirmPass;
    }

}
