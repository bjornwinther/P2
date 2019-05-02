package com.example.p2;

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
    private String status;
    private String semester;


    public Account(String username, String email, String phone, String createPass, String confirmPass) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.createPass = createPass;
        this.confirmPass = confirmPass;
    }

    public Account(String username, String email, String phone, String createPass, String confirmPass, String gender, int age, String firstName,
                   String lastName, String university, String major, String status, String semester) {
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
        this.status = status;
        this.semester = semester;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
