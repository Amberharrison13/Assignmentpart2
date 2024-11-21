package com.mycompany.poepart3;

public class Task {
    private static int taskCounter = 0; // Static counter for auto-generating task numbers
    private String taskID;
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developer;
    private double taskDuration;
    private String status;

    public Task(String taskName, String taskDescription, String developer, double taskDuration, String status, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developer = developer;
        this.taskDuration = taskDuration;
        this.status = status;
        this.taskNumber = taskNumber; // Set the task number here
        this.taskID = createTaskID(); // Create the Task ID
    }

    // Getter methods
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloper() {
        return developer;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    public String getStatus() {
        return status;
    }

    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String taskPrefix = taskName.length() >= 2
            ? taskName.substring(0, 2).toUpperCase()
            : taskName.toUpperCase();
    
        String[] nameParts = developer.split(" ");
        String firstName = nameParts[0];
    
        String developerSuffix = firstName.length() >= 3
            ? firstName.substring(firstName.length() - 3).toUpperCase()
            : firstName.toUpperCase();
    
        return taskPrefix + ":" + taskNumber + ":" + developerSuffix;
    }
    

    public String printTaskDetails() {
        return "Task ID: " + taskID + "\n" +
               "Task Status: " + status + "\n" +
               "Developer Details: " + developer + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task Duration: " + taskDuration + " hours\n";
    }

    public double returnTotalHours() {
        return taskDuration;
    }
}
