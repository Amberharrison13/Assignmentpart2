package com.mycompany.poepart3;
import javax.swing.JOptionPane;

public class Poepart3 {
    TaskManager taskManager = new TaskManager(10);
    
    public static void main(String[] args) {
        LoginClass log = new LoginClass();
        Poepart3 app = new Poepart3();

        while (true) {
            String menu = "1. Register\n2. Login\n3. Check Login Status";
            String choiceStr = JOptionPane.showInputDialog(null, menu, "Main Menu", JOptionPane.QUESTION_MESSAGE);

            if (!isNumeric(choiceStr)) {
                JOptionPane.showMessageDialog(null, "Exiting the application, Goodbye ");
                System.exit(0);
            }

            int choice = Integer.parseInt(choiceStr);
            if (choice < 1 || choice > 3) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number between 1 and 3.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (choice) {
                case 1:
                    // Register a new user
                    String userName = JOptionPane.showInputDialog("Enter your name:");
                    String userLastName = JOptionPane.showInputDialog("Enter your surname:");
                    String userUsername = JOptionPane.showInputDialog("Enter username (max 5 characters and must contain an underscore):");
                    String userPassword = JOptionPane.showInputDialog("Enter password (min 8 characters, with a capital letter, a number, and a special character):");

                    log.registerUser(userName, userLastName, userUsername, userPassword);
                    break;

                case 2:
                    // Log in with existing user credentials
                    String loginUsername = JOptionPane.showInputDialog("Enter your username:");
                    String loginPassword = JOptionPane.showInputDialog("Enter your password:");

                    log.loginUser(loginUsername, loginPassword);
                    break;

                case 3:
                    // Display the current login status
                    JOptionPane.showMessageDialog(null, "Login Status: " + (log.returnLoginStatus() ? "Logged in" : "Not logged in"));
                    if (log.returnLoginStatus()) {
                        app.displayKanbanMenu();
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayKanbanMenu() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            String kanbanMenu = "1. Add Tasks\n2.Find Longest Task\n3.Search Task\n4.Search By Developer Name\n5.Delete Task\n6.Display Report";
            String kanbanChoiceStr = JOptionPane.showInputDialog(null, kanbanMenu, "EasyKanban Menu", JOptionPane.QUESTION_MESSAGE);

            if (kanbanChoiceStr == null) {
                JOptionPane.showMessageDialog(null, "Returning to Main Menu");
                return;
            }

            if (isNumeric(kanbanChoiceStr)) {
                int Option = Integer.parseInt(kanbanChoiceStr);

                switch (Option) {
                    case 1:
                        manageTasks();
                        break;
                    case 2:
                        // Display Task with Longest Duration
                        JOptionPane.showMessageDialog(null, taskManager.displayTaskWithLongestDuration());
                        break;
                    case 3:
                        // Search Task by Name
                        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                        JOptionPane.showMessageDialog(null, taskManager.searchTaskByName(taskName));
                        break;
                    case 4:
                        // Search Tasks by Developer
                        String developer = JOptionPane.showInputDialog("Enter Developer Name:");
                        JOptionPane.showMessageDialog(null, taskManager.searchTasksByDeveloper(developer));
                        break;
                    case 5:
                        // Delete Task
                        String taskToDelete = JOptionPane.showInputDialog("Enter Task Name to Delete:");
                        JOptionPane.showMessageDialog(null, taskManager.deleteTaskByName(taskToDelete));
                        break;
                    case 6:
                        // Display Task Report
                        JOptionPane.showMessageDialog(null, taskManager.displayReport());
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid input, try again.");
                }
            }
        }
    }

    private void manageTasks() {
        // Ask how many tasks the user wants to add
        String numberOfTasksStr = JOptionPane.showInputDialog("How many tasks would you like to add?");
        
        // Ensure the input is numeric and greater than 0
        if (numberOfTasksStr == null || !isNumeric(numberOfTasksStr) || Integer.parseInt(numberOfTasksStr) <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a positive number.");
            return;
        }
        
        int numberOfTasks = Integer.parseInt(numberOfTasksStr);
        
        // Loop to add tasks
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            String developer = JOptionPane.showInputDialog("Enter Developer Name:");
            double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
            String[] statuses = {"To Do", "Doing", "Done"};
                String status = (String) JOptionPane.showInputDialog(null, "Choose a task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
                if (status == null) break;

            // Add the task to the taskManager
            taskManager.addTask(taskName, i + 1, taskDescription, developer, taskDuration, status);
        }
        
        JOptionPane.showMessageDialog(null, numberOfTasks + " tasks added successfully.");
    }
    

    private static boolean isNumeric(String input) {
        return input != null && input.matches("\\d+");
    }
    
}