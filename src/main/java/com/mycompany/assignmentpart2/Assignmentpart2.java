package com.mycompany.assignmentpart2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Assignmentpart2 {

    public static void main(String[] args) {
        String username;
        String password;
        String firstname, lastname;
        boolean isRegistered = false;
        boolean isLoggedIn = false;

        // Instances of required classes
        LoginClass log = new LoginClass();
        List<Task> tasksList = new ArrayList<>();

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

        // Allow task creation and Kanban functionality only if user is logged in
        if (isLoggedIn) {
            // Kanban Menu
            String kanbanMenu = "1. Add Tasks\n2. Show Report\n3. Search Task\n4. Delete Task\n5. Find Longest Task\n6. Exit";
            boolean running = true;
            while (running) {
                String kanbanChoiceStr = JOptionPane.showInputDialog(null, kanbanMenu, "Kanban System", JOptionPane.QUESTION_MESSAGE);
                int kanbanChoice = Integer.parseInt(kanbanChoiceStr);

                switch (kanbanChoice) {
                    case 1:
                        addTasks(tasksList);
                        break;
                    case 2:
                        Task.displayReport(tasksList);
                        break;
                    case 3:
                        searchTask(tasksList);
                        break;
                    case 4:
                        deleteTask(tasksList);
                        break;
                    case 5:
                        findLongestTask(tasksList);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Exiting Kanban System.");
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option, try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Method to add tasks
    private static void addTasks(List<Task> tasksList) {
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

            // Create a task instance and add it to the list
            Task task = new Task(taskName, i + 1, taskDescription, developerDetails, taskDuration, taskStatus);
            tasksList.add(task);
            JOptionPane.showMessageDialog(null, "Task added successfully!\n" + task.printTaskDetails());
        }
    }

    // Method to search for a task by name
    private static void searchTask(List<Task> tasksList) {
        String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
        Task task = Task.searchTaskByName(tasksList, taskName);
        if (task != null) {
            JOptionPane.showMessageDialog(null, task.printTaskDetails(), "Task Found", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to delete a task by name
    private static void deleteTask(List<Task> tasksList) {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        boolean isDeleted = Task.deleteTaskByName(tasksList, taskName);
        if (isDeleted) {
            JOptionPane.showMessageDialog(null, "Task deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to find and display the longest task
    private static void findLongestTask(List<Task> tasksList) {
        Task longestTask = Task.findLongestTask(tasksList);
        if (longestTask != null) {
            JOptionPane.showMessageDialog(null, "Longest Task: " + longestTask.getTaskName() +
                    " with duration of " + longestTask.getTaskDuration() + " hours.", "Longest Task", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
