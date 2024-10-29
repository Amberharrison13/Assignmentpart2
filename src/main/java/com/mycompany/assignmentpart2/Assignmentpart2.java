package com.mycompany.assignmentpart2;

import javax.swing.JOptionPane;

public class Assignmentpart2 {

    public static void main(String[] args) {
        String username;
        String password;
        String firstname, lastname;
        boolean isRegistered = false;
        boolean isLoggedIn = false;

        // Instances of required classes
        LoginClass log = new LoginClass();

        // Register User
        firstname = JOptionPane.showInputDialog("Enter first name:");
        lastname = JOptionPane.showInputDialog("Enter last name:");

        // Username validation
        do {
            username = JOptionPane.showInputDialog("Enter username (must contain '_' and be 5 characters or less):");
        } while (!log.CheckUsername(username));

        // Password validation
        password = JOptionPane.showInputDialog("Enter password (must include uppercase, number, and special character):");
        while (!log.checkPassword(password)) {
            password = JOptionPane.showInputDialog("Enter password:");
        }

        // Register the user
        log.registerUser(username, password, firstname, lastname);
        isRegistered = true;

        // Login User
        if (isRegistered) {
            String loginUsername = JOptionPane.showInputDialog("Log in with your username:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password:");

            String loginResult = log.loginUser(loginUsername, loginPassword);
            JOptionPane.showMessageDialog(null, loginResult);

            if (loginResult.contains("Welcome")) {
                isLoggedIn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Exiting.");
                return;
            }
        }

        // Allow task creation only if user is logged in
        if (isLoggedIn) {
            String numTasksStr = JOptionPane.showInputDialog("How many tasks do you wish to enter?");
            int numTasks = Integer.parseInt(numTasksStr);

            for (int i = 0; i < numTasks; i++) {
                String taskName = JOptionPane.showInputDialog("Enter task name:");

                String taskDescription;
                do {
                    taskDescription = JOptionPane.showInputDialog("Enter task description (up to 50 characters):");
                } while (taskDescription.length() > 50);

                String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
                String taskDurationStr = JOptionPane.showInputDialog("Enter task duration in hours:");
                double taskDuration = Double.parseDouble(taskDurationStr);
                String taskStatus = JOptionPane.showInputDialog("Enter task status:");

                // Create a task instance
                Task task = new Task(taskName, i + 1, taskDescription, developerDetails, taskDuration, taskStatus);
                JOptionPane.showMessageDialog(null, "Task added successfully!\n" + task.printTaskDetails());
            }
        }
    }
}
