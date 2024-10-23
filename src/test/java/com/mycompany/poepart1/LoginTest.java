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
    public void testCheckUserNameCorrect() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testCheckUserNameIncorrect() {
        Login login = new Login();
        login.setUsername("kyle!!!!!!!");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityCorrect() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityIncorrect() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("password");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testRegisterUserSuccess() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertEquals("User registered successfully.", login.registerUser());
    }

    @Test
    public void testRegisterUserUsernameIncorrect() {
        Login login = new Login();
        login.setUsername("kyle!!!!!!!");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.registerUser());
    }

    @Test
    public void testRegisterUserPasswordIncorrect() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("password");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser());
    }

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertFalse(login.loginUser("kyle", "password"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertEquals("Welcome, Kyle Jenner, it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login();
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setFirstName("Kyle");
        login.setLastName("Jenner");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}
