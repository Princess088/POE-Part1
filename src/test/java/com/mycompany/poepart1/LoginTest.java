/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author RC_Student_lab
 */

public class LoginTest {

    @Test
    // Test that the checkUserName method returns true when the username is correct
    public void testCheckUserNameCorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertTrue(login.checkUserName());
    }

    @Test
    // Test that the checkUserName method returns false when the username is incorrect
    public void testCheckUserNameIncorrect() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertFalse(login.checkUserName());
    }

    @Test
    // Test that the checkPasswordComplexity method returns true when the password is correct
    public void testCheckPasswordComplexityCorrect() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    // Test that the checkPasswordComplexity method returns false when the password is incorrect
    public void testCheckPasswordComplexityIncorrect() {
        Login login = new Login("kyl_1", "password", "Kyle", "Jenner");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
     // Test that the registerUser method returns true when the username and password are correct
    public void testRegisterUserSuccess() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertEquals("User registered successfully.", login.registerUser());
    }

    @Test
    // Test that the registerUser method returns the expected message when the username is incorrect
    public void testRegisterUserUsernameIncorrect() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.registerUser());
    }

    @Test
    // Test that the registerUser method returns the expected message when the password is incorrect
    public void testRegisterUserPasswordIncorrect() {
        Login login = new Login("kyl_1", "password", "Kyle", "Jenner");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser());
    }

    @Test
    // Test that the loginUser method returns true when the username and password are correct
    public void testLoginUserSuccess() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
     // Test that the loginUser method returns false when the username or password is incorrect
    public void testLoginUserFailure() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertFalse(login.loginUser("kyle", "password"));
    }

    @Test
    // Test that the returnLoginStatus method returns the correct message when the login is successful
    public void testReturnLoginStatusSuccess() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertEquals("Welcome, Kyle Jenner, it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    // Test that the returnLoginStatus method returns the correct message when the login has failed
    public void testReturnLoginStatusFailure() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Jenner");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}
  