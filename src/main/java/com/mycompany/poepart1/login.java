/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author RC_Student_lab
 */
class login {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public login(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

     public boolean checkUserName() {
         return username.contains("_") && username.length() <= 5;

    }
    
     public boolean checkPasswordComplexity() {
        String regex = "^(?=.[A-Z])(?=.[a-z])(?=.\\d()?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
     }
        public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            return "User successfully registered.";
        }
        }
}


    


