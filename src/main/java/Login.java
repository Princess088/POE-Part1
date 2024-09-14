/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Login {

    private Object username;
    private Object password;
     public String registerUser() {
        if (checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if ( checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            return "User successfully registered.";
        }
    }

   // Method to check if the provided username and password match the stored values
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

   
  
   
