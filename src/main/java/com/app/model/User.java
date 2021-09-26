package com.app.model;


// Object
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;


    // Constructor
    public User(String firstName, String lastName, String email, String phone){
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }

    // Getters-Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Custom method
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Add "note" to the "allNotes" Array

    public void printFullName(){
        System.out.println("----------------------------------");
        System.out.println("Created by: " + getFullName());
    }
}
