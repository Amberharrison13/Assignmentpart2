/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentpart2;

/**
 *
 * @author RC_Student_lab
 */
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

    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }
    
    public String getTaskDescription(){
        return taskDescription;
    }

    public String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskNamePrefix = taskName.substring(0, 2).toUpperCase();
        String developerSuffix = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskNamePrefix + ":" + taskNumber + ":" + developerSuffix;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task Duration: " + taskDuration + " hours\n" +
               "Task ID: " + taskID;
    }

public double returnTotalHours() {
        return taskDuration;
    }

}
