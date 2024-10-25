/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignmentpart2;
import javax.swing.JOptionPane;


/**
 *
 * @author RC_Student_lab
 */
public class Assignmentpart2 {

    public static void main(String[] args) {
       System.out.println("Welcome to EasyKanban");

        String username = JOptionPane.showInputDialog("Enter username");
        String password = JOptionPane.showInputDialog("Enter password");

        if (username.equals("admin") && password.equals("password")) {
            int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks"));

            Task[] tasks = new Task[numTasks];
            double totalHours = 0;

            for (int i = 0; i < numTasks; i++) {
                String taskName = JOptionPane.showInputDialog("Enter task name");
                String taskDescription = 
           JOptionPane.showInputDialog("Enter task description");
                while (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                    taskDescription = JOptionPane.showInputDialog("Enter task description");
                }
                String developerDetails = JOptionPane.showInputDialog("Enter developer details");
                double taskDuration = Double.parseDouble(JOptionPane.showInputDialog("Enter task duration (hours)"));

                String[] taskStatusOptions = {"To Do", "Done", "Doing"};
                String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status", "Task Status", JOptionPane.QUESTION_MESSAGE, null, taskStatusOptions, taskStatusOptions[0]);
             Task task = new Task(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                tasks[i] = task;
                totalHours += task.returnTotalHours();

                JOptionPane.showMessageDialog(null, task.printTaskDetails());
            }

            JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);

            while (true) {
                String[] menuOptions = {"1. Add tasks", "2. Show report", "3. Quit"};
                String menuSelection = (String) JOptionPane.showInputDialog(null, "Select an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, menuOptions, menuOptions[0]);
                switch (menuSelection) {
                    case "1. Add tasks":
                        // Add task logic
                        break;
                    case "2. Show report":
JOptionPane.showMessageDialog(null, "Coming soon...");
                        break;
                    case "3. Quit":
                        System.exit(0);
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }

    }

