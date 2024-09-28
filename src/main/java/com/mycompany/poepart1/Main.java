/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
        public class Main {
    public static void main(String[] args){
         //Create an object for login
       
        //Create an object for scanner
        Scanner scanner = new Scanner(System.in);

        //Prompt the user to enter their details
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        
         Login login = new Login(username, password, firstName, lastName);
        System.out.print(login.registerUser());

          System.out.print("Login with username:");
        String inputUsername = scanner.next();
        System.out.print("Login with password:");
        String inputPassword = scanner.next();

        boolean loginSuccess = login.loginUser(inputUsername, inputPassword);
        System.out.println(login.returnLoginStatus(loginSuccess));


       
    }
        }

