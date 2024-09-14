/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class Validation {
  
    public static boolean checkUsername(String username) {
        // Check if username is null
        if (username == null) {
            System.out.println("Username is null");
            System.out.println("Contains underscore: false");
            System.out.println("Length() <= 5: false");
            System.out.println("Is valid: false");
        } else {
            // Proceed with checks if username is not null
            boolean containsUnderscore = username.contains("_");
            boolean isLengthValid = username.length() <= 5;
            boolean isValid = containsUnderscore && isLengthValid;

            System.out.println("Username: " + username);
            System.out.println("Contains underscore: " + containsUnderscore);
            System.out.println("Length() <= 5: " + isLengthValid);
            System.out.println("Is valid: " + isValid);
        }
        return true;
    }

    // Method check for  password complexity
    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8
                 // Password contains at least one uppercase letter
                && password.matches(".*[A-Z].*") 
                 // Password contains at least one digit
                && password.matches(".*[0-9].*") 
                 // Password ontains at least one special character
                && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*"); 
    }
}



