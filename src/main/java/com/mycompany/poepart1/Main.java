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
    public static void main(String[] args) {
         
        //Create an object for scanner
        Scanner scanner = new Scanner(System.in);
        
  System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.println(login.registerUser());

        System.out.print("Enter username to login: ");
        String loginUsername = scanner.next();

        System.out.print("Enter password to login: ");
        String loginPassword = scanner.next();

        boolean loginStatus = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(loginStatus));
    }
        }
      

 

    
