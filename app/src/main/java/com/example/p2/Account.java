package com.example.p2;

import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.p2.MainActivity.accounts;
import static com.example.p2.MainActivity.indexOfAcc;

public class Account {

    private String username;
    private String email;
    private String phone;
    private String createPass;
    private String confirmPass;
    //Be aware of default settings of following attributes. Might cause bugs:
    private String gender;
    private int age;
    private String firstName;
    private String lastName;
    private String university;
    private String major;
    private String semester;
    private double rating;
    private int amountOfRates;
    private int mentorships;
    private int totalAnswers;


    public Account(String username, String email, String phone, String createPass, String confirmPass) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createPass = createPass;
        this.confirmPass = confirmPass;
    }

    public Account(String username, String email, String phone, String createPass, String confirmPass, String gender, int age, String firstName,
                   String lastName, String university, String major, String semester) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createPass = createPass;
        this.confirmPass = confirmPass;
        this.gender = gender;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.university = university;
        this.major = major;
        this.semester = semester;
    }

    public int getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(int totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public int getMentorships() {
        return mentorships;
    }

    public void setMentorships(int mentorships) {
        this.mentorships = mentorships;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) { // probably useless
        this.rating = rating;
    }

    public void updateRating() { // use for rating
        amountOfRates++;
        rating += rating/amountOfRates;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniveristy() {
        return university;
    }

    public void setUniveristy(String univeristy) {
        this.university = univeristy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername(){
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreatePass() {
        return createPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }
}
