/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentpart2;

import java.util.List;
import javax.swing.JOptionPane;

public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, double taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID(taskName, taskNumber, developerDetails);
        this.taskStatus = taskStatus;
    }

    // Method to create a task ID
    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNamePrefix = taskName.substring(0, 2).toUpperCase();
        String developerSuffix = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task Duration: " + taskDuration + " hours\n" +
               "Task ID: " + taskID;
    }

    // Method to return total hours (duration)
    public double returnTotalHours() {
        return taskDuration;
    }

    // Search task by name
    public static Task searchTaskByName(List<Task> tasksList, String taskName) {
        for (Task task : tasksList) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                return task;
            }
        }
        return null;
    }

    // Delete task by name
    public static boolean deleteTaskByName(List<Task> tasksList, String taskName) {
        for (Task task : tasksList) {
            if (task.taskName.equalsIgnoreCase(taskName)) {
                tasksList.remove(task);
                return true;
            }
        }
        return false;
    }

    // Find the longest task
    public static Task findLongestTask(List<Task> tasksList) {
        Task longestTask = null;
        double maxDuration = 0;

        for (Task task : tasksList) {
            if (task.taskDuration > maxDuration) {
                maxDuration = task.taskDuration;
                longestTask = task;
            }
        }

        return longestTask;
    }

    // Getter methods
    public String getTaskName() {
        return taskName;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    // Display a report of all tasks
    public static void displayReport(List<Task> tasksList) {
        if (tasksList.isEmpty()) {
            // Display a message if no tasks are available
            JOptionPane.showMessageDialog(null, "No tasks available.");
        } else {
            String report = "";

            // Iterate through each task and append its details to the report string
            for (Task task : tasksList) {
                report += task.printTaskDetails() + "\n----------------------------\n";
            }

            // Display the concatenated report using JOptionPane
            JOptionPane.showMessageDialog(null, report);
        }
    }
}

   

