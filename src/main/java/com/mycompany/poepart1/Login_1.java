/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
class Login {
    //Declarations
   private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    //Initilise a new object with the new variable
    public Login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
   

    //Method to check whether the username has all that it should contain
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }
    
    //Method to check for password complexity
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[0-9]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
    
    //Checks whether the user has registered successfully or not
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        return "User registered successfully.";
    }
    
   
    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
    
    //Determines whether the login was successful or not
    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome, " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";

        }
    }

}


