package com.mycompany.poepart3;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasksList = new ArrayList<>();

    // Constructor
    public TaskManager(int maxTasks) {
        // No need for additional arrays; using a list instead
    }

    // Method to add a task
    public void addTask(String taskName, int taskNumber, String taskDescription, String developer, double taskDuration, String status) {
        Task newTask = new Task(taskName, taskDescription, developer, taskDuration, status, taskNumber);
        tasksList.add(newTask);
    }
    

    // Display Developer, Task Name, and Duration for tasks with status "Done"
    public String displayDoneTasks() {
        StringBuilder result = new StringBuilder();
        for (Task task : tasksList) {
            if ("Done".equalsIgnoreCase(task.getStatus())) {
                result.append("Developer: ").append(task.getDeveloper())
                      .append(", Task Name: ").append(task.getTaskName())
                      .append(", Duration: ").append(task.getTaskDuration()).append("\n");
            }
        }
        return result.length() == 0 ? "No tasks are done." : result.toString();
    }

    // Display Developer and Duration for the task with the longest duration
    public String displayTaskWithLongestDuration() {
        if (tasksList.isEmpty()) {
            return "No tasks available.";
        }

        Task longestTask = tasksList.stream().max((t1, t2) -> Double.compare(t1.getTaskDuration(), t2.getTaskDuration())).orElse(null);

        if (longestTask != null) {
            return "Developer: " + longestTask.getDeveloper() + 
                   ", Duration: " + longestTask.getTaskDuration() + " hours";
        } else {
            return "No tasks available.";
        }
    }

    // Search for a task by name and display Task Name, Developer, and Status
    public String searchTaskByName(String taskName) {
        for (Task task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                return  "Task Name: " + task.getTaskName() + ", " + "Developer: " + task.getDeveloper();
            }
        }

        return "Task not found.";
    }

    // Search all tasks assigned to a developer
    public String searchTasksByDeveloper(String developerName) {
        StringBuilder result = new StringBuilder();
        for (Task task : tasksList) {
            if (task.getDeveloper().equalsIgnoreCase(developerName)) {
                result .append("Task Name: ").append(task.getTaskName()).append("\n");
            }
        }
        return result.length() == 0 
            ? "No tasks found for developer: " + developerName 
            : result.toString().trim();
    }

    // Delete a task by name
    public String deleteTaskByName(String taskName) {
        for (int i = 0; i < tasksList.size(); i++) {
            Task task = tasksList.get(i);
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                tasksList.remove(i);
                return "Entry \"" + taskName + "\" successfully deleted.";
            }
        }

        return "Task not found.";
    }

    // Display a report of all tasks
    public String displayReport() {
        if (tasksList.isEmpty()) {
            return "No tasks to display.";
        }

        StringBuilder report = new StringBuilder("Task Report:\n");
        for (Task task : tasksList) {
            report.append(task.printTaskDetails()).append("\n");
        }
        return report.toString();
    }
}
