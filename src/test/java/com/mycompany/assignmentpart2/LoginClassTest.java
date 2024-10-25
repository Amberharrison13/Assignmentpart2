/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.assignmentpart2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginClassTest {
    
    private LoginClass loginclass;
    
    public LoginClassTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        loginclass =new LoginClass();
    }
    
    @AfterEach
    public void tearDown() {
        loginclass=null;
    }

    /**
     * Test of CheckUsername method, of class LoginClass.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("CheckUsername");
        String username = "user_";
        LoginClass instance = new LoginClass();
        boolean expResult = false;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of checkPassword method, of class LoginClass.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "password";
        LoginClass instance = new LoginClass();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registerUser method, of class LoginClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        LoginClass loginclass = new LoginClass();
        String expResult = "Password is not correctly formatted,please ensure the passwod contains at least 8 characters,A capital letter, a number and special character";
        String result = loginclass.registerUser("user_", "Passw0rd!", "John", "Doe");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of loginUser method, of class LoginClass.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "username123";
        String password = "Passw0rd!";
        LoginClass instance = new LoginClass();
        String expResult = "loginUser was not correctly formatted";
        String result = instance.loginUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of returnloginstatus method, of class LoginClass.
     */
    @Test
    public void testReturnloginstatus() {
        System.out.println("returnloginstatus");
        LoginClass loginclass = new LoginClass();
        boolean expResult = false;
        boolean result = loginclass.returnloginstatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}