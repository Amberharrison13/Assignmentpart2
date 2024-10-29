package com.mycompany.assignmentpart2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class LoginClass {
    private boolean check = false;
    private final Map<String, User> users = new HashMap<>();

    // Nested class to represent a User
    private static class User {
        String password;
        String firstName;
        String lastName;

        User(String password, String firstName, String lastName) {
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public boolean CheckUsername(String username) {
        check = username.contains("_") && username.length() <= 5;
        System.out.println(check ? "Username is captured" : "Username is not captured");
        return check;
    }

    public boolean checkPassword(String password) {
        Pattern checkNum = Pattern.compile("[0-9]");
        Pattern checkSpecial = Pattern.compile("[*-`~!@#$%&_'^]");
        Pattern checkUpper = Pattern.compile("[A-Z]");
        boolean found = checkNum.matcher(password).find() && checkSpecial.matcher(password).find() && checkUpper.matcher(password).find();

        System.out.println(found ? "Password captured" : "Password not captured");
        return found;
    }

    public void registerUser(String username, String password, String firstName, String lastName) {
        if (check) {
            users.put(username, new User(password, firstName, lastName));
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username or password requirements not met. Registration failed.");
        }
    }

    public String loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return String.format("Welcome %s, %s. It is great to see you again.", user.firstName, user.lastName);
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
