/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assignmentpart2;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Assignmentpart2 {

    public static void main(String[] args) {
        String username;
        String password;
        String firstname, lastname;

        Scanner scanner = new Scanner(System.in);

        //instance of a class
        Assignmentpart2 bvvv = new Assignmentpart2();
        LoginClass log = new LoginClass();

        // Input fields
         System.out.print("Enter first name: ");
        firstname = scanner.nextLine();

        System.out.print("Enter last name: ");
        lastname = scanner.nextLine();

        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
        } while (!log.CheckUsername(username));

        System.out.print("Enter password: ");
        password = scanner.nextLine();
        while(!log.checkPassword(password)){
        System.out.print("Enter password: ");
        password = scanner.nextLine();  
        }

        log.registerUser("user_", "Passw0rd!", "John", "Doe");
        // Validate inputs
        String result = bvvv.vaildateAccounts(username, password, firstname, lastname);
        System.out.println(result);

        scanner.close();
    }
    

    public String vaildateAccounts(String username, String password, String firstName, String lastName) {

        // Check password
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
        }
        if (!password.matches(".*[a-z].*")) {
            return "Password must contain at least one lowercase letter.";
        }

        if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one number.";
        }

        // Check first name
        if (firstName.length() < 1 || firstName.length() > 30 || !firstName.matches("[a-zA-Z]+")) {
            return "First name must be between 1 and 30 characters long and contain only letters.";
        }

        // Check last name
        if (lastName.length() < 1 || lastName.length() > 30 || !lastName.matches("[a-zA-Z]+")) {
            return "Last name must be between 1 and 30 characters long and contain only letters.";
        }

   return "";
}
    
}